package tec.escola.api.domain.professor;

public record DadosDetalhamentoProfessor(Long id, String nome, String telefone, String email, Especialidade especialidade) {

    public DadosDetalhamentoProfessor(Professor professor){
        this(professor.getId(), professor.getNome(), professor.getTelefone(),
                professor.getEmail(), professor.getEspecialidade());
    }
}
