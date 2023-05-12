package br.com.github.heloHobold.virtus.dto.response.customer;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode()
public class CustomerResponseDTO {

    private Long id;

    private String name;

    private String cpf;

    private String email;

    @JsonProperty("phone_number")
    private String phoneNumber;

    @JsonProperty("activity_status")
    private boolean activityStatus;
}
