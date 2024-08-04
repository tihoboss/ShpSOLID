import java.util.ArrayList;
import java.util.List;

class Cart {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void showCart() {
        if (products.isEmpty()) {
            System.out.println("Ваша корзина пуста.");
        } else {
            products.forEach(product -> System.out.println(product.toString()));
        }
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }

    public int getTotalCost() {
        return products.stream().mapToInt(Product::getPrice).sum();
    }

    public void clear() {
        products.clear();
    }
}

