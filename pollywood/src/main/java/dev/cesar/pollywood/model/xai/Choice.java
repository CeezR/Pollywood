package dev.cesar.pollywood.model;

public record Choice(
        int index,
        Message message,
        String finish_reason
) {
}
