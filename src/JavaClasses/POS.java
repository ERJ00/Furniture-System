/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

package JavaClasses;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class POS extends javax.swing.JFrame {

    ArrayList<Product> item = new ArrayList<>();
    ArrayList product_category = new ArrayList<>();
    ArrayList<CustomerData> buyer = new ArrayList<>();
    
    public POS() {
        initComponents();
        retrieve();
        retrieveCustomerData();
    }

    private void add_category(String PC){
        for(Product product : item){
            if(product.getCategory().equals(PC)){
                return;
            }
        }
        product_category.add(PC);
    }
    
    private void add_item(Product data){
       item.add(data);
    }
    
    
    private void retrieve() {
    String filePath = "C:\\Users\\user\\Desktop\\System Project\\Furniture-System\\src\\Database\\products.txt"; // Replace with the actual file path

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;
        Product temp = new Product(); // Create a new instance for each item

        while ((line = reader.readLine()) != null) {
            line = Encryption.decrypt(line);
            String[] arr_line = line.split(" / ");
                temp.setID(Integer.parseInt(arr_line[0].trim()));
                temp.setPrice(Integer.parseInt(arr_line[1].trim()));
                temp.setQuantity(Integer.parseInt(arr_line[2].trim()));
                temp.setProductName(arr_line[3].trim());
                temp.setBrand(arr_line[4].trim());
                temp.setDescription(arr_line[5].trim());
                temp.setCategory(arr_line[6].trim());
                add_category(temp.getCategory());
                temp.setSupplier(arr_line[7].trim());
                temp.setDate(arr_line[8].trim());
                add_item(temp);
                temp = new Product(); // Create a new instance for each item
        }
    }   catch (IOException e) {
        e.printStackTrace();
        }
    }
    
        private void add_custo(CustomerData data){
        buyer.add(data);
        }

    private void retrieveCustomerData() {
    String filePath = "C:\\Users\\user\\Desktop\\System Project\\Furniture-System\\src\\Database\\transaction_history.txt"; // Replace with the actual file path

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;

        while ((line = reader.readLine()) != null) {
            line = Encryption.decrypt(line);
            String[] arr_line = line.split(" / ");
            CustomerData temp = new CustomerData(); // Create a new instance for each item
            temp.setStatus(arr_line[0].trim());
            temp.setName(arr_line[1].trim());
            temp.setBirthday(arr_line[2].trim());
            temp.setContactNumber(arr_line[3].trim());
            temp.setAddress(arr_line[4].trim());
            temp.setProductName(arr_line[5].trim());
            temp.setCategory(arr_line[6].trim());

            try {
                temp.setQuantity(Integer.parseInt(arr_line[7].trim()));
                temp.setTotalPayment(Integer.parseInt(arr_line[8].trim()));
                temp.setPaymentReceived(Integer.parseInt(arr_line[9].trim()));
                temp.setBalance(Integer.parseInt(arr_line[10].trim()));
                temp.setChange(Integer.parseInt(arr_line[11].trim()));
                temp.setID(Integer.parseInt(arr_line[13].trim()));
            } catch (NumberFormatException e) {
                // Handle the exception gracefully (e.g., log the error, skip the item, etc.)
                System.err.println("Error parsing integer value: " + e.getMessage());
                continue; // Skip this item and proceed to the next iteration
            }

            temp.setDate(arr_line[12].trim());
            add_custo(temp);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void save(CustomerData data) {
        try (FileWriter f = new FileWriter("C:\\Users\\user\\Desktop\\System Project\\Furniture-System\\src\\Database\\customers_data.txt", true);
                BufferedWriter b = new BufferedWriter(f);
                PrintWriter p = new PrintWriter(b);) {
            p.println(Encryption.encrypt(data.getStatus() + " / " + data.getName() + " / " + data.getBirthday()+ " / " + data.getContactNumber()+ " / " + data.getAddress()+ " / " + data.getProductName()+ " / " + data.getCategory() + " / " + data.getQuantity()+ " / " + data.getTotalPayment()+ " / " + data.getPaymentReceived()+ " / " + data.getBalance()+ " / " + data.getChange()+ " / " + data.getDate()+ " / " + data.getID()+ " / "));
        } catch (IOException i) {
            i.printStackTrace();
        }
        
        try (FileWriter f = new FileWriter("C:\\Users\\user\\Desktop\\System Project\\Furniture-System\\src\\Database\\transaction_history.txt", true);
                BufferedWriter b = new BufferedWriter(f);
                PrintWriter p = new PrintWriter(b);) {
            p.println(Encryption.encrypt(data.getStatus() + " / " + data.getName() + " / " + data.getBirthday()+ " / " + data.getContactNumber()+ " / " + data.getAddress()+ " / " + data.getProductName()+ " / " + data.getCategory() + " / " + data.getQuantity()+ " / " + data.getTotalPayment()+ " / " + data.getPaymentReceived()+ " / " + data.getBalance()+ " / " + data.getChange()+ " / " + data.getDate()+ " / " + data.getID()+ " / "));
        } catch (IOException i) {
            i.printStackTrace();
        }
        
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\user\\Desktop\\System Project\\Furniture-System\\src\\Database\\products.txt", false);

            for (Product product : item) {
                myWriter.write(Encryption.encrypt(Integer.toString(product.getID()) + " / "));
                myWriter.write(Encryption.encrypt(Integer.toString(product.getPrice()) + " / "));
                myWriter.write(Encryption.encrypt(Integer.toString(product.getQuantity()) + " / "));
                myWriter.write(Encryption.encrypt(product.getProductName() + " / "));
                myWriter.write(Encryption.encrypt(product.getBrand() + " / "));
                myWriter.write(Encryption.encrypt(product.getDescription() + " / "));
                myWriter.write(Encryption.encrypt(product.getCategory() + " / "));
                myWriter.write(Encryption.encrypt(product.getSupplier() + " / "));
                myWriter.write(Encryption.encrypt(product.getDate() + " / ") + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
        public boolean checkID(int id){
            for (CustomerData customer : buyer){
                if (customer.getID()== id){
                    return true;
                }
            }
            return false;
        }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        backButton = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel15 = new javax.swing.JLabel();
        category = new javax.swing.JComboBox<>();
        selected_quantity = new javax.swing.JLabel();
        product_item = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        product_quantity = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        address = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        total_payment = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        unit_price = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        change = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        payment = new javax.swing.JTextField();
        birthday = new javax.swing.JTextField();
        contact = new javax.swing.JTextField();
        add_button = new javax.swing.JButton();
        name = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Point of Sale");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Point of sale");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 800, 40));

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Back_button.png"))); // NOI18N
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel4.setBackground(new java.awt.Color(0, 36, 66));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Select Category           :");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 230, 30));

        category.setBackground(new java.awt.Color(153, 153, 153));
        category.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        category.setForeground(new java.awt.Color(255, 255, 255));
        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });
        jPanel4.add(category, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 180, 30));

        selected_quantity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        selected_quantity.setForeground(new java.awt.Color(255, 255, 255));
        selected_quantity.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        selected_quantity.setText("0");
        jPanel4.add(selected_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 120, 60, 30));

        product_item.setBackground(new java.awt.Color(153, 153, 153));
        product_item.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        product_item.setForeground(new java.awt.Color(255, 255, 255));
        product_item.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                product_itemActionPerformed(evt);
            }
        });
        jPanel4.add(product_item, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, 180, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setText("Select Product             :");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 230, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Balance                         :");
        jPanel4.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 230, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Name                             :");
        jPanel4.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 230, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Contact No.                   :");
        jPanel4.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 230, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Birthday                        :");
        jPanel4.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 230, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Address                          :");
        jPanel4.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 390, 230, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Payment Received      :");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 230, 30));

        product_quantity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        product_quantity.setForeground(new java.awt.Color(255, 255, 255));
        product_quantity.setText("0");
        jPanel4.add(product_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 110, 170, 30));

        jButton1.setBackground(new java.awt.Color(51, 51, 51));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("-");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 120, 50, 30));

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("+");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 120, 50, 30));

        address.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel4.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 390, 200, 30));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Available Quantity      :");
        jPanel4.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 230, 30));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Total Payment             :");
        jPanel4.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 230, 30));

        balance.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        balance.setForeground(new java.awt.Color(255, 255, 255));
        balance.setText("0");
        jPanel4.add(balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 170, 30));

        total_payment.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        total_payment.setForeground(new java.awt.Color(255, 255, 255));
        total_payment.setText("0");
        jPanel4.add(total_payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 150, 170, 30));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Select Quantity :");
        jPanel4.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 190, 30));

        unit_price.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        unit_price.setForeground(new java.awt.Color(255, 255, 255));
        unit_price.setText("0");
        jPanel4.add(unit_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 30, 110, 30));

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setText("Unit Price :");
        jPanel4.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 30, 110, 30));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Status   :");
        jPanel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 190, 80, 30));

        status.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        status.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 190, 110, 30));

        change.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        change.setForeground(new java.awt.Color(255, 255, 255));
        change.setText("0");
        jPanel4.add(change, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 230, 110, 30));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("mm/dd/yyyy");
        jPanel4.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 310, 120, 30));

        payment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        payment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                paymentKeyPressed(evt);
            }
        });
        jPanel4.add(payment, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 190, 200, 30));

        birthday.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel4.add(birthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 310, 200, 30));

        contact.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel4.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 200, 30));

        add_button.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        add_button.setForeground(new java.awt.Color(255, 255, 255));
        add_button.setText("OK");
        add_button.setContentAreaFilled(false);
        add_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                add_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                add_buttonMouseExited(evt);
            }
        });
        add_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                add_buttonActionPerformed(evt);
            }
        });
        jPanel4.add(add_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 390, 100, 40));

        name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel4.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 270, 200, 30));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Change :");
        jPanel4.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 90, 30));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 720, 440));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/BG.jpeg"))); // NOI18N
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        Main main = new Main();
        main.show();
        dispose();
    }//GEN-LAST:event_backButtonMouseClicked

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
        ArrayList prod_items = new ArrayList<>();
        System.out.println(category.getSelectedItem());
        
        for(Product product : item){
            if(product.getCategory().equals(category.getSelectedItem()) && product.getQuantity() > 0){
                prod_items.add(product.getProductName());
            }
        }
        DefaultComboBoxModel mod = new DefaultComboBoxModel(prod_items.toArray());
        product_item.setModel(mod);
        product_item.setSelectedItem(null);
    }//GEN-LAST:event_categoryActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        DefaultComboBoxModel mod = new DefaultComboBoxModel(product_category.toArray());
        category.setModel(mod);
        category.setSelectedItem(null);
    }//GEN-LAST:event_formWindowOpened

    private void product_itemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_product_itemActionPerformed
        if (product_item.getSelectedItem() == null){
            product_quantity.setText("0");
            selected_quantity.setText("0");
            unit_price.setText("0");
        }
        for(Product product : item){
            if(product.getProductName().equals(product_item.getSelectedItem())){
                product_quantity.setText(Integer.toString(product.getQuantity()));
                unit_price.setText(Integer.toString(product.getPrice()));
            }
        }
    }//GEN-LAST:event_product_itemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int selectedQuantity = Integer.parseInt(selected_quantity.getText());
        int totalPayment = Integer.parseInt(total_payment.getText());
        if (selectedQuantity != 0){
            selectedQuantity--;
            selected_quantity.setText(Integer.toString(selectedQuantity));
            total_payment.setText(Integer.toString(totalPayment - Integer.parseInt(unit_price.getText())));
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int total = Integer.parseInt(product_quantity.getText());
        int selectedQuantity = Integer.parseInt(selected_quantity.getText());
        if (selectedQuantity != total){
            selectedQuantity++;
            selected_quantity.setText(Integer.toString(selectedQuantity));
            total_payment.setText(Integer.toString(selectedQuantity * Integer.parseInt(unit_price.getText())));
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void paymentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_paymentKeyPressed
        String totalText = total_payment.getText();
        String payText = payment.getText();

        // Check if the key event represents a deletion (Backspace key)
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE && payText.length() > 0) {
            payText = payText.substring(0, payText.length() - 1);
        } else {
            payText += evt.getKeyChar();
        }

        if (totalText.isEmpty() || payText.isEmpty()) {
            // Handle the case when either total or payment text is empty
            // You can show an error message or handle it according to your requirements
            balance.setText("");
            status.setText("");
            return;
        }
        else if (evt.getKeyCode() >= 48 && evt.getKeyCode() <= 57){
            return;
        }

        int total = Integer.parseInt(totalText);
        int pay = Integer.parseInt(payText);
        int bal = total - pay;
        System.out.println(pay);
        if (bal >0){
            status.setText("BALANCE");
            balance.setText(Integer.toString(bal));
            change.setText(Integer.toString(0));
        } else {
            bal = Math.abs(bal);
            balance.setText(Integer.toString(0));
            change.setText(Integer.toString(bal));
            status.setText("PAID");
        }
    }//GEN-LAST:event_paymentKeyPressed

    private void add_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_buttonMouseEntered
        add_button.setForeground(Color.green);
    }//GEN-LAST:event_add_buttonMouseEntered

    private void add_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_buttonMouseExited
        add_button.setForeground(Color.white);
    }//GEN-LAST:event_add_buttonMouseExited

    private void add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_buttonActionPerformed
        CustomerData data = new CustomerData();
        if (category.getSelectedItem()== null || product_item.getSelectedItem() == null || "0".equals(selected_quantity.getText())||
                payment.getText().equals("") || name.getText().equals("") || birthday.getText().equals("")
                 || contact.getText().equals("") || address.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please fill up all needed data.");
        }
        else{
            Random rand = new Random();
            int ID;
            do {
                ID = rand.nextInt(11111, 99999);
            } while (checkID(ID) == true);
            data.setID(ID);
            data.setStatus(status.getText());
            data.setName(name.getText().toUpperCase());
            data.setBirthday(birthday.getText());
            data.setContactNumber(contact.getText());
            data.setAddress(address.getText().toUpperCase());
            data.setCategory((String) category.getSelectedItem());
            data.setProductName((String) product_item.getSelectedItem());
            data.setQuantity(Integer.parseInt(selected_quantity.getText()));
            data.setTotalPayment(Integer.parseInt(total_payment.getText()));
            data.setPaymentReceived(Integer.parseInt(payment.getText()));
            data.setBalance(Integer.parseInt(balance.getText()));
            data.setChange(Integer.parseInt(change.getText()));
            data.setDate(String.valueOf(java.time.LocalDate.now()));
            
            for (Product product : item) {
            if (product.getProductName()== product_item.getSelectedItem() && product.getCategory() == category.getSelectedItem()) {
                int AQ = Integer.parseInt(product_quantity.getText());
                int SQ = Integer.parseInt(selected_quantity.getText());
                product.setQuantity(AQ - SQ);
                break;
            }
        }
            
            save(data);
            
            category.setSelectedItem(null);
            product_item.setSelectedItem(null);
            unit_price.setText("0");
            selected_quantity.setText("0");
            product_quantity.setText("0");
            total_payment.setText("0");
            balance.setText("0");
            status.setText("");
            change.setText("0");
            payment.setText("");
            birthday.setText("");
            contact.setText("");
            address.setText("");
            birthday.setText("");
            name.setText("");
            
            Display_customer_data info = new Display_customer_data(data);
            info.show();
        }
        
    }//GEN-LAST:event_add_buttonActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(POS.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new POS().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton add_button;
    private javax.swing.JTextField address;
    private javax.swing.JLabel backButton;
    private javax.swing.JLabel balance;
    private javax.swing.JTextField birthday;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JLabel change;
    private javax.swing.JTextField contact;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField name;
    private javax.swing.JTextField payment;
    private javax.swing.JComboBox<String> product_item;
    private javax.swing.JLabel product_quantity;
    private javax.swing.JLabel selected_quantity;
    private javax.swing.JLabel status;
    private javax.swing.JLabel total_payment;
    private javax.swing.JLabel unit_price;
    // End of variables declaration//GEN-END:variables
}
