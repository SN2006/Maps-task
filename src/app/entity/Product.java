package app.entity;

import java.util.Objects;

public class Product {

    private final String name;
    private final Double price;
    private final Integer quantity;

    public Product(String name, Double price, Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(quantity, product.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, quantity);
    }

    @Override
    public String toString() {
        return name + ", price: " + price + "$, quantity: " + quantity;
    }
}
