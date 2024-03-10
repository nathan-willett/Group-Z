/**
 * Class that handles all the item orders.
 */

import java.util.ArrayList;
public class ShoppingCart {
    int size; // The maximum number of items that can be added to the cart
    boolean discount = false; // Flag to indicate whether a discount is applied
    ArrayList<LineItem> cartList = new ArrayList<>(); // List to store item orders

    /**
     * Constructs a ShoppingCart with a specified size limit.
     *
     * @param size The maximum number of items allowed in the cart.
     */
    public ShoppingCart(int size) {
        this.size = size;
    }

    /**
     * Adds an item order to the cart. If an order for the same item already exists,
     * it is replaced with the new order.
     *
     * @param order The item order to be added to the cart.
     */
    public void add(LineItem order) {
        for (int i = 1; i <= this.cartList.size(); i++) {
            int index = i - 1;

            if (this.cart.get(index).item.name.equals(order.item.name)) {
                this.cart.remove(index);
            }
        }

        cart.add(order);
    }

    public void setDiscount(boolean value) {
        this.discount = true;
    }

    public double total() {
        double price = 0;
        for (LineItem order : this.cartList) {
            double amount = order.item.priceFor(order.quantity); // Calculate price for each order
            price += amount;
        }

        return price;
    }
}
