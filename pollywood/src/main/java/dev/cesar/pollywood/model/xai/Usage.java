package dev.cesar.pollywood.model;

public record Usage(
        int prompt_tokens,
        int completion_tokens,
        int total_tokens
) {
}
