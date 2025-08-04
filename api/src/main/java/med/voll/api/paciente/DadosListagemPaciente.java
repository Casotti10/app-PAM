package med.voll.api.paciente;

public record DadosListagemPaciente (Long id, String nome, String cpf) {

    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getCpf());
    }

}



