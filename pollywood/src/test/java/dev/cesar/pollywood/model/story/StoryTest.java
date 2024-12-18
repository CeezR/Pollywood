package dev.cesar.pollywood.model.story;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class StoryTest {

    @Test
    void serializationTest() {
        assertDoesNotThrow(() -> {
            new ObjectMapper().readValue(new ClassPathResource("defianceOfTheFall.json").getContentAsString(StandardCharsets.UTF_8), Story.class);
        });
    }

}