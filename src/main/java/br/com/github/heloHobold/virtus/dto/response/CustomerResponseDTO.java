package br.com.github.heloHobold.virtus.dto.response;

import lombok.Data;

@Data
public class CustomerResponseDTO {
    private String id;
    private String name;
    private String cpf;
    private String email;
    private String phoneNumber;
}
