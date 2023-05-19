package br.com.github.heloHobold.virtus.controller;

import br.com.github.heloHobold.virtus.dto.response.order.OrderResponseDTO;
import br.com.github.heloHobold.virtus.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping()
    public ResponseEntity<Page<OrderResponseDTO>> listAllOrders(Pageable pageable) {
        Page<OrderResponseDTO> ordersResponseDTO = orderService.listAll(pageable);
        return ResponseEntity.ok().body(ordersResponseDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> listOrder(@PathVariable Long id) {
        OrderResponseDTO orderResponseDTO = orderService.listById(id);
        return ResponseEntity.ok().body(orderResponseDTO);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> updateOrder(@PathVariable Long id) {
        orderService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
