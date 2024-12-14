package dev.cesar.pollywood;

import java.util.List;

public record XaiRequest(
        List<Message> messages,
        String model,
        boolean stream,
        int temperature
) {
}
