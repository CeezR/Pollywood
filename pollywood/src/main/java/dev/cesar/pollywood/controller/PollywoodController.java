package dev.cesar.pollywood.controller;

import dev.cesar.pollywood.model.Message;
import dev.cesar.pollywood.model.Role;
import dev.cesar.pollywood.model.XaiRequest;
import dev.cesar.pollywood.view.XaiClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class PollywoodController {

    private final XaiClient client;

    public PollywoodController(XaiClient client) {
        this.client = client;
    }

    @GetMapping("/")
    ResponseEntity<Message> promptXai(@RequestBody Message message) {
        XaiRequest request = new XaiRequest(
                List.of(new Message(Role.SYSTEM, "You are Grok, a chatbot inspired by the Hitchhikers Guide to the Galaxy."), message),
                "grok-beta",
                false,
                0
        );
        return ResponseEntity.ok(client.prompt(request));
    }

}
