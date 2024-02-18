/**
 * Starts the program and creates the catalog.
 */

public class ShoppingCartMain {
    public static void main(String[] args) {
        Item pizzaSlice = new Item("Pizza Slice", 1.99);
        Item hotDog = new Item("Hot Dog", 1.50);
        Item pasta = new Item("Pasta", 9.99);
        Item bread = new Item("Bread", 0.99);
        Item chocolate = new Item("Chocolate", 2.99);

        Catalog foodCatalog = new Catalog("Food Catalog", 5);
        foodCatalog.add(pizzaSlice);
        foodCatalog.add(hotDog);
        foodCatalog.add(pasta);
        foodCatalog.add(bread);
        foodCatalog.add(chocolate);

        new ShoppingCartGUI(foodCatalog);
    }
}
