package br.com.alura.api.desafioForumHub.controller.dto.usuario;

import br.com.alura.api.desafioForumHub.domain.repository.RespostaRepository;
import br.com.alura.api.desafioForumHub.domain.repository.TopicoRepository;
import br.com.alura.api.desafioForumHub.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/respostas")
@SecurityRequirement(name = "bearer-key")
public class RespostaController {

    @Autowired
    private final RespostaRepository respostaRepository;
    @Autowired
    private final TopicoRepository topicoRepository;
    @Autowired
    private final UsuarioRepository usuarioRepository;

    public RespostaController(RespostaRepository respostaRepository, TopicoRepository topicoRepository, UsuarioRepository usuarioRepository){
        this.respostaRepository = respostaRepository;
        this.topicoRepository = topicoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public ResponseEntity<RespostaDTO> listarResposta(@RequestParam(value = "page", defaultValue = "0") int page, @RequestParam(value = "pageSize", defaultValue = "10") int pageSize) {
        var respostas = respostaRepository.findAll(PageRequest.of(page, pageSize, Sort.Direction.DESC, "dataAlteracao")).map(resposta ->{
            assert resposta.getTopico() != null;
            return new RespostaItemDTO(resposta.getMensagem(), resposta.getDataCriacao(), resposta.getDataAlteracao(), resposta.getTopico().getTitulo(), resposta.getAutor().getNome(), resposta.getStatus(), resposta.getSolucao());
        });
        return ResponseEntity.ok(new RespostaDTO(respostas.getContent(), page, pageSize, respostas.getTotalPages(), respostas.getTotalElements()));
    }

}
