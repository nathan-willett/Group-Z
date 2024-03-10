/**
 * Represents an order for a specific item, including the item and the quantity ordered.
 * This class is used to track the details of items ordered by a customer.
 */
public class LineItem {
    Item item; // The item being ordered
    int quantity; // The quantity of the item ordered

    /**
     * Constructs an ItemOrder with the specified item and quantity.
     *
     * @param item The item being ordered
     * @param quantity The quantity of the item being ordered
     */
    public LineItem(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
}
