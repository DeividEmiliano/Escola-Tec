package tec.escola.api.domain.professor;

public record DadosDescricaoProfessor(Long id, String nome, String telefone, String email, Especialidade especialidade) {
    public DadosDescricaoProfessor(Professor professor) {
        this(professor.getId(), professor.getNome(), professor.getTelefone(),
                professor.getEmail(), professor.getEspecialidade());
    }
}
