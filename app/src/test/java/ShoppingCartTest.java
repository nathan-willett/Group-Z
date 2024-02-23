/*
This is a simple program to test you ShoppingCart class. Make sure you place it in the same folder 
as ShoppingCart.java, ItemOrder.java and Item.java.

This test program requires that Item.java and ItemOrder.java are working correctly. 

This program creates two ShoppingCarts and calls add, setDiscout and getTotal methods, comparing 
the results to expected values. If your ShoppingCart method returns something incorrect this 
program will output your returned value and the expected output so that you can compare them. 
*/

public class ShoppingCartTest {
   public static void main(String[] args) {
      test(6);
      test(10);
   }
   
   // Creates a Shopping cart of the passed in size and tests each of its methods
   public static void test(int size) {
      ShoppingCart cart = new ShoppingCart(size);
      
      cart.add(new ItemOrder(new Item("kiwi", .54), 1));
      cart.add(new ItemOrder(new Item("orange", 2.5), 2));
      cart.add(new ItemOrder(new Item("banana", .99, 5, 2.0), 12)); 
      Item peach = new Item("Peach", 1.33, 4, 4.0);
      cart.add(new ItemOrder(peach, 6));
      
      System.out.println("added 1 kiwi, $0.54");
      System.out.println("added 2 orange, $2.50");
      System.out.println("added 12 banana, $0.99 (5 for $2.00)");
      System.out.println("added 6 Peach, $1.33 (4 for $4.00)");
      
      testGetTotal(cart, 18.18);
      
      cart.setDiscount(true);
      System.out.println("setDiscount(true)");
      testGetTotal(cart, 16.362000000000002);
      
      cart.setDiscount(false);
      System.out.println("setDiscount(false)");
      testGetTotal(cart, 18.18);
      
      cart.add(new ItemOrder(new Item("nectarine", 1.50), 3));
      System.out.println("added 3 nectarine, $1.50");
      testGetTotal(cart, 22.68);
      
      cart.add(new ItemOrder(peach, 0));
      System.out.println("added 0 Peach, $1.33 (4 for $4.00)");
      testGetTotal(cart, 16.02);
      System.out.println();
}
   
   // Tests the getTotal method of the passed in ShoppingCart by calling it and comparing the 
   // result to the passed in expected value. If they match outputs a success message, otherwise, 
   // outputs a failure message and the expected and received outputs. 
   public static void testGetTotal(ShoppingCart cart, double expected) {
      if(cart.getTotal() == expected) {
         System.out.println("getTotal correct");
      } else {
         System.out.println("getTotal returned: " + cart.getTotal() + 
                              " but should have returned " + expected);
      }
   }
}