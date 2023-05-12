package br.com.github.heloHobold.virtus.service;

import br.com.github.heloHobold.virtus.dto.request.customer.CustomerEditRequestDTO;
import br.com.github.heloHobold.virtus.dto.request.customer.CustomerRegisterRequestDTO;
import br.com.github.heloHobold.virtus.dto.response.customer.CustomerResponseDTO;
import br.com.github.heloHobold.virtus.entity.CustomerEntity;
import br.com.github.heloHobold.virtus.repository.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CustomerResponseDTO add(CustomerRegisterRequestDTO customerRegisterRequestDTO){
        CustomerEntity customerEntity = modelMapper.map(customerRegisterRequestDTO, CustomerEntity.class);
        customerRepository.save(customerEntity);
        return modelMapper.map(customerEntity, CustomerResponseDTO.class);
    }

    public Page<CustomerResponseDTO> listAll(Pageable pageable) {
        Page customers = customerRepository.findAll(pageable);
        return customers.map(customerEntity -> modelMapper.map(customerEntity, CustomerResponseDTO.class));
    }

    public CustomerResponseDTO listById(Long id) {
        CustomerEntity customerEntity = customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return modelMapper.map(customerEntity, CustomerResponseDTO.class);
    }

    public CustomerResponseDTO update(CustomerEditRequestDTO customerEditRequestDTO, Long id){
        CustomerEntity customerEntity = customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        modelMapper.map(customerEditRequestDTO, customerEntity);
        customerRepository.save(customerEntity);
        return modelMapper.map(customerEntity, CustomerResponseDTO.class);
    }

    public void delete(Long id){
        customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        customerRepository.deleteById(id);
    }
}
