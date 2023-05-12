package br.com.github.heloHobold.virtus.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "customers")
@Entity(name = "Customer")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "cpf")
    private String cpf;

    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "activity_status")
    private boolean activityStatus = true;
}
