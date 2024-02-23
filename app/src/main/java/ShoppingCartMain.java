/**
 * The ShoppingCartMain class serves as the entry point to the shopping cart application.
 * It initializes a catalog of items that are available for purchase, including bulk-eligible items.
 * 
 * Bulk-eligible items have special pricing when purchased in certain quantities. Currently,
 * bread and chocolate are bulk-eligible items, with specific discounts applied for bulk purchases.
 */
public class ShoppingCartMain {
    public static void main(String[] args) {
        // Define all items for the catalog
        Item pizzaSlice = new Item("Pizza Slice", 1.99);
        Item hotDog = new Item("Hot Dog", 1.50);
        Item pasta = new Item("Pasta", 9.99);

        // Bread and Chocolate have special bulk pricing
        Item bread = new Item("Bread", 0.99, 10, 0.79);
        Item chocolate = new Item("Chocolate", 2.99, 5, 2.49);

        // Instantiate the catalog and add the food items to it
        Catalog foodCatalog = new Catalog("Food Catalog", 5);
        
        foodCatalog.add(pizzaSlice);
        foodCatalog.add(hotDog);
        foodCatalog.add(pasta);
        foodCatalog.add(bread);
        foodCatalog.add(chocolate);

        // Initialize the GUI
        new ShoppingCartGUI(foodCatalog);
    }
}
