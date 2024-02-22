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
