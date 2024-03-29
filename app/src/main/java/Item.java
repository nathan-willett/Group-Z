import java.text.DecimalFormat;

/**
 * Represents an item that can be purchased. This class supports both individual
 * and bulk pricing models.
 */
public class Item {
    String name; // The name of the item
    double price; // The price of the item when not purchased in bulk
    int bulk_quantity; // The minimum number of units required for an item to qualify for bulk pricing
    double bulk_price; // The price per unit when the item is purchased in bulk

    DecimalFormat format = new DecimalFormat("$#.00"); // Format for displaying prices

    /**
     * Constructs an item that does not offer bulk pricing.
     *
     * @param name  The name of the item
     * @param price The price of the item
     */
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Constructs an item that offers bulk pricing.
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

    /** Retrieves the name of the item */
    public String getName() {
        return this.name;
    }
    
    /**
     * Calculates the price for a specified quantity of the item, considering bulk
     * pricing.
     *
     * @param quantity The quantity of items to be purchased
     * @return The total price for the specified quantity of items
     */
    public double priceFor(int quantity) {
        if (this.bulk_quantity > 0) {
            // Calculate the total for the bulk-eligible portion
            int bulkPortion = quantity / this.bulk_quantity * this.bulk_quantity; // Total bulk-eligible units
            double bulkTotalPrice = bulkPortion * this.bulk_price; // Total price for bulk portion

            // Calculate the total for the remainder at the regular price
            int remainder = quantity % this.bulk_quantity; // Units not eligible for bulk pricing
            double remainderPrice = remainder * this.price; // Price for remainder units

            // Return the total price combining bulk and non-bulk portions
            return bulkTotalPrice + remainderPrice;
        } else {
            /* If bulk pricing does not apply or if the item is not eligible for bulk pricing
            (bulk_quantity is 0), calculate the total at the regular price */
            return quantity * this.price;
        }
    }

    /**
     * Returns a string representation of the item, including its name, price,
     * and bulk pricing details if applicable.
     * 
     * Example output without bulk pricing: "ItemName, $9.99"
     * Example output with bulk pricing: "ItemName, $9.99 (5 @ $8.99 ea.)"
     *
     * @return A string description of the item
     */
    @Override
    public String toString() {
        this.format.setMinimumFractionDigits(2);
        if (this.bulk_quantity == 0 && this.bulk_price == 0) {
            return name + ", " + this.format.format(this.price);
        }
        return name + ", " + this.format.format(this.price) + " (" + this.bulk_quantity + " @ "
                + this.format.format(this.bulk_price) + " ea.)";
    }
}
