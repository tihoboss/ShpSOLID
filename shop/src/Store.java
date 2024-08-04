//Принцип инверсии зависимостей

import java.util.ArrayList;
import java.util.List;

interface FunctionStore {
    void addProduct(Product product);

    void showAvailableProducts();

    Product getProductByName(String name);

    List<Product> getAvailableProducts();
}

public class Store implements FunctionStore {
    private final List<Product> availProducts = new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        availProducts.add(product);
    }

    @Override
    public void showAvailableProducts() {
        availProducts.forEach(product -> System.out.println(product.toString()));
    }

    @Override
    public Product getProductByName(String name) {
        for (Product product : this.availProducts) {
            if (product.getName().equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> getAvailableProducts() {
        return availProducts;
    }
}