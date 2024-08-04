// Принцип разделения интерфейса
interface Payment {
    void pay(int amount);
}

class CardPayment implements Payment {
    public void pay(int amount) {
        System.out.println("Оплачено кредитной картой: " + amount);
    }
}

class PayPalPayment implements Payment {
    public void pay(int amount) {
        System.out.println("Оплачено через PayPal: " + amount);
    }
}

class CashPayment implements Payment {
    public void pay(int amount) {
        System.out.println("Оплачено наличкой: " + amount);
    }
}

public class PaymentService {
    public boolean processPayment(String paymentMethod, int amount) {
        Payment payment;

        switch (paymentMethod.toLowerCase()) {
            case "карта":
                payment = new CardPayment();
                break;
            case "paypal":
                payment = new PayPalPayment();
                break;
            case "наличка":
                payment = new CashPayment();
                break;
            default:
                System.out.println("Неподдерживаемый способ оплаты: " + paymentMethod);
                return false;
        }

        payment.pay(amount);
        return true;
    }
}
