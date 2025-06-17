package com.learn.lld.baiscs.problem1;

public class Product {
    private String name;
    private double price;
    private String id;

    public Product(String name, double price, String id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    protected void updatePrice(double price) {
        this.price = price;
    }

    protected void updateName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || getClass() != this.getClass()) {
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
