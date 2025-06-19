package com.learn.lld.designPrincipal.level1;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    private Map<Product, Integer> productCart;

    public Cart() {
        this.productCart = new HashMap<>();
    }

    public boolean addProduct(Product product, int quantity) {
        if (product == null || quantity < 0) {
            return false;
        }
        productCart.put(product, productCart.getOrDefault(product, 0) + quantity);
        return true;
    }

    public boolean removeProduct(Product product, int quantity) {
        if (product == null || quantity < 0 || productCart.get(product) == null
                || productCart.getOrDefault(product, 0) < quantity) {
            return false;
        }
        productCart.put(product, productCart.getOrDefault(product, 0) - quantity);
        if (productCart.get(product) == 0) {
            productCart.remove(product);
        }
        return true;
    }

    public Map<Product, Integer> getProductCart() {
        return productCart;

    }

}
