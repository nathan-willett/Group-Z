/**
 * Represents a shopping cart that can hold item orders. This class allows
 * items to be added to the cart, optionally applies a discount, and calculates
 * the total price of items in the cart.
 */

import java.util.ArrayList;

public class ShoppingCart {
    int size; // The maximum number of items that can be added to the cart
    boolean discount = false; // Flag to indicate whether a discount is applied
    ArrayList<ItemOrder> cart = new ArrayList<>(); // List to store item orders

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
    public void add(ItemOrder order) {
        for (int i = 1; i <= this.cart.size(); i++) {
            int index = i - 1;
            if (this.cart.get(index).item.name.equals(order.item.name)) {
                this.cart.remove(index); // Remove the existing order for the same item
            }
        }
        cart.add(order); // Add the new item order
    }

    /**
     * Sets the discount to be applied to the total price calculation.
     *
     * @param value true to apply a discount, false otherwise.
     */
    public void setDiscount(boolean value) {
        this.discount = value;
    }

    /**
     * Calculates the total price of all item orders in the cart.
     *
     * @return The total price of items in the cart.
     */
    public double total() {
        double price = 0;
        for (ItemOrder order : this.cart) {
            double amount = order.item.priceFor(order.quantity); // Calculate price for each order
            price += amount;
        }
        return price; // Return the total price
    }
}
