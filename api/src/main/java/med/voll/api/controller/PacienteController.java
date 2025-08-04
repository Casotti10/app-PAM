package med.voll.api.controller;

// Importações necessárias para validação, controle e transação
import jakarta.validation.Valid;
import med.voll.api.paciente.DadosCadastroPaciente;
import med.voll.api.paciente.DadosListagemPaciente;
import med.voll.api.paciente.Paciente;
import med.voll.api.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController // Indica que essa classe é um controller REST, que responde a requisições HTTP
@RequestMapping("/pacientes") // Define o caminho base para todas as rotas desse controller
public class PacienteController {

    @Autowired // Injeta automaticamente uma instância de PacienteRepository
    private PacienteRepository repository;

    @PostMapping // Mapeia requisições HTTP POST para este metodo
    @Transactional // Garante que todas as operações com o banco sejam feitas em uma transação
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
        var paciente = new Paciente(dados);
        repository.save(paciente);
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(@PageableDefault(page = 0, size = 10, sort = {"nome"}) Pageable paginacao) {
        return repository.findAll(paginacao).map(DadosListagemPaciente::new);
    }
}
