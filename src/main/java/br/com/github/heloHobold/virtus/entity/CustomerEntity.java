package br.com.github.heloHobold.virtus.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Customer")
@Data
public class CustomerEntity {
    private String id;
    private String name;
    private String cpf;
    private String email;
    private String phoneNumber;
}
