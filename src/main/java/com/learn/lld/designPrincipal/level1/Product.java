package com.learn.lld.designPrincipal.level1;

public class Product {
    private String id;
    private String productName;
    private double price;
    private double weight = 1;// this weight is in kg setting default weight to 1 kg

    public Product(String id, String productName, double price) {
        this.id = id;
        this.productName = productName;
        this.price = price;
    }

    public Product(String id, String productName, double price, double weight) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductId() {
        return id;
    }
    public double getProductWeight(){
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product p = (Product) o;
        return id.equals(p.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

}
