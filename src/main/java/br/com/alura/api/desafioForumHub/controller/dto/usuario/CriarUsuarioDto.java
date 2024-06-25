package br.com.alura.api.desafioForumHub.controller.dto.usuario;

public record CriarUsuarioDto(String nome,
                              String email,
                              String login,
                              String senha) {
}
