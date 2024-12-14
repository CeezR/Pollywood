package dev.cesar.pollywood;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class XaiClientTest {

    @Autowired
    XaiClient client;

    @Test
    void propt() {
        client.propt();
    }
}