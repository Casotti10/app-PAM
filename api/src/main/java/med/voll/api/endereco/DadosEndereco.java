package med.voll.api.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

// Record que representa os dados de endereço que serão validados no cadastro de médicos
public record DadosEndereco(

        // Valida se o logradouro (rua, avenida etc.) não é nulo nem vazio
        @NotBlank
        String logradouro,

        // Valida se o bairro não é nulo nem vazio
        @NotBlank
        String bairro,

        // Valida se o CEP não é nulo nem vazio e se contém exatamente 8 dígitos numéricos
        // OBS: tem um erro de espaço no regex — veja correção abaixo
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,

        // Valida se a cidade não é nula nem vazia
        @NotBlank
        String cidade,

        // Valida se a UF (estado) não é nula nem vazia
        @NotBlank
        String uf,

        // Campos opcionais: não precisam de validação, podem ser nulos ou vazios
        String complemento,
        String numero
) {

}
