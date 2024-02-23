// Example ShoppingCartMain
// Change the items added to the catalog to whatever creative items you like
// and re-comment this file before submitting

public class ShoppingCartMain {
    public static void main(String[] args) {
        Catalog list = new Catalog("CS Gift Catalog", 11);
        list.add(new Item("silly putty", 3.95, 10, 19.99));
        list.add(new Item("silly string", 3.50, 10, 14.95));
        list.add(new Item("bottle o bubbles", 0.99));
        list.add(new Item("Nintendo Wii system", 389.99));
        list.add(new Item("Mario Computer Science Party 2 (Wii)", 49.99));
        list.add(new Item("Don Knuth Code Jam Challenge (Wii)", 49.99));
        list.add(new Item("Computer Science pen", 3.40));
        list.add(new Item("Rubik's cube", 9.10));
        list.add(new Item("Computer Science Barbie", 19.99));
        list.add(new Item("'Java Rules!' button", 0.99, 10, 5.0));
        list.add(new Item("'Java Rules!' bumper sticker", 0.99, 20, 8.95));

        ShoppingCartGUI cartGUI = new ShoppingCartGUI(list);
        
    }
}
