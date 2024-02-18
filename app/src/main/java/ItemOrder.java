/**
 * Class that holds data for each item purchased.
 */
public class ItemOrder {
    Item item;
    int quantity;

    public ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
}
