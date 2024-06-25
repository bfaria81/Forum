package br.com.alura.api.desafioForumHub.domain.repository;

import br.com.alura.api.desafioForumHub.domain.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

}
