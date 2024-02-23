/*
This is a simple program to test you Catalog class. Make sure you place it in the same folder 
as Catalog.java and Item.java.

This test program requires that Item.java is working correctly. 

This program creates two Catalogs and calls add, size, get and getName methods, comparing 
the results to expected values. If your Catalog method returns something incorrect this 
program will output your returned value and the expected output so that you can compare them. 
*/

public class CatalogTest {
   public static void main(String[] args) {
      runTests(4);
      runTests(10);
   }
   
   // Creates a Catalog with the passed in capacity and tests each of its
   // methods
   public static void runTests(int size) {
      System.out.println("Creating a Catalog of size " + size);
      Catalog catalog = new Catalog("Fruit Catalog", size);
      testSize(catalog, 0);
      
      catalog.add(new Item("kiwi", .54));
      catalog.add(new Item("orange", 2.5));
      catalog.add(new Item("banana", .99, 5, 2.0)); 
      catalog.add(new Item("Peach", 1.33, 4, 4.0));
      
      testSize(catalog, 4);
      testGetName(catalog, "Fruit Catalog");
     
      String[] expected = {"kiwi, $0.54", "orange, $2.50", "banana, $0.99 (5 for $2.00)", 
                           "Peach, $1.33 (4 for $4.00)"};
      testGet(catalog, expected);
      
      System.out.println();
   }
   
   // Tests the getName method of the passed in catalog by calling it and comparing the result 
   // to the passed in expected value. If they match outputs a success message, otherwise, 
   // outputs a failure message and the expected and received outputs. 
   public static void testGetName(Catalog catalog, String expected) {
      if(catalog.getName() == expected) {
         System.out.println("getName correct");
      } else {
         System.out.println("getName returned: " + catalog.getName() + 
                              " but should have returned " + expected);
      }
   }
   
   // Tests the size method of the passed in catalog by calling it and comparing the result 
   // to the passed in expected value. If they match outputs a success message, otherwise, 
   // outputs a failure message and the expected and received outputs. 
   public static void testSize(Catalog catalog, int expected) {
      if(catalog.size() == expected) {
         System.out.println("size correct");
      } else {
         System.out.println("size returned: " + catalog.size() + 
                              " but should have returned " + expected);
      }
   }
   
   // Tests the get method of the passed in catalog by calling it on each index and comparing the 
   // result to the passed in expected value. If they match outputs a success message, otherwise, 
   // outputs a failure message and the expected and received outputs. 
   public static void testGet(Catalog catalog, String[] expected) {
      for(int i = 0; i < catalog.size(); i++) {
         if(catalog.get(i).toString().equals(expected[i])) {
            System.out.println("get(" + i + ") correct");
         } else {
            System.out.println("get(" + i + ") returned: " + catalog.get(i) + 
                                 " but should have returned " + expected[i]);
         }
      }
   }
}