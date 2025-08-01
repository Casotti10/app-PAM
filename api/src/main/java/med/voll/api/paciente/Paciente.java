package med.voll.api.paciente;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import med.voll.api.endereco.Endereco;

@Entity
@Table(name = "pacientes") // nome da tabela no banco
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String cpf;

    @Embedded
    private Endereco endereco;

    // Construtor recebendo o DTO
    public Paciente(@Valid DadosCadastroPaciente dados) {
        this.nome = dados.nome();
        this.cpf = dados.cpf();
        this.endereco = new Endereco(dados.endereco());
    }

    // Construtor padrão necessário para JPA
    public Paciente() {
    }

    // Getters e Setters (se quiser usar com padrão JavaBean)
}
