package br.com.alura.api.desafioForumHub.controller.dto.curso;

import java.util.List;

public record CursoDTO(
        List<CursoItemDTO> itensDoCurso,
        int pagina,
        int tamanhoDaPagina,
        int totalDePaginas,
        long totalDeElementos){
}
