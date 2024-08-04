//Принцип единственной ответственности

import java.util.Objects;

public class Product {
    private String name;
    private int price;
    private String brand;

    public Product(String name, int price, String brand) {
        this.name = name;
        this.price = price;
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price
                && Objects.equals(name, product.name)
                && Objects.equals(brand, product.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, brand);
    }

    @Override
    public String toString() {
        return " " + name +
                " Цена:" + price +
                " Производитель:" + brand;
    }
}
