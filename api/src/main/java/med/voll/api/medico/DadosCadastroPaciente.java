package med.voll.api.medico;

import med.voll.api.endereco.DadosEndereco;

public record DadosCadastroPaciente(String nome, String DataNascimento, String cpf, DadosEndereco endereco) {
}
