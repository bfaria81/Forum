package br.com.alura.api.desafioForumHub.controller.dto.resposta;

import java.util.List;

public record RespostaDTO(
        List<RespostaItemDTO> itensDaResposta,
        int pagina,
        int tamanhoDaPagina,
        int totalDePaginas,
        long totalDeElementos){
}
