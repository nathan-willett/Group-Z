/*
This is a simple program to test you Item class. Make sure you place it in the same folder 
as Item.java.

This program creates to Items and calls their priceFor and toString methods, comparing the 
results to expected values. If your Item method returns something incorrect this program 
will output your returned value and the expected output so that you can compare them. 
*/

public class ItemTest {
   public static void main(String[] args) {
      Item simpleItem = new Item("orange", 2.5);
      System.out.println("Created simpleItem = Item(\"orange\", 2.5)");
      testPriceFor(1, 2.5, simpleItem);
      testPriceFor(4, 10, simpleItem);
      testToString(simpleItem, "orange, $2.50");
      System.out.println();
      
      Item bulkItem = new Item("banana", .99, 5, 2.0);
      System.out.println("Created bulkItem = Item(\"banana\", .99, 5, 2.0)");
      testPriceFor(1, .99, bulkItem);
      testPriceFor(5, 2.0, bulkItem);
      testPriceFor(6, 2.99, bulkItem);
      testPriceFor(12, 5.98, bulkItem);
      testToString(bulkItem, "banana, $0.99 (5 for $2.00)");
   }
   
   // Tests the priceFor method of the passed in item by calling it passing in the passed in 
   // amount and comparing the result to the passed in expectedPrice. If they match outputs
   // a success message, otherwise, outputs a failure message and the expected and received 
   // outputs. 
   public static void testPriceFor(int amount, double expectedPrice, Item item) {
      if(item.priceFor(amount) != expectedPrice) {
         System.out.println("incorrect price for " + amount + ". Should have been " + 
                              expectedPrice + ", returned " + item.priceFor(amount));
      } else {
         System.out.println("correct price for " + amount);
      }
   }
   
   // Tests the toString method of the passed in item by comparing it to the passed in string of 
   // expected toString output. Prints out a success message if they match and a failure message 
   // including the expected and received outputs if they do not
   public static void testToString(Item item, String expected) {
      if(item.toString().equals(expected)) {
         System.out.println("correct toString output");
      } else {
         System.out.println("toString returned: " + item.toString() + " but should have returned " 
                              + expected);
      }
   }
}