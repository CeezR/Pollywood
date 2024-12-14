package dev.cesar.pollywood;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;


class XaiRequestTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void shouldMapExampleJsonToObj() throws IOException {
        objectMapper.readValue(new ClassPathResource("xaiExampleRequest.json").getContentAsString(StandardCharsets.UTF_8), XaiRequest.class);
    }

}