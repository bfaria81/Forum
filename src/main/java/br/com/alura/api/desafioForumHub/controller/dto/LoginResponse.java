package br.com.alura.api.desafioForumHub.controller.dto;

public record LoginResponse(
        String accessToken,
        Long expiresIn) {
}
