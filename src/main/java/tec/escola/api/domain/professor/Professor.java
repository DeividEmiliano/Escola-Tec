package tec.escola.api.domain.professor;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "Professor")
@Table(name = "professor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private String email;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;
    private boolean ativo;

    public Professor(DadosCadastroProfessor dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.email = dados.email();
        this.especialidade = dados.especialidade();
    }


    public void atualizar(DadosAtualizacaoProfessor dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.email() != null){
            this.email = dados.email();
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}








