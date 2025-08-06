package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import med.voll.api.paciente.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Define que esta classe é um controller REST
@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    // Endpoint para cadastrar um médico (POST /medicos)
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {
        Medico medico = new Medico(dados); // Construtor precisa aceitar DadosCadastroMedico
        repository.save(medico);
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(Pageable paginacao) {
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        Medico medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    public void excluir(@PathVariable Long id){
        repository.deleteById(id);
    }

}
