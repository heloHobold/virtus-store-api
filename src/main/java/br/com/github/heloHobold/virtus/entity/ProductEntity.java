package br.com.github.heloHobold.virtus.entity;

import br.com.github.heloHobold.virtus.enumerated.ProductCategoryEnum;

import java.math.BigDecimal;

public class ProductEntity {
    private Long id;
    private String name;
    private ProductCategoryEnum category;
    private BigDecimal unitValue;
}
