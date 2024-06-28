package br.com.alura.api.desafioForumHub.controller.dto.resposta;

public record EditarRespostaDTO(
        String mensagem,
        Boolean status,
        Boolean solucao) {
}
