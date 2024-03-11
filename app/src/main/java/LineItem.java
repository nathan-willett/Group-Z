/**
 * Represents an order for a specific item, including the item and the quantity ordered.
 * This class is used to track the details of items ordered by a customer.
 */
public class LineItem {
    private final Item item; // The item being ordered
    private final int quantity; // The quantity of the item ordered

    /**
     * Constructs a LineItem with the specified item and quantity.
     *
     * @param item The item being ordered
     * @param quantity The quantity of the item being ordered
     * @throws IllegalArgumentException if item is null or quantity is less than 1
     */
    public LineItem(Item item, int quantity) {
        if (item == null || quantity < 1) {
            throw new IllegalArgumentException("Item cannot be null and quantity must be at least 1.");
        }
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }
}
