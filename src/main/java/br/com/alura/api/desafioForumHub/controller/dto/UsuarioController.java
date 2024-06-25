package br.com.alura.api.desafioForumHub.controller.dto;

import br.com.alura.api.desafioForumHub.controller.dto.usuario.CriarUsuarioDto;
import br.com.alura.api.desafioForumHub.domain.model.Perfil;
import br.com.alura.api.desafioForumHub.domain.model.Usuario;
import br.com.alura.api.desafioForumHub.domain.repository.PerfilRepository;
import br.com.alura.api.desafioForumHub.domain.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private final PerfilRepository perfilRepository;

    public UsuarioController(UsuarioRepository usuarioRepository,
                             PerfilRepository perfilRepository) {
        this.usuarioRepository = usuarioRepository;
        this.perfilRepository = perfilRepository;
    }

    @Transactional
    @PostMapping
    public ResponseEntity<Void> novoUsuario(@RequestBody CriarUsuarioDto dto){

        var perfilusuario = perfilRepository.findByNome(Perfil.Values.USUARIO.name());
        var userFromDb = usuarioRepository.findByLogin(dto.login());

        if(userFromDb.isPresent()){
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        var usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setLogin(dto.login());


        usuarioRepository.save(usuario);

        return ResponseEntity.ok().build();
    }
}
