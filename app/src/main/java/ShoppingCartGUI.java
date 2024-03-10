/**
 * Creates the GUI for the class.
 */

import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;
import java.util.HashMap;

public class ShoppingCartGUI {
    HashMap<Item, JTextField> textFields = new HashMap<>();

    public ShoppingCartGUI(Catalog catalog) {
        ShoppingCart shoppingCart = new ShoppingCart(catalog.size());

        JFrame frame = new JFrame();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);

        Dimension d = new Dimension(350, 400);
        frame.setPreferredSize(d);
        frame.setSize(d);

        JPanel top = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel priceText = new JLabel("Total Order Price: $0.00"); // Initial price text
        priceText.setFont(priceText.getFont().deriveFont(15f)); // Set font size to 15
        top.add(priceText);
        frame.add(top, BorderLayout.NORTH);

        JPanel middle = new JPanel(new GridLayout(10, 1));

        for (int i = 0; i < catalog.size(); i++) {
            JPanel mini = new JPanel();
            JTextField field = new JTextField(4);
            field.setColumns(4);


            JLabel labelItem = new JLabel(catalog.get(i).toString());
            labelItem.setPreferredSize(new Dimension(200, labelItem.getPreferredSize().height));

            this.textFields.put(catalog.get(i), field);

            mini.add(field);
            mini.add(labelItem);
            middle.add(mini, BorderLayout.WEST);
        }

        JScrollPane scrollPane = new JScrollPane(middle);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        JPanel bottomPanel = new JPanel(new FlowLayout());
        JCheckBox checkBox = new JCheckBox();
        JLabel infoLabel = new JLabel("qualify for discount");
        JButton submitButton = new JButton("Calculate Total");

        bottomPanel.add(checkBox);
        bottomPanel.add(infoLabel);
        bottomPanel.add(submitButton);

        frame.add(bottomPanel, BorderLayout.SOUTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setVisible(true);

        DecimalFormat format = new DecimalFormat("$#");
        format.setMinimumFractionDigits(2);

        // Events
        submitButton.addActionListener(e -> {
            double totalPrice = 0.0; // Initialize total price

            // Clear existing items from the shopping cart to prevent accumulation of
            // previous selections
            shoppingCart.clear(); // Assuming there's a clear method in ShoppingCart to remove all items

            // Iterate through each spinner to gather item orders
            for (Item item : spinners.keySet()) {
                JSpinner spinner = spinners.get(item);
                int quantity = (int) spinner.getValue(); // Retrieve the quantity selected for this item

                if (quantity > 0) { // Only process items with a quantity selected
                    LineItem order = new LineItem(item, quantity); // Create an ItemOrder for the selected quantity
                    shoppingCart.add(order); // Add or update the item order in the shopping cart
                }
            }

            for (Item key : this.textFields.keySet()) {
                try {
                    int number = Integer.parseInt(this.textFields.get(key).getText());
                } catch (Exception e2) {
                    this.textFields.get(key).setText("");
                }
            }

            double total = shoppingCart.total();

            if (checkBox.isSelected()) {
                double toSubtract = total * 0.1;
                total -= toSubtract;
            }

            String result = (total == 0.0) ? "$0.00" : format.format(total);

            priceText.setText("Total Order Price: " + result);
        });
    }

}
