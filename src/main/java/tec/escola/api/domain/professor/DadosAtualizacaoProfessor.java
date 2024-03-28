package tec.escola.api.domain.professor;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoProfessor(@NotNull Long id, String nome, String telefone, String email) {
}
