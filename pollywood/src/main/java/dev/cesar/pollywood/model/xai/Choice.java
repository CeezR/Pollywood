package dev.cesar.pollywood.model.xai;

public record Choice(
        int index,
        Message message,
        String finish_reason
) {
}
