package dev.cesar.pollywood;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class AiClient {

    @Value("${xai.api.key}")
    String apiKey;

    public void propt() {
        System.out.println(apiKey);
    }
}
