/**
 * Class that handles the items purchased.
 */

import java.text.DecimalFormat;

public class Item {
    String name;
    double price;
    int bulk_quantity;
    double bulk_price;

    DecimalFormat format = new DecimalFormat("$#");

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Constructs an item that does offer bulk pricing.
     *
     * @param name          The name of the item
     * @param price         The regular price of the item
     * @param bulk_quantity The minimum quantity for bulk pricing
     * @param bulk_price    The price per unit when purchased in bulk
     */
    public Item(String name, double price, int bulk_quantity, double bulk_price) {
        this.name = name;
        this.price = price;
        this.bulk_quantity = bulk_quantity;
        this.bulk_price = bulk_price;
    }

    public double priceFor(int quantity) {
        try { // Try/catch for divison by zero
        if ((quantity % this.bulk_quantity == 0) && this.bulk_quantity > 0) // If the quantity is a multiple of the bulk amount, return the multiple times the bulk price
            return quantity / this.bulk_quantity * this.bulk_price;
        else if (this.bulk_quantity > 0) // Returns the calculated price if the quantity is less than the bulk quantity or if it's not a multiple 
            return (quantity / this.bulk_quantity * this.bulk_price) + (quantity % this.bulk_quantity * this.price);
        else // If the bulk quantity is zero, return the quantity times the price
            return quantity*this.price;
        }
        catch (ArithmeticException e) {
            System.out.print("Cannot divide by zero.\n");
            return 0.0;
        }
    }

    public String toString() {
        this.format.setMinimumFractionDigits(2);


        if (this.bulk_quantity == 0 && this.bulk_price == 0) {
            return name + ", " + this.format.format(this.price);
        }


        return name + ", " + this.format.format(this.price) + " (" + this.bulk_quantity + " for " + this.format.format(this.bulk_price) + ")";
    }
}