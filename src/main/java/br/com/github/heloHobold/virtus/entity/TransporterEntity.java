package br.com.github.heloHobold.virtus.entity;

import br.com.github.heloHobold.virtus.enumerated.CountryRegions;
import java.util.List;

public class TransporterEntity {

    private Long id;
    private String name;
    private AddressEntity address;
    private String phoneNumber;
    private String cnpj;
    private List<CountryRegions> operatingRegions;
    // pedidos
}
