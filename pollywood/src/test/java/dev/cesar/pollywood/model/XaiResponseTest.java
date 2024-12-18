package dev.cesar.pollywood.model;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import dev.cesar.pollywood.TestDataFactory;
import dev.cesar.pollywood.model.xai.XaiResponse;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.assertj.core.api.Assertions.assertThat;

class XaiResponseTest {

    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void endToEndSerialization() throws IOException {
        XaiResponse xaiResponse = TestDataFactory.defaultResponse();
        JsonNode jsonNode = objectMapper.valueToTree(xaiResponse);

        assertThat(jsonNode).hasToString(objectMapper.readTree(new ClassPathResource("xaiExampleResponse.json").getContentAsString(StandardCharsets.UTF_8)).toString());
        assertThat(objectMapper.treeToValue(jsonNode, XaiResponse.class)).isEqualTo(xaiResponse);
    }

}