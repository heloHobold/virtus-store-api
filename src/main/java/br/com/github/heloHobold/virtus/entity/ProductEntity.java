package br.com.github.heloHobold.virtus.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(collection = "Produtc")
@Data
public class ProductEntity {
    private String id;
    private String name;
    private String category;
    private BigDecimal unitValue;
}
