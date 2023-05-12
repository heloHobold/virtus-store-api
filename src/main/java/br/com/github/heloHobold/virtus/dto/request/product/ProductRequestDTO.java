package br.com.github.heloHobold.virtus.dto.request.product;

import br.com.github.heloHobold.virtus.enumerated.ProductCategoryEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
public class ProductRequestDTO {

    @NotBlank
    private String name;

    @NotNull
    private ProductCategoryEnum category;

    @JsonProperty("unit_value")
    @NotNull
    @Positive
    private BigDecimal unitValue;
}
