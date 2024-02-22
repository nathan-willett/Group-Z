# CS& 141, Winter 2024. 
**Programming Assignment: Shopping Cart**

This assignment focuses on defining Java classes and, if you complete the extra credit, creating Java GUIs. 
Turn in the following four files: 
- **Item.java**
- **Catalog.java**
- **ItemOrder.java**
- **ShoppingCart.java**

You will receive up to 4 additional points of extra credit if you also submit
- **ShoppingCartGUI.java**
- **ShoppingCartMain.java**

## Program Description:
Many websites and other computer programs allow a user to buy items by placing those items in a virtual shopping cart. In this assignment you will be writing a set of classes for your own simple shopping cart program. Below is a screenshot of what the program could look like when the user has selected various items to order. 

![image](https://github.com/nathan-willett/Group-Z/assets/28460678/f29ba3eb-c048-41cc-ab86-e4925564b4e2)

Prices are expressed using doubles and quantities are expressed as simple integers (e.g., you can’t buy 2.345 of something). Notice that some of the items have a discount when you buy more. For example, silly putty normally costs $3.95 each, but you can buy 10 for $19.99. These items have, in effect, two prices: a single item price and a bulk item price for a bulk quantity. When computing the price for such an item, apply as many of the bulk quantity as you can and then use the single item price for any leftovers. For example, the user is ordering 12 buttons that cost $0.99 each but can be bought in bulk 10 for $5.00. The first 10 are sold at that bulk price ($5.00) and the two extras are charged at the single item price ($0.99 each) for a total of $6.98.

![image](https://github.com/nathan-willett/Group-Z/assets/28460678/0695f074-ae25-4504-b291-be53b416459e)

At the bottom of the frame you will find a checkbox for an overall discount. If this box is checked, the user is given a 10% discount off the total price. This is computed using simple double arithmetic, computing a price that is 90% of what it would be otherwise. See an example of what happens if we turn on that checkbox to the left.

The order total should only update when the Calculate Total button is pressed. 

You are required to implement four classes to make this program work. You may also implement two additional classes to create a GUI and earn extra credit.

## Required Classes:
### Item Class
The Item class stores information about the individual items.
| Method                       | Description |
| ---------------------------- | ----------- |
| `Item(String name, double price)` | Constructor that takes a name and a price as arguments. |
| `Item(String name, double price, int bulkQuantity, double bulkPrice)` | Constructor that takes a name and a single-item price and a bulk quantity and a bulk price as arguments. |
| `priceFor(int quantity)`     | Returns the price for a given quantity of the item (taking into account bulk price, if applicable). |
| `toString()`                 | Returns a string representation of this item. |

### Catalog Class
The Catalog class stores information about a collection of Items.
| Method                 | Description |
| ---------------------- | ----------- |
| `Catalog(String name, int size)` | Constructor that takes the name of this catalog and the maximum size. |
| `add(Item item)`       | Adds an Item at the end of this list and returns true if there is space. |
| `size()`               | Returns the number of items in this catalog. |
| `get(int index)`       | Returns the Item with the given index. |
| `getName()`            | Returns the name of this catalog. |

### ItemOrder Class
The ItemOrder class stores information about a particular item and the quantity ordered for that Item.
| Method                         | Description |
| ------------------------------ | ----------- |
| `ItemOrder(Item item, int quantity)` | Constructor that creates an item order for the given item and given quantity. |
| `getPrice()` | Returns the cost for this item order. |
| `getItem()` | Returns a reference to the Item in this order. |

### ShoppingCart Class
The ShoppingCart class stores information about the overall order.
| Method                         | Description |
| ------------------------------ | ----------- |
| `ShoppingCart(int size)`       | Constructor that takes the size of the cart as a parameter and creates an empty array of item orders. |
| `add(ItemOrder itemOrder)`     | Adds an item order to the array, replacing any previous order for this item with the new order. |
| `setDiscount(boolean value)`   | Sets whether or not this order gets a discount. |
| `getTotal()`                   | Returns the total cost of the shopping cart. |

## Extra Credit Classes:
### ShoppingCartGUI
The ShoppingCartGUI class represents the graphical user interface for the program.
| Method                       | Description |
| ---------------------------- | ----------- |
| `ShoppingCartGUI(product catalog)` | Constructor takes a Catalog as a parameter. It should display a GUI window matching the components and layout shown on the first page. The number and content of items should match the items in the catalog. You are welcome to change the title, colors, borders, font and text-alignment to whatever you would like. The order total should be displayed in a disabled JTextField. This is very, very similar to the ClassList GUI we created in class. Create this by altering the ClassListGUI in the NetBeans GUI editor. |

### ShoppingCartMain
The ShoppingCartMain class contains the main method from which your program will run. We have
provided an initial version with some sample products added to the catalog. You must replace these items with
items of your own.

## Implementation Guidelines:
You may not introduce any other public methods to these classes, although you can add as many private
methods as you would like. However, you are allowed to redefine toString in any of these classes (you might
find that helpful in testing and debugging your code).

You should use an array to implement the ShoppingCart and Catalog classes.

### Hint 1:
Notice that when you add an ItemOrder to a ShoppingCart, you have to deal with replacing any old order
for the item. A user at one time might request 3 of some item and later change the request to 5 of that item. The
order for 5 replaces the order for 3. The user isn’t requesting 8 of the items in making such a change. The add
method might be passed an item order with a quantity of 0. This should behave just like the others, replacing any
current order for this item or being added to the order list.

### Hint 2:
In the Item class you need to construct a String representation of the price. This isn’t easy to do for a
number of reasons, but Java provides a convenient built-in object that will do it for you. It’s called a
NumberFormat object and it appears in the java.text package (so you need to import java.text.*).
You obtain a formatter by calling the static method called getCurrencyInstance(), as in:

    NumberFormat nf = NumberFormat.getCurrencyInstance();
You can then call the format method of this object passing it the price as a double and it will return a
String with a dollar sign and the price in dollars and cents. For example, you might say:

    double price = 38.5;
    String text = nf.format(price);
This would set the variable text to "$38.50".

## Development Strategy:
This program has a lot more files than our previous assignments so it can feel pretty intimidating at first.
However, most of the classes you need to write are a very small amount of code. We suggest working on this
program in the following order:

**1. Write the Item class.** See Hint 2 for tips on the toString method. Run the provided ItemTest.java program and make sure that your class matches the expected output.

**2. Write the ItemOrder class.** Run the provided ItemOrderTest.java program and make sure that your class matches the expected output.

**3. Write the Catalog class.** Run the provided CatalogTest.java program and make sure that your class matches the expected output.

**4. Write the ShoppingCart class.** Run the provided ShoppingCartTest.java program and make sure that your class matches the expected output. If you find your class failing to pass the tests and you aren’t sure why, take a look at Hint 1.

**5. Write the ShoppingCartGUI class.** You will just need to alter our code from ClassListGUI to work with your other classes and represent a shopping cart.

## Stylistic Guidelines:
Your code should be well-structured and avoid redundancy. If you find yourself writing redundant code or with a very long method, add a private method. You may not add any public methods other than those described in this specification.
<<<<<<< HEAD
Follow past stylistic guidelines about indentation, line lengths, and identifier names. Place a comment at the beginning of your classes, at the start of each method, and on complex sections of code. Use local variables when possible.
=======

Follow past stylistic guidelines about indentation, line lengths, and identifier names. Place a comment at the beginning of your classes, at the start of each method, and on complex sections of code. Use local variables when possible.
>>>>>>> 1757e80c127ed2cb4be2689527f08c4f305eb08c
