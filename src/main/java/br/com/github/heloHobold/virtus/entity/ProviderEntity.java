package br.com.github.heloHobold.virtus.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Provider")
@Data
public class ProviderEntity {
    private String id;
    private String name;
    private String locality;
    private List<ProductEntity> products;
}
