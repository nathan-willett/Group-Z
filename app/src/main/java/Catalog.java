/**
 * Represents a catalog that stores items.
 * A catalog has a name and a predefined size which limits the number of items
 * it can hold.
 */

import java.util.ArrayList;

public class Catalog {
    String name; // The name of the catalog
    int Size; // The maximum number of items the catalog can hold
    ArrayList<Item> cart = new ArrayList<>(); // A list to store the items in the catalog

    /**
     * Constructs a new Catalog instance with the specified name and size.
     *
     * @param name the name of the catalog
     * @param size the maximum number of items the catalog can hold
     */
    public Catalog(String name, int size) {
        this.name = name;
        this.Size = size;
    }

    /**
     * Attempts to add an item to the catalog.
     * 
     * @param item the item to be added
     * @return true if the item was successfully added, false if the catalog is full
     */
    public boolean add(Item item) {
        if (this.cart.size() >= this.Size) {
            return false; // Catalog is full
        }
        this.cart.add(item);
        return true;
    }

    /**
     * Returns the number of items in the catalog.
     * 
     * @return the size of the catalog
     */
    public int size() {
        return this.cart.size();
    }

    /**
     * Retrieves the item at the specified index in the catalog.
     * 
     * @param index the index of the item to retrieve
     * @return the item at the specified index
     */
    public Item get(int index) {
        return cart.get(index);
    }

    /**
     * Gets the name of the catalog.
     * 
     * @return the name of the catalog
     */
    public String getName() {
        return this.name;
    }
}
