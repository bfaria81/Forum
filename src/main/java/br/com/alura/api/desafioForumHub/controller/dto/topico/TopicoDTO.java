package br.com.alura.api.desafioForumHub.controller.dto.topico;


import java.util.List;

public record TopicoDTO(
        List<TopicoItemDTO> itensDoTopico,
        int pagina,
        int tamanhoDaPagina,
        int totalDePaginas,
        long totalDeElementos) {
}
