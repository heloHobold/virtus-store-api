package br.com.github.heloHobold.virtus.dto.request.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
public class CustomerRegisterRequestDTO {

    @NotBlank
    private String name;

    @NotBlank
    @CPF
    private String cpf;

    @Email
    @NotBlank
    private String email;

    @JsonProperty("phone_number")
    @NotBlank
    private String phoneNumber;
}
