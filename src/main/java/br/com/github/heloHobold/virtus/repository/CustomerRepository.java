package br.com.github.heloHobold.virtus.repository;

import br.com.github.heloHobold.virtus.entity.CustomerEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CustomerRepository extends MongoRepository<CustomerEntity, String> {
}
