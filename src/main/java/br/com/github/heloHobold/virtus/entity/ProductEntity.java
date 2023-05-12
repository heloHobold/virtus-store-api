package br.com.github.heloHobold.virtus.entity;

import br.com.github.heloHobold.virtus.enumerated.ProductCategoryEnum;
import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "products")
@Entity(name = "Product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private ProductCategoryEnum category;

    @Column(name = "unit_value")
    private BigDecimal unitValue;
}
