import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.HashMap;

/**
 * Represents the GUI for the shopping cart application.
 */
public class ShoppingCartGUI {
    // Stores the association between catalog items and their corresponding quantity selectors (spinners).
    HashMap<Item, JSpinner> spinners = new HashMap<>();

    /**
     * Constructs the GUI for the shopping cart.
     * 
     * @param catalog The catalog of items available for purchase.
     */
    public ShoppingCartGUI(Catalog catalog) {
        // Initializes shopping cart with the capacity based on the catalog size
        ShoppingCart shoppingCart = new ShoppingCart(catalog.size());

        // Setup the main frame of the GUI
        JFrame frame = new JFrame();
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // Exit the application when the window is closed
        frame.setResizable(false); // Prevent resizing of the frame

        // Set the preferred and actual size of the frame
        Dimension d = new Dimension(350, 400);
        frame.setPreferredSize(d);
        frame.setSize(d);

        // Top panel for displaying the total order price
        JPanel top = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel priceText = new JLabel("Total Order Price: $0.00"); // Initial price text
		priceText.setFont(priceText.getFont().deriveFont(15f)); // Set font size to 15
        top.add(priceText);
        frame.add(top, BorderLayout.NORTH);

        // Middle panel for listing the catalog items
        JPanel middle = new JPanel(new GridLayout(10, 1)); // Adjust the grid layout rows as needed

        for (int i = 0; i < catalog.size(); i++) {
            JPanel mini = new JPanel(); // Mini panel for each catalog item
            // Configure the spinner model (0-100 range with step size of 1)
            SpinnerModel model = new SpinnerNumberModel(0, 0, 100, 1); // Adjust max value as needed
            JSpinner spinner = new JSpinner(model); // Create a spinner with the model
            
            // Set the preferred size of the spinner to make it slightly larger
            spinner.setPreferredSize(new Dimension(60, 25)); // Adjust width and height as needed
            
            Item currentItem = catalog.get(i); // Retrieve the current item
            // Create and configure a label for the item
            JLabel labelItem = new JLabel(currentItem.toString());
            labelItem.setPreferredSize(new Dimension(200, labelItem.getPreferredSize().height));
        
            // Tooltip for bulk pricing, if applicable
            if (currentItem.bulk_quantity > 0) {
                labelItem.setToolTipText("Minimum order of " + currentItem.bulk_quantity + " required for bulk pricing.");
            }
        
            // Store the item and spinner in the HashMap
            this.spinners.put(currentItem, spinner);
        
            // Add spinner and label to the mini panel, and the mini panel to the middle panel
            mini.add(spinner);
            mini.add(labelItem);
            middle.add(mini, BorderLayout.WEST);
        }        
        
        // Make the middle panel scrollable
        JScrollPane scrollPane = new JScrollPane(middle);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        // Bottom panel for the discount checkbox and calculate total button
        JPanel bottomPanel = new JPanel(new FlowLayout());
        JCheckBox checkBox = new JCheckBox(); // Checkbox for discount eligibility
        JLabel infoLabel = new JLabel("Qualify for discount");
        JButton submitButton = new JButton("Calculate Total");
        JButton clearButton = new JButton("Clear Quantities"); // Button to clear spinner values

        // Add components to the bottom panel
        bottomPanel.add(checkBox);
        bottomPanel.add(infoLabel);
        bottomPanel.add(submitButton);
        bottomPanel.add(clearButton); // Add the clear button to the panel

        // Add panels to the frame
        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true); // Make the frame visible

        // DecimalFormat for total price formatting
        DecimalFormat format = new DecimalFormat("$#");
        format.setMinimumFractionDigits(2); // Ensure two decimal places

        // Action listener for the submit button
        submitButton.addActionListener(e -> {
            double totalPrice = 0.0; // Initialize total price

            // Clear existing items from the shopping cart to prevent accumulation of previous selections
            shoppingCart.clear();

            // Iterate through each spinner to gather item orders
            for (Item item : spinners.keySet()) {
                JSpinner spinner = spinners.get(item);
                int quantity = (int) spinner.getValue(); // Retrieve the quantity selected for this item

                if (quantity > 0) { // Only process items with a quantity selected
                    LineItem order = new LineItem(item, quantity); // Create an ItemOrder for the selected quantity
                    shoppingCart.add(order); // Add or update the item order in the shopping cart
                }
            }

            // Apply discount if the discount checkbox is selected
            shoppingCart.setDiscount(checkBox.isSelected());

            // Calculate the total price of the shopping cart
            totalPrice = shoppingCart.total();

            // Update the total order price label
            priceText.setText("Total Order Price: " + format.format(totalPrice));
        });

        clearButton.addActionListener(e -> {
            shoppingCart.clear(); // Clears all item orders in the shopping cart
            clearSpinners(); // Resets all spinners in the GUI
        });
    }

    /**
     * Clears all spinner values, resetting them to their initial value (0).
     */
    private void clearSpinners() {
        for (JSpinner spinner : spinners.values()) {
            spinner.setValue(0); // Reset spinner to initial value
        }
    }
}
