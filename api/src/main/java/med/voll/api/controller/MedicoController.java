package med.voll.api.controller; // Define o pacote onde a classe está localizada

// Importações de anotações do Spring necessárias para criar endpoints REST
import med.voll.api.medico.DadosCadastroMedico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//Define que esta classe é um controller REST (retorna dados diretamente, não páginas HTML)
@RestController

//Define a rota base para esse controller, ou seja, todas as URLs que começarem com "/medicos"
@RequestMapping("medicos")
public class MedicoController {


    @PostMapping
    public void cadastrar(@RequestBody DadosCadastroMedico dados) {
        System.out.println(dados);
    }


}
