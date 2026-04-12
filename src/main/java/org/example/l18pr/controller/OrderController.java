package org.example.l18pr.controller;

import org.example.l18pr.dto.Order;
import org.example.l18pr.dto.Product;
import org.example.l18pr.service.OrderServiceRealisation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/glovo")
public class OrderController {

    private OrderServiceRealisation orderServiceRealisation;

    public OrderController(OrderServiceRealisation orderServiceRealisation) {
        this.orderServiceRealisation = orderServiceRealisation;
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int id) {
        return this.orderServiceRealisation.getOrder(id);
    }

    @PostMapping
    public void addOrder(@RequestBody Order order) {
        this.orderServiceRealisation.addOrder(order);
    }

    @PutMapping("/{id}")
    public void updateOrder(@PathVariable int id, @RequestBody Order order) {
        this.orderServiceRealisation.updateOrder(id, order);
    }

    @PatchMapping("/{id}/products")
    public void addProductToOrder(@PathVariable int id, @RequestBody Product product) {
        this.orderServiceRealisation.addProductToOrder(id, product);
    }

    @DeleteMapping("/{orderId}/products/productId")
    public void removeProductFromOrder(@PathVariable int orderId, @RequestBody int productId) {
        this.orderServiceRealisation.removeProductFromOrder(orderId, productId);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        this.orderServiceRealisation.removeOrder(id);
    }
}