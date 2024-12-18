package dev.cesar.pollywood.controller;

import dev.cesar.pollywood.model.xai.Message;
import dev.cesar.pollywood.model.xai.XaiRequest;
import dev.cesar.pollywood.view.XaiClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PollywoodController {

    private final XaiClient client;

    public PollywoodController(XaiClient client) {
        this.client = client;
    }

    @GetMapping("/")
    ResponseEntity<Message> promptXai(@RequestBody Message message) {
        return ResponseEntity.ok(client.prompt(XaiRequest.withDefault(message)));
    }

}
