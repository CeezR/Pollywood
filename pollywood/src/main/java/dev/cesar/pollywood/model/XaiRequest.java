package dev.cesar.pollywood.model;

import java.util.List;

public record XaiRequest(
        List<Message> messages,
        String model,
        boolean stream,
        int temperature
) {
}
