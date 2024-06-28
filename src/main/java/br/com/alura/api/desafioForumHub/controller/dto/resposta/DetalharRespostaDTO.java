package br.com.alura.api.desafioForumHub.controller.dto.resposta;

import br.com.alura.api.desafioForumHub.domain.model.Resposta;

import java.time.Instant;

public record DetalharRespostaDTO(
        String mensagem,
        Instant dataCriacao,
        Instant dataAlteracao,
        String topico,
        String usuario,
        Boolean status,
        Boolean solucao) {

    public DetalharRespostaDTO(Resposta resposta){
        this(resposta.getMensagem(),
                resposta.getDataCriacao(),
                resposta.getDataAlteracao(),
                resposta.getTopico().getTitulo(),
                resposta.getAutor().getNome(),
                resposta.getStatus(),
                resposta.getSolucao());
    }
}

