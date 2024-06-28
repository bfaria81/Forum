package br.com.alura.api.desafioForumHub.controller;

import br.com.alura.api.desafioForumHub.controller.dto.usuario.CriarUsuarioDto;
import br.com.alura.api.desafioForumHub.domain.model.Perfil;
import br.com.alura.api.desafioForumHub.domain.model.Usuario;
import br.com.alura.api.desafioForumHub.domain.repository.PerfilRepository;
import br.com.alura.api.desafioForumHub.domain.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@PostMapping("/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;
    private final PerfilRepository perfilRepository;
//    private final BCryptPasswordEncoder passwordEncoder;
//
//    public UsuarioController(UsuarioRepository usuarioRepository,
//                             PerfilRepository perfilRepository,
//                             BCryptPasswordEncoder passwordEncoder) {
//        this.usuarioRepository = usuarioRepository;
//        this.perfilRepository = perfilRepository;
//        this.passwordEncoder = passwordEncoder;
//    }

    @Transactional
    @PostMapping
    public ResponseEntity<Void> novoUsuario(@RequestBody CriarUsuarioDto dto) {

        var perfilUsuario = perfilRepository.findByNome(Perfil.Values.USUARIO.name());

        var userFromDb = usuarioRepository.findByLogin(dto.login());
        if (userFromDb.isPresent()) {
            throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        var usuario = new Usuario();
        usuario.setNome(dto.nome());
        usuario.setEmail(dto.email());
        usuario.setLogin(dto.login());
        usuario.setSenha(passwordEncoder.encode(dto.senha()));
        usuario.setPerfis(Set.of(perfilUsuario));

        usuarioRepository.save(usuario);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    @PreAuthorize("hasAuthority('SCOPE_ADMIN')")
    public ResponseEntity<List<Usuario>> listarUsuarios() {
        var usuarios = usuarioRepository.findAll();
        return ResponseEntity.ok(usuarios);
    }
