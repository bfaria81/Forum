package br.com.alura.api.desafioForumHub.controller.dto.topico;

import br.com.alura.api.desafioForumHub.domain.model.Resposta;
import br.com.alura.api.desafioForumHub.domain.model.Topico;

import java.time.Instant;
import java.util.List;

public record DetalharTopicoDTO(
        String titulo,
        String mensagem,
        Instant dataCriacao,
        String status,
        String autor,
        String curso,
        List<Resposta> respostas) {

    public DetalharTopicoDTO(Topico topico){
        this(topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus() != null ? topico.getStatus().toString() : "Status não especificado",
                topico.getAutor().getNome(),
                topico.getCurso().getNome(),
                topico.getRespostas());
    }
}
