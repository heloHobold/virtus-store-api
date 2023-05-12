package br.com.github.heloHobold.virtus.dto.response.product;

import br.com.github.heloHobold.virtus.enumerated.ProductCategoryEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
public class ProductResponseDTO {

    private Long id;

    private String name;

    private ProductCategoryEnum category;

    @JsonProperty("unit_value")
    private BigDecimal unitValue;
}
