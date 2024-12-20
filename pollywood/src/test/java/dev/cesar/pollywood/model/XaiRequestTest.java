package dev.cesar.pollywood.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.cesar.pollywood.TestDataFactory;
import dev.cesar.pollywood.model.xai.XaiRequest;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;


class XaiRequestTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void endToEndSerialization() throws IOException {
        XaiRequest xaiRequest = TestDataFactory.defaultRequest();
        JsonNode jsonNode = objectMapper.valueToTree(xaiRequest);

        assertThat(jsonNode).isEqualTo(objectMapper.readTree(new ClassPathResource("xaiExampleRequest.json").getContentAsString(StandardCharsets.UTF_8)));
        assertThat(objectMapper.treeToValue(jsonNode, XaiRequest.class)).isEqualTo(xaiRequest);
    }

}