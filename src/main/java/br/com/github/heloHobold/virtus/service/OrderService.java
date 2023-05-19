package br.com.github.heloHobold.virtus.service;

import br.com.github.heloHobold.virtus.dto.response.order.OrderResponseDTO;
import br.com.github.heloHobold.virtus.entity.OrderEntity;
import br.com.github.heloHobold.virtus.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ModelMapper modelMapper;

    public void save() { // TODO fazer os relacionamentos order <-> <itens -> produtos (cascade???)

    }

    public Page<OrderResponseDTO> listAll(Pageable pageable) {
        Page<OrderEntity> orders = orderRepository.findAll(pageable);
        return orders.map(orderEntity -> modelMapper.map(orderEntity, OrderResponseDTO.class));
    }

    public OrderResponseDTO listById(Long id) {
        OrderEntity orderEntity = orderRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return modelMapper.map(orderEntity, OrderResponseDTO.class);
    }

    public void delete(Long id) {
        orderRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        orderRepository.deleteById(id);
    }
}
