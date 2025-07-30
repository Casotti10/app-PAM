package med.voll.api.controller;

// Importações necessárias para validação, controle e transação
import jakarta.validation.Valid;
import med.voll.api.paciente.DadosCadastroPaciente;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController // Indica que essa classe é um controller REST, que responde a requisições HTTP
@RequestMapping("/pacientes") // Define o caminho base para todas as rotas desse controller
public class PacienteController {

    @Autowired // Injeta automaticamente uma instância de PacienteRepository
    private PacienteRepository repository;

    @PostMapping // Mapeia requisições HTTP POST para este método
    @Transactional // Garante que todas as operações com o banco sejam feitas em uma transação
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
        // Cria um novo objeto Paciente com base nos dados recebidos do corpo da requisição
        var paciente = new Paciente(dados);

        // Salva o novo paciente no banco de dados
        repository.save(paciente);
    }
}
