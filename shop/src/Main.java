//Product, Cart - Принцип единственной ответственности
//Filter - Принцип открытости-закрытости
//Payment - принцип разделения интерфейса
//Store - Принцип инверсии зависимости


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Store store = new Store();
        store.addProduct(new Product("Ноутбук", 780, "ABC"));
        store.addProduct(new Product("Телефон", 450, "Live"));
        store.addProduct(new Product("Наушники", 99, "ABC"));
        store.addProduct(new Product("Мышка", 400, "Live"));

        Cart cart = new Cart();
        PaymentService service = new PaymentService();

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        Filter filter = new Filter(store.getAvailableProducts());

        while (!exit) {
            System.out.println("\nВыберете операцию");
            System.out.println("1. Доступные продукты");
            System.out.println("2. Фильтр по цене");
            System.out.println("3. Добавить в корзину");
            System.out.println("4. Просмотр корзины");
            System.out.println("5. Покупка");
            System.out.println("6. Выход");
            System.out.print("Ваш выбор: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    store.showAvailableProducts();
                    break;
                case 2:
                    System.out.println("Диапозон цены от 50 до 8002");
                    ProductFilter priceFilter = new PriceRangeFilter();
                    filter.filterProducts(priceFilter);
                    break;
                case 3:
                    System.out.print("Введите название товара: ");
                    String productName = scanner.nextLine();
                    Product product = store.getProductByName(productName);
                    if (product != null) {
                        cart.addProduct(product);
                        System.out.println("Товар добавлен в корзину.");
                    } else {
                        System.out.println("Товар не найден");
                    }
                    break;
                case 4:
                    cart.showCart();
                    break;
                case 5:
                    if (!cart.isEmpty()) {
                        int total = cart.getTotalCost();
                        System.out.printf("Общая стоимость: %d%n", total);
                        System.out.print("Выберите способ оплаты (карта, paypal или наличка): ");
                        String paymentMethod = scanner.nextLine();
                        if (service.processPayment(paymentMethod, total)) {
                            cart.clear();
                            System.out.println("Оплата прошла успешно! Спасибо за заказ!");
                        } else {
                            System.out.println("Оплата не прошла. Попробуйте снова.");
                        }
                    } else {
                        System.out.println("Ваша корзина пустая");
                    }
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}