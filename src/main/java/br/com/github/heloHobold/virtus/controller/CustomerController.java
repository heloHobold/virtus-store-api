package br.com.github.heloHobold.virtus.controller;

import br.com.github.heloHobold.virtus.dto.request.customer.CustomerEditRequestDTO;
import br.com.github.heloHobold.virtus.dto.request.customer.CustomerRegisterRequestDTO;
import br.com.github.heloHobold.virtus.dto.response.customer.CustomerResponseDTO;
import br.com.github.heloHobold.virtus.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CustomerResponseDTO> addCustomer(@RequestBody @Valid CustomerRegisterRequestDTO customerRegisterRequestDTO) {
        CustomerResponseDTO customerResponseDTO = customerService.add(customerRegisterRequestDTO);
        return ResponseEntity.ok(customerResponseDTO);
    }

    @GetMapping
    public ResponseEntity<Page<CustomerResponseDTO>> listAllCustomers(Pageable pageable) {
        Page<CustomerResponseDTO> customersResponseDTO = customerService.listAll(pageable);
        return ResponseEntity.ok(customersResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> listCustomer(@PathVariable Long id) {
        CustomerResponseDTO customerResponseDTO = customerService.listById(id);
        return ResponseEntity.ok(customerResponseDTO);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CustomerResponseDTO> updateCustomer(@RequestBody @Valid CustomerEditRequestDTO customerEditRequestDTO, @PathVariable Long id){
        CustomerResponseDTO customerResponseDTO = customerService.update(customerEditRequestDTO, id);
        return ResponseEntity.ok(customerResponseDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
