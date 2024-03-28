package tec.escola.api.domain.professor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosCadastroProfessor(
        @NotBlank
        String nome,
        @NotBlank
        String telefone,
        @NotBlank
        String email,
        @NotNull
        Especialidade especialidade) {
}
