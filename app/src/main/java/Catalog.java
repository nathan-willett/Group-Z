/**
 * Class that holds all the catalog information.
 */

import java.util.ArrayList;
public class Catalog {
    String name;
    int Size;
    ArrayList<Item> cart = new ArrayList<>();


    public Catalog(String name, int size) {
        this.name = name;
        this.Size = size;
    }

    public boolean add(Item item) {
        if (this.cart.size() >= this.Size) {

            return false;
        }

        this.cart.add(item);

        return true;
    }

    public int size() {
        return this.cart.size();
    }

    public Item get(int index) {
        return cart.get(index);
    }

    public String getName() {
        return this.name;
    }
}
