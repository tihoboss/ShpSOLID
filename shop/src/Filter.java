//Принцип открытости-закрытости

import java.util.ArrayList;
import java.util.List;

interface ProductFilter {
    List<Product> filter(List<Product> products);
}

class PriceRangeFilter implements ProductFilter {
    private static final int minPrice = 50;
    private static final int maxPrice = 800;

    @Override
    public List<Product> filter(List<Product> products) {
        List<Product> filteredProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getPrice() >= minPrice && product.getPrice() <= maxPrice) {
                filteredProducts.add(product);
            }
        }
        return filteredProducts;
    }
}

class Filter {
    private final List<Product> availProducts;

    public Filter(List<Product> availProducts) {
        this.availProducts = availProducts;
    }

    public void filterProducts(ProductFilter filter) {
        List<Product> filteredProducts = filter.filter(availProducts);
        if (filteredProducts.isEmpty()) {
            System.out.println("Нет подходящих товаров");
        } else {
            System.out.println("Отфильтрованные товары:");
            for (Product product : filteredProducts) {
                System.out.println(product);
            }
        }
    }
}