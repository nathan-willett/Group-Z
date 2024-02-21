/**
 * Class that handles the items purchased.
 */

 import java.text.DecimalFormat;

 public class Item {
     String name;
     double price;
     int bulk_quantity; // the minimun number of units required for a lineitem to qualify for bulk pricing
     double bulk_price;
 
     DecimalFormat format = new DecimalFormat("$#");
 
     // constructor for non bulk items
     public Item(String name, double price) {
         this.name = name;
         this.price = price;
     }
 
     // constructor for bulk eligible items
     public Item(String name, double price, int bulk_quantity, double bulk_price) {
         this.name = name;
         this.price = price;
         this.bulk_quantity = bulk_quantity;
         this.bulk_price = bulk_price;
     }
 
     // insufficient for bulk order handling?
     public double priceFor(int quantity) {
         return this.price * quantity;
     }
 
     public String toString() {
         this.format.setMinimumFractionDigits(2);
 
         if (this.bulk_quantity == 0 && this.bulk_price == 0) {
             return name + ", " + this.format.format(this.price);
         }
         
         return name + ", " + this.format.format(this.price) + " (" + this.bulk_quantity + " @ " + this.format.format(this.bulk_price) + " ea.)";
     }
 }