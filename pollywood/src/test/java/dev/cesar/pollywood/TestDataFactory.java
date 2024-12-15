package dev.cesar.pollywood;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.cesar.pollywood.model.XaiRequest;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class TestDataFactory {

    public static XaiRequest defaultRequest() throws IOException {
        return new ObjectMapper().readValue(new ClassPathResource("xaiExampleRequest.json").getContentAsString(StandardCharsets.UTF_8), XaiRequest.class);
    }
}
