package dev.cesar.pollywood;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class XaiClient {

    @Value("${xai.api.key}")
    String apiKey;

    private final RestClient restClient;

    public XaiClient(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.build();
    }

    public String propt() {
        return restClient
                .get()
                .uri("https://api.x.ai/v1/chat/completions")
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .retrieve()
                .body(String.class);

    }
}
