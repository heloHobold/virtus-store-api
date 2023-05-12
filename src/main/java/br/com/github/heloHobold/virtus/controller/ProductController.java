package br.com.github.heloHobold.virtus.controller;

import br.com.github.heloHobold.virtus.dto.request.product.ProductRequestDTO;
import br.com.github.heloHobold.virtus.dto.response.product.ProductResponseDTO;
import br.com.github.heloHobold.virtus.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    @Transactional
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductResponseDTO> addProduct(@RequestBody @Valid ProductRequestDTO productRequestDTO) {
        ProductResponseDTO productResponseDTO = productService.add(productRequestDTO);
        return ResponseEntity.ok(productResponseDTO);
    }

    @GetMapping
    public ResponseEntity<Page<ProductResponseDTO>> listAllProducts(@PageableDefault(size = 10, sort = {"name"}, direction = Sort.Direction.ASC) Pageable pageable) {
        Page<ProductResponseDTO> productsResponseDTO = productService.listAll(pageable);
        return ResponseEntity.ok().body(productsResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> listAllProducts(@PathVariable Long id) {
        ProductResponseDTO productResponseDTO = productService.listById(id);
        return ResponseEntity.ok().body(productResponseDTO);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<ProductResponseDTO> updateProduct(@RequestBody @Valid ProductRequestDTO productRequestDTO, @PathVariable Long id) {
        ProductResponseDTO productResponseDTO = productService.update(productRequestDTO, id);
        return ResponseEntity.ok().body(productResponseDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
