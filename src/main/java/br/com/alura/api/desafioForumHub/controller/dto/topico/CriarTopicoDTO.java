package br.com.alura.api.desafioForumHub.controller.dto.topico;

public record CriarTopicoDTO(
        String titulo,
        String mensagem,
        Integer cursoId) {
}
