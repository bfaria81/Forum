package br.com.alura.api.desafioForumHub.controller.dto.topico;

import java.time.Instant;

public record TopicoItemDTO(
        String titulo,
        String mensagem,
        Instant dataCriacao,
        Boolean status,
        String autor,
        String curso) {
}
