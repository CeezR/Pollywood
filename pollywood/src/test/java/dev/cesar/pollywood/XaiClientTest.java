package dev.cesar.pollywood;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

@RestClientTest(XaiClient.class)
class XaiClientTest {
    @Autowired
    XaiClient client;
    @Autowired
    MockRestServiceServer server;
    @Autowired
    ObjectMapper mapper;

    @Test
    void prompt() throws IOException {
        XaiRequest request = TestDataFactory.defaultRequest();
        String response = new ClassPathResource("xaiExampleResponse.json").getContentAsString(StandardCharsets.UTF_8);

        server.expect(requestTo("https://api.x.ai/v1/chat/completions"))
                .andExpect(method(HttpMethod.GET))
                .andExpect(header("Content-Type", "application/json"))
                .andExpect(content().json(mapper.writeValueAsString(request)))
                .andRespond(withSuccess(response, MediaType.APPLICATION_JSON));

        String actualResponse = client.prompt(request);

        server.verify();

        assertThat(actualResponse).isEqualTo(response);
    }
}