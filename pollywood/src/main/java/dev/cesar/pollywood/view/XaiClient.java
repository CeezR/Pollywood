package dev.cesar.pollywood.view;

import dev.cesar.pollywood.model.xai.Message;
import dev.cesar.pollywood.model.xai.XaiRequest;
import dev.cesar.pollywood.model.xai.XaiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Objects;

@Service
public class XaiClient {

    @Value("${xai.api.key}")
    String apiKey;

    private final RestClient restClient;

    public XaiClient(RestClient.Builder restClientBuilder) {
        this.restClient = restClientBuilder.build();
    }

    public Message prompt(XaiRequest request) {
        return Objects.requireNonNull(restClient
                        .post()
                        .uri("https://api.x.ai/v1/chat/completions")
                        .body(request)
                        .header("Content-Type", "application/json")
                        .header("Authorization", "Bearer " + apiKey)
                        .retrieve()
                        .body(XaiResponse.class))
                .choices()
                .getFirst()
                .message();

    }
}
