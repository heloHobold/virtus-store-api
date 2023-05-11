package br.com.github.heloHobold.virtus.service;

import br.com.github.heloHobold.virtus.dto.request.CustomerRequestDTO;
import br.com.github.heloHobold.virtus.dto.response.CustomerResponseDTO;
import br.com.github.heloHobold.virtus.entity.CustomerEntity;
import br.com.github.heloHobold.virtus.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CustomerResponseDTO add(CustomerRequestDTO customerRequestDTO){
        CustomerEntity customerEntity = modelMapper.map(customerRequestDTO, CustomerEntity.class);
        customerRepository.save(customerEntity);
        return modelMapper.map(customerEntity, CustomerResponseDTO.class);
    }

    public List<CustomerResponseDTO> listAll() {
        List<CustomerEntity> customers = customerRepository.findAll();
        return customers.stream().map(customerEntity ->
                        modelMapper.map(customerEntity, CustomerResponseDTO.class)).collect(Collectors.toList());
    }

    public CustomerResponseDTO listById(String id) {
        CustomerEntity customerEntity = customerRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));

        return modelMapper.map(customerEntity, CustomerResponseDTO.class);
    }

    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO, String id){
        CustomerEntity customerEntity = customerRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND));
        modelMapper.map(customerRequestDTO, customerEntity);
        customerRepository.save(customerEntity);

        return modelMapper.map(customerEntity, CustomerResponseDTO.class);
    }

    public void delete(String id){
        customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        customerRepository.deleteById(id);
    }
}
