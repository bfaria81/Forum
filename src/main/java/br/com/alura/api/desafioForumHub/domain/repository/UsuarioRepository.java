package br.com.alura.api.desafioForumHub.domain.repository;

import br.com.alura.api.desafioForumHub.domain.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Optional<Usuario> findByLogin(String login);

//public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
//    UserDetails findByLogin(String login);
}