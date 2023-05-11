package br.com.github.heloHobold.virtus.controller;

import br.com.github.heloHobold.virtus.dto.request.CustomerRequestDTO;
import br.com.github.heloHobold.virtus.dto.response.CustomerResponseDTO;
import br.com.github.heloHobold.virtus.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<CustomerResponseDTO> addCustomer(@RequestBody @Valid CustomerRequestDTO customerRequestDTO) {
        CustomerResponseDTO customerResponseDTO = customerService.add(customerRequestDTO);
        return ResponseEntity.ok(customerResponseDTO);
    }

    @GetMapping
    public ResponseEntity<List<CustomerResponseDTO>> listAllCustomers() {
        List<CustomerResponseDTO> customersResponseDTO = customerService.listAll();
        return ResponseEntity.ok(customersResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> listCustomer(@PathVariable String id) {
        CustomerResponseDTO customerResponseDTO = customerService.listById(id);
        return ResponseEntity.ok(customerResponseDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CustomerResponseDTO> updateCustomer(@RequestBody @Valid CustomerRequestDTO customerRequestDTO,
                                                              @PathVariable String id){
        CustomerResponseDTO customerResponseDTO = customerService.update(customerRequestDTO, id);
        return ResponseEntity.ok(customerResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id){
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
