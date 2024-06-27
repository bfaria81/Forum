package br.com.alura.api.desafioForumHub.controller.dto.curso;

import java.time.Instant;

public record CursoItemDTO(
        String nome,
        String categoria,
        Instant dataCriacao,
        Instant dataAlteracao,
        Boolean status,
        String usuario

) {
}

