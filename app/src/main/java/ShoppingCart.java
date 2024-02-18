/**
 * Class that handles all the item orders.
 */

import java.util.ArrayList;
public class ShoppingCart {
    int size;
    boolean discount = false;
    ArrayList<ItemOrder> cart = new ArrayList<>();

    public ShoppingCart(int size) {
        this.size = size;
    }

    public void add(ItemOrder order) {
        for (int i = 1; i <= this.cart.size(); i++) {
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

        for (int i = 1; i <= this.cart.size(); i++) {
            int index = i - 1;

            double amount = this.cart.get(index).item.priceFor(this.cart.get(index).quantity);
            price += amount;
        }

        return price;
    }
}
