package br.com.github.heloHobold.virtus.dto.request;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class CustomerRequestDTO {
    @Pattern(regexp = "^[A-Z][A-Za-z ]*$", message = "Apenas letras devem ser usadas")
    @NotBlank
    private String name;
    @NotBlank
    @CPF
    private String cpf;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String phoneNumber;
}
