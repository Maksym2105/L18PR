package org.example.l18pr.dto;

import lombok.Data;

import java.util.List;

@Data

public class Order {
    private int id;
    private List<Product> products;

    public int getId() {
        return id;
    }

    public void setId(int id) {this.id = id;}

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}