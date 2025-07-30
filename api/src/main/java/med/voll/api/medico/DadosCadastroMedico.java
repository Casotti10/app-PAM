package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

// Record que representa os dados necessários para o cadastro de um médico
public record DadosCadastroMedico(

        // Valida se o nome não é nulo nem vazio (aplica-se apenas a Strings)
        @NotBlank
        String nome,

        // Valida se o email não é nulo, vazio e se segue o formato de email válido
        @NotBlank
        @Email
        String email,

        @NotBlank
        String telefone,

        // Valida se o CRM não é nulo, vazio e se contém de 4 a 6 dígitos numéricos
        @NotBlank
        @Pattern(regexp = "\\d{4,6}")
        String crm,

        // Valida se o campo especialidade (enum) não é nulo
        // Usamos @NotNull pois não é uma String (então @NotBlank não se aplica)
        @NotNull
        Especialidade especialidade,

        // Valida se o campo endereco não é nulo e, com @Valid,
        // garante que os campos internos do objeto DadosEndereco também serão validados
        @NotNull @Valid
        DadosEndereco endereco

) {}
