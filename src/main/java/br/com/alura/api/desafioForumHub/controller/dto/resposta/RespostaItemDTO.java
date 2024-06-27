package br.com.alura.api.desafioForumHub.controller.dto.resposta;

import java.time.Instant;

public record RespostaItemDTO(
        String mensagem,
        Instant dataCriacao,
        Instant dataAlteracao,
        String topico,
        String usuario,
        Boolean status,
        Boolean solucao
){

}
