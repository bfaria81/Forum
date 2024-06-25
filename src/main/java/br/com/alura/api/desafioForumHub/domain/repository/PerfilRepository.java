package br.com.alura.api.desafioForumHub.domain.repository;

import br.com.alura.api.desafioForumHub.domain.model.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long> {
    Perfil findByNome(String nome);
}
