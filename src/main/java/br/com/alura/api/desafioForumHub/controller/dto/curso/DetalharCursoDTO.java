package br.com.alura.api.desafioForumHub.controller.dto.curso;

import br.com.alura.api.desafioForumHub.domain.model.Curso;
import br.com.alura.api.desafioForumHub.domain.model.Topico;

import java.util.List;

public record DetalharCursoDTO(
        Long id,
        String nome,
        String categoria,
        List<Topico> topicos,
        String usuario
) {

    public DetalharCursoDTO(Curso curso){
        this(curso.getCursoId(),
                curso.getNome(),
                curso.getCategoria(),
                curso.getTopicos(),
                curso.getUsuario().getNome());
    }

}
