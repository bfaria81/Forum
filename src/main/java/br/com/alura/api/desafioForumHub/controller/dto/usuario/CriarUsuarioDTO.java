package br.com.alura.api.desafioForumHub.controller.dto.usuario;

public record CriarUsuarioDTO(String nome,
                              String email,
                              String login,
                              String senha) {
}
