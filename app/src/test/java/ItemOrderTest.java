/*
This is a simple program to test you ItemOrder class. Make sure you place it in the same folder 
as ItemOrder.java and Item.java.

This test program requires that Item.java is working correctly. 

This program creates two ItemOrders and calls their getPrice and getItem methods, comparing 
the results to expected values. If your ItemOrder method returns something incorrect this 
program will output your returned value and the expected output so that you can compare them. 
*/

public class ItemOrderTest {
   public static void main(String[] args) {
      Item kiwi = new Item("kiwi", .54); 
      ItemOrder order1 = new ItemOrder(kiwi, 3);
      System.out.println("Created ItemOrder(new Item(\"kiwi\", .55), 3)");
      testGetItem(order1, "kiwi, $0.54");
      testGetPrice(order1, 1.62);
      System.out.println();
      
      Item peach = new Item("Peach", 1.33, 4, 4.0);
      ItemOrder order2 = new ItemOrder(peach, 5);
      System.out.println("Created ItemOrder(new Item(\"Peach\", 1.33, 4, 4.0), 3)");
      testGetItem(order2, "Peach, $1.33 (4 for $4.00)");
      testGetPrice(order2, 5.33);
   }
   
   // Tests the getPrice method of the passed in order by calling it and comparing the result 
   // to the passed in expected value. If they match outputs a success message, otherwise, 
   // outputs a failure message and the expected and received outputs. 
   public static void testGetPrice(ItemOrder order, double expected) {
      if(order.getPrice() == expected) {
         System.out.println("getPrice correct");
      } else {
         System.out.println("getPrice returned: " + order.getPrice() + 
                              " but should have returned " + expected);
      }
   }
   
   // Tests the getItem method of the passed in order by calling it and comparing the result 
   // to the passed in expected value. If they match outputs a success message, otherwise, 
   // outputs a failure message and the expected and received outputs. 
   public static void testGetItem(ItemOrder order, String expected) {
      if(order.getItem().toString().equals(expected)) {
         System.out.println("getItem correct");
      } else {
         System.out.println("getItem returned: " + order.getItem().toString() + 
                              " but should have returned " + expected);
      }
   }
}