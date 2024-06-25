package br.com.alura.api.desafioForumHub.domain.repository;

import br.com.alura.api.desafioForumHub.domain.model.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicoRepository extends JpaRepository<Topico, Long> {

}
