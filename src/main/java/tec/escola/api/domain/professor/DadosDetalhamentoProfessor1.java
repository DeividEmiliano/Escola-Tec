package tec.escola.api.domain.professor;

public record DadosDetalhamentoProfessor1(Long id, String nome, String telefone,
                                          String email, Especialidade especialidade) {
    public DadosDetalhamentoProfessor1(Professor professor){
        this(professor.getId(), professor.getNome(), professor.getTelefone(), professor.getEmail(),
                professor.getEspecialidade());
    }
}
