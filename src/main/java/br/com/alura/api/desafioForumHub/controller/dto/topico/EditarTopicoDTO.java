package br.com.alura.api.desafioForumHub.controller.dto.topico;

public record EditarTopicoDTO(
        String titulo,
        String mensagem,
        Integer cursoId,
        Boolean status) {
}
