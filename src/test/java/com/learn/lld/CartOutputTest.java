package com.learn.lld;

import com.learn.lld.baiscs.problem1.Product;
import com.learn.lld.baiscs.problem1.ShoppingCart;

public class CartOutputTest {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 999.99, "P001");
        Product product2 = new Product("Mouse", 29.99, "P002");
        ShoppingCart cart = new ShoppingCart();
        
        cart.addProduct(product1);
        cart.addProduct(product2, 2);
        cart.displayProduct();
    }
}
