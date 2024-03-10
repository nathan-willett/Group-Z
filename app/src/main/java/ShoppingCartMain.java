/**
 * Starts the program and creates the catalog.
 */

public class ShoppingCartMain {
    public static void main(String[] args) {
        Item pizzaSlice = new Item("Pizza Slice", 1.99);
        Item hotDog = new Item("Hot Dog", 1.50);
        Item pasta = new Item("Pasta", 9.99);

        // Bread and Chocolate have special bulk pricing
        Item bread = new Item("Bread", 0.99, 10, 7.90);
        Item chocolate = new Item("Chocolate", 2.99, 5, 12.45);

        // Instantiate the catalog and add the food items to it
        Catalog foodCatalog = new Catalog("Food Catalog", 5);
        foodCatalog.add(pizzaSlice);
        foodCatalog.add(hotDog);
        foodCatalog.add(pasta);
        foodCatalog.add(bread);
        foodCatalog.add(chocolate);

        new ShoppingCartGUI(foodCatalog);
    }
}
