package dev.cesar.pollywood.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.cesar.pollywood.TestDataFactory;
import dev.cesar.pollywood.view.XaiClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


@WebMvcTest(PollywoodController.class)
class PollywoodControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    XaiClient client;

    @Autowired
    ObjectMapper mapper;

    @BeforeEach
    public void init() throws IOException {
        Mockito.when(client.prompt(TestDataFactory.defaultRequest())).thenReturn(TestDataFactory.defaultResponse().choices().getFirst().message());
    }

    @Test
    void promptXai() throws Exception {
        String expectedResponse = mapper.writeValueAsString(TestDataFactory.defaultResponse().choices().getFirst().message());
        String request = mapper.writeValueAsString(TestDataFactory.defaultRequest().messages().get(1));

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/")
                .content(request)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);


        String result = mockMvc.perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().is(200))
                .andReturn()
                .getResponse()
                .getContentAsString();

         assertThat(result).isEqualTo(expectedResponse);
    }
}