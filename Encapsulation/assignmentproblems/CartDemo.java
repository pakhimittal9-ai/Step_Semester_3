class Cart {
    private final String cartId;
    private final double[] prices;
    private int count;

    Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new double[maxItems];
        this.count = 0;
    }

    void addItem(double price) {
        if (count == prices.length) {
            System.out.println("Cart is full");
            return;
        }
        prices[count++] = price;
    }

    // Computed on request, not stored separately
    double getTotal() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

    int getItemCount() {
        return count;
    }

    String getCartId() {
        return cartId;
    }
}

public class CartDemo {
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());          // 500.0
        System.out.println("Items: " + cart.getItemCount());      // 3
    }
}