package dev.cesar.pollywood.view;

import dev.cesar.pollywood.model.XaiRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
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

    public String prompt(XaiRequest request) {
        return restClient
                .method(HttpMethod.GET)
                .uri("https://api.x.ai/v1/chat/completions")
                .body(request)
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + apiKey)
                .retrieve()
                .body(String.class);

    }
}
