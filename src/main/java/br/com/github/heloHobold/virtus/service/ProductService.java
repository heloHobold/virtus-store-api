package br.com.github.heloHobold.virtus.service;

import br.com.github.heloHobold.virtus.dto.request.product.ProductRequestDTO;
import br.com.github.heloHobold.virtus.dto.response.product.ProductResponseDTO;
import br.com.github.heloHobold.virtus.entity.ProductEntity;
import br.com.github.heloHobold.virtus.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ModelMapper modelMapper;

    public ProductResponseDTO add(ProductRequestDTO productRequestDTO) {
        ProductEntity productEntity = modelMapper.map(productRequestDTO, ProductEntity.class);
        productRepository.save(productEntity);
        return modelMapper.map(productEntity, ProductResponseDTO.class);
    }

    public Page<ProductResponseDTO> listAll(Pageable pageable) {
        Page<ProductEntity> products = productRepository.findAll(pageable);
        return products.map(productEntity -> modelMapper.map(productEntity, ProductResponseDTO.class));
    }

    public ProductResponseDTO listById(Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new  ResponseStatusException(HttpStatus.NOT_FOUND));
        return modelMapper.map(productEntity, ProductResponseDTO.class);
    }

    public ProductResponseDTO update(ProductRequestDTO productRequestDTO, Long id) {
        ProductEntity productEntity = productRepository.findById(id).orElseThrow(() -> new  ResponseStatusException(HttpStatus.NOT_FOUND));
        modelMapper.map(productRequestDTO, productEntity);

        productRepository.save(productEntity);
        return modelMapper.map(productEntity, ProductResponseDTO.class);
    }

    public void delete(Long id) {
        productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        productRepository.deleteById(id);
    }
}

