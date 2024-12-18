package dev.cesar.pollywood.model.xai;

public record Usage(
        int prompt_tokens,
        int completion_tokens,
        int total_tokens
) {
}
