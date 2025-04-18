package org.example.l18pr.service;

import org.example.l18pr.dto.Order;
import org.example.l18pr.dto.Product;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceRealisation {

    private Map<Integer, Order> orders;
    private boolean removeProduct;

    public OrderServiceRealisation(Map<Integer, Order> orders) {
        this.orders = orders;
    }

    public Order getOrder(int id){
        Order order = orders.get(id);
        if(order == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Order with id " + id + " already exists");
        }else{
            return order;
        }
    }

    public void addOrder(Order order){
        if(orders.get(order.getId()) != null){
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Cannot add new order");
        }else{
            orders.put(order.getId(), order);
        }
    }

    public void updateOrder(int id, Order order){
        if(order.getId() != id){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot update order");
        }else{
            orders.put(id, order);
        }
    }

    public void addProductToOrder(int id, Product product){
        Order order = orders.get(id);
        if(order != null){
            List<Product> products = new ArrayList<>();
             if(product == null){
                products = new ArrayList<>();
                }
                products.add(product);
                order.setProducts(products);
                orders.put(order.getId(), order);
            }else{
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot add new product");
        }
    }

    public void removeProductFromOrder(int orderId, int productId){
        Order order = orders.get(orderId);
        if(order == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot remove product from order");
        }
        List<Product> products = order.getProducts();

        if(products == null || products.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot remove product from order");
        }

        removeProduct = products.removeIf(product -> product.getProductId() == productId);

        if(!removeProduct){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot remove product from order");
        }

        order.setProducts(products);
        orders.put(orderId, order);
    }

    public void removeOrder(int id){
        if(orders.get(id) != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cannot remove order");
        }else{
            orders.remove(id);
        }
    }
}