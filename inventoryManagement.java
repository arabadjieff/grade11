import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    //product class
    static class Product {
        private String name;
        private double price;
        private int quantity;

        //constructor
        public Product(String name, double price, int quantity) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
        }

        //getter and setter
        public String getName() {
            return name;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public int getQuantity() {
            return quantity;
        }

        //disp prod details, mozhe i po-krasivo da e
        public String displayDetails() {
            return "Name: " + name + ", Price: $" + price + ", Quantity: " + quantity;
        }
    }

    //inv class
    static class Inventory {
        private Product[] products;
        private int count;

        public Inventory() {
            products = new Product[3];
            count = 0;
        }

        //add a prod
        public String addProduct(String name, double price, int quantity) {
            if (price < 0 || quantity < 0) {
                return "Price and quantity must be non-negative.";
            }
            if (count >= 3) {
                return "Inventory is full. Cannot add more products.";
            }
            products[count++] = new Product(name, price, quantity);
            return "Product added successfully!";
        }

        //update a prod
        public String updateProduct(String name, double price, int quantity) {
            if (price < 0 || quantity < 0) {
                return "Price and quantity must be non-negative.";
            }
            for (int i = 0; i < count; i++) {
                if (products[i].getName().equals(name)) {
                    products[i].setPrice(price);
                    products[i].setQuantity(quantity);
                    return "Product updated successfully!";
                }
            }
            return "Product not found.";
        }

        //disp all prods
        public String displayAllProducts() {
            if (count == 0) {
                return "No products in the inventory.";
            }
            String result = "";
            for (int i = 0; i < count; i++) {
                result += products[i].displayDetails() + "\n";
            }
            return result;
        }
    }

    private Inventory inventory;
    private JTextField nameField, priceField, quantityField;
    private JTextArea displayArea;

    public Main() {
        inventory = new Inventory();
        setTitle("Inventory Management System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        //input
        nameField = new JTextField(10);
        priceField = new JTextField(10);
        quantityField = new JTextField(10);

        //buttons
        JButton addButton = new JButton("Add Product");
        JButton updateButton = new JButton("Update Product");
        JButton displayButton = new JButton("Display Products");

        //disp area
        displayArea = new JTextArea(10, 40);
        displayArea.setEditable(false);

        //frame
        add(new JLabel("Name:"));
        add(nameField);
        add(new JLabel("Price:"));
        add(priceField);
        add(new JLabel("Quantity:"));
        add(quantityField);

        add(addButton);
        add(updateButton);
        add(displayButton);
        add(new JScrollPane(displayArea));

        //button actions
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String priceText = priceField.getText();
                String quantityText = quantityField.getText();
                if (name.isEmpty() || priceText.isEmpty() || quantityText.isEmpty()) {
                    displayArea.setText("Please fill in all fields.");
                    return;
                }
                double price = Double.parseDouble(priceText);
                int quantity = Integer.parseInt(quantityText);
                String result = inventory.addProduct(name, price, quantity);
                displayArea.setText(result);
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String priceText = priceField.getText();
                String quantityText = quantityField.getText();
                if (name.isEmpty() || priceText.isEmpty() || quantityText.isEmpty()) {
                    displayArea.setText("Please fill in all fields.");
                    return;
                }
                double price = Double.parseDouble(priceText);
                int quantity = Integer.parseInt(quantityText);
                String result = inventory.updateProduct(name, price, quantity);
                displayArea.setText(result);
            }
        });

        displayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayArea.setText(inventory.displayAllProducts());
            }
        });
    }

    public static void main(String[] args) {
        Main app = new Main();
        app.setVisible(true);
    }
}
