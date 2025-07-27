package med.voll.api.controller;

import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// Define que esta classe é um controller REST
@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    // Endpoint para cadastrar um médico (POST /medicos)
    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedico dados) {
        Medico medico = new Medico(dados); // Construtor precisa aceitar DadosCadastroMedico
        repository.save(medico);
    }
}
