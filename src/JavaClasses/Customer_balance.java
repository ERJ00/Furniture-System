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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Customer_balance extends javax.swing.JFrame {

    ArrayList<CustomerData> customer = new ArrayList<>();
    int index;

    
    public Customer_balance() {
        initComponents();
        retrieve();
    }

    private void add_item(CustomerData data){
       customer.add(data);
    }

    private void retrieve() {
    String filePath = "C:\\Users\\user\\Desktop\\System Project\\Furniture-System\\src\\Database\\customers_data.txt"; // Replace with the actual file path

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
            add_item(temp);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
    private void display(String nm, String bd){
        if (checkNameBirthday(nm, bd) == false){
            JOptionPane.showMessageDialog(null,"No Found!");
            return;
        }
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.RIGHT );
        model.setRowCount(0);
        
        for (CustomerData customer_data : customer) {
            
            if(customer_data.getName().equals(nm) && customer_data.getBirthday().equals(bd)){
                Object[] temp = {customer_data.getStatus(), customer_data.getName(), customer_data.getBirthday(), customer_data.getContactNumber(),
                            customer_data.getAddress(), customer_data.getProductName(), customer_data.getCategory(), Integer.toString(customer_data.getQuantity()),
                            customer_data.getTotalPayment(), customer_data.getPaymentReceived(), customer_data.getBalance(), customer_data.getChange(), customer_data.getDate(), customer_data.getID()};
                model.addRow(temp);
            }
        }
    }
    
    private boolean checkNameBirthday(String nm, String bd){
        for (CustomerData customer_data : customer) {
            if(customer_data.getName().equals(nm) && customer_data.getBirthday().equals(bd)){
                return true;
            }
        }
        return false;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        birthday = new javax.swing.JTextField();
        search_button = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        backButton = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JLabel();
        txtName = new javax.swing.JLabel();
        txtProduct = new javax.swing.JLabel();
        txtCategory = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JLabel();
        txtTotal = new javax.swing.JLabel();
        txtBalance = new javax.swing.JLabel();
        txtChange = new javax.swing.JLabel();
        txtPayment = new javax.swing.JTextField();
        add_button = new javax.swing.JButton();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Customer's Balance");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 36, 66));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Name :");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 70, 30));

        name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 200, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("MM/DD/YYYY");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, 200, 30));

        birthday.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel1.add(birthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, 200, 30));

        search_button.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        search_button.setForeground(new java.awt.Color(255, 255, 255));
        search_button.setText("Search");
        search_button.setContentAreaFilled(false);
        search_button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                search_buttonMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                search_buttonMouseExited(evt);
            }
        });
        search_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_buttonActionPerformed(evt);
            }
        });
        jPanel1.add(search_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 0, 130, 50));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Birthday :");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 10, 90, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 840, 70));

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Back_button.png"))); // NOI18N
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel11.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("customer's balance");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1000, 40));

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        table.setBackground(new java.awt.Color(204, 204, 204));
        table.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STATUS", "NAME", "BIRTHDAY", "CONTACT", "ADDRESS", "PRODUCT", "CATEGORY", "QUANTITY", "TOTAL", "RECEIVED", "BALANCE", "CHANGE", "DATE", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new java.awt.Color(0, 0, 0));
        table.setRowHeight(20);
        table.setSelectionBackground(new java.awt.Color(102, 102, 102));
        table.setShowGrid(true);
        table.getTableHeader().setResizingAllowed(false);
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 970, 240));

        jPanel2.setBackground(new java.awt.Color(0, 36, 66));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Status :");
        jPanel2.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 140, 30));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Name :");
        jPanel2.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 140, 30));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Quantity :");
        jPanel2.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 140, 30));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Product :");
        jPanel2.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 140, 30));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("category :");
        jPanel2.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 140, 30));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Total Payment :");
        jPanel2.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 20, 150, 30));

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Change :");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, 140, 30));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Balance :");
        jPanel2.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 140, 30));

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel32.setForeground(new java.awt.Color(255, 255, 255));
        jLabel32.setText("Payment Received :");
        jPanel2.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 190, 30));

        txtStatus.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtStatus.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 140, 30));

        txtName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtName.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 140, 30));

        txtProduct.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtProduct.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtProduct, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 140, 30));

        txtCategory.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtCategory.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtCategory, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 140, 30));

        txtQuantity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtQuantity.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtQuantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 140, 30));

        txtTotal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtTotal.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, 150, 30));

        txtBalance.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtBalance.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtBalance, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, 140, 30));

        txtChange.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        txtChange.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.add(txtChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 110, 140, 30));

        txtPayment.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtPayment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPaymentActionPerformed(evt);
            }
        });
        txtPayment.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtPaymentKeyPressed(evt);
            }
        });
        jPanel2.add(txtPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 50, 200, 30));

        add_button.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        add_button.setForeground(new java.awt.Color(255, 255, 255));
        add_button.setText("Update");
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
        jPanel2.add(add_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 130, 130, 50));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 970, 190));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/BG3.jpg"))); // NOI18N
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 600));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        Main main = new Main();
        main.show();
        dispose();
    }//GEN-LAST:event_backButtonMouseClicked

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int row = table.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        
        if (model.getValueAt(row, 0).toString().equals("PAID")){
        txtStatus.setText("");
        txtName.setText("");
        txtProduct.setText("");
        txtCategory.setText("");
        txtTotal.setText("");
        txtQuantity.setText("");
        txtBalance.setText("");
        txtBalance.setText("");  
        txtChange.setText(""); 
            return;
        }
        
        index = (int) model.getValueAt(row, 13);
        
        txtStatus.setText(model.getValueAt(row, 0).toString());
        txtName.setText(model.getValueAt(row, 1).toString());
        txtProduct.setText(model.getValueAt(row, 5).toString());
        txtCategory.setText(model.getValueAt(row, 6).toString());
        txtTotal.setText(model.getValueAt(row, 10).toString());
        txtQuantity.setText(model.getValueAt(row, 7).toString());
        txtBalance.setText("0");
        txtChange.setText("0");
    }//GEN-LAST:event_tableMouseClicked

    private void add_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_buttonMouseEntered
        add_button.setForeground(Color.green);
    }//GEN-LAST:event_add_buttonMouseEntered

    private void add_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_buttonMouseExited
        add_button.setForeground(Color.white);
    }//GEN-LAST:event_add_buttonMouseExited

    private void add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_buttonActionPerformed
        int row = table.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        
        if (txtPayment.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Please fill up all needed data.");
        return;
    } else {
        int select = JOptionPane.showConfirmDialog(null, "Sure? You want to update?", "Confirmation",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (select == JOptionPane.YES_OPTION) {
            for (CustomerData custoData : customer) {
                if (custoData.getID() == index) {
                    custoData.setTotalPayment(Integer.parseInt(txtTotal.getText()));
                    custoData.setPaymentReceived(Integer.parseInt(txtPayment.getText()));
                    custoData.setBalance(Integer.parseInt(txtBalance.getText()));
                    custoData.setChange(Integer.parseInt(txtChange.getText()));
                    custoData.setStatus(txtStatus.getText());
                    custoData.setDate(String.valueOf(java.time.LocalDate.now()));

                    try (FileWriter f = new FileWriter("C:\\Users\\user\\Desktop\\System Project\\Furniture-System\\src\\Database\\transaction_history.txt", true);
                            BufferedWriter b = new BufferedWriter(f);
                            PrintWriter p = new PrintWriter(b);) {
                        p.println(Encryption.encrypt(custoData.getStatus() + " / " + custoData.getName() + " / "
                                + custoData.getBirthday() + " / " + custoData.getContactNumber() + " / "
                                + custoData.getAddress() + " / " + custoData.getProductName() + " / "
                                + custoData.getCategory() + " / " + custoData.getQuantity() + " / "
                                + custoData.getTotalPayment() + " / " + custoData.getPaymentReceived() + " / "
                                + custoData.getBalance() + " / " + custoData.getChange() + " / "
                                + custoData.getDate() + " / " + custoData.getID() + " / "));
                    } catch (IOException i) {
                        i.printStackTrace();
                    }
                }
            }

            try (FileWriter f = new FileWriter("C:\\Users\\user\\Desktop\\System Project\\Furniture-System\\src\\Database\\customers_data.txt", false);
                BufferedWriter b = new BufferedWriter(f);
                PrintWriter p = new PrintWriter(b);) {
                    p.println(Encryption.encrypt(txtStatus.getText() + " / " +
                            model.getValueAt(row, 1) + " / " +
                            model.getValueAt(row, 2) + " / " +
                            model.getValueAt(row, 3) + " / " +
                            model.getValueAt(row, 4) + " / " +
                            model.getValueAt(row, 5) + " / " +
                            model.getValueAt(row, 6) + " / " +
                            model.getValueAt(row, 7) + " / " +
                            txtTotal.getText() + " / " +
                            txtPayment.getText() + " / " +
                            txtBalance.getText() + " / " +
                            txtChange.getText() + " / " +
                            String.valueOf(java.time.LocalDate.now()) + " / " +
                            model.getValueAt(row, 13) + " / "));
                } 
            catch (IOException i) {
                i.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "Update Successfully!");
            model.setRowCount(0);
            name.setText("");
            birthday.setText("");
            txtStatus.setText("");
            txtName.setText("");
            txtProduct.setText("");
            txtCategory.setText("");
            txtTotal.setText("");
            txtQuantity.setText("");
            txtBalance.setText("");
            txtBalance.setText("");  
            txtChange.setText("");  
            txtPayment.setText("");
        }
    }
    }//GEN-LAST:event_add_buttonActionPerformed

    private void txtPaymentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPaymentKeyPressed
        String totalText = txtTotal.getText();
        String payText = txtPayment.getText();

        // Check if the key event represents a deletion (Backspace key)
        if (evt.getKeyCode() == KeyEvent.VK_BACK_SPACE && payText.length() > 0) {
            payText = payText.substring(0, payText.length() - 1);
        } else {
            payText += evt.getKeyChar();
        }

        if (payText.isEmpty()) {
            // Handle the case when either total or payment text is empty
            // You can show an error message or handle it according to your requirements
            txtBalance.setText("0");
            txtChange.setText("0");
            txtStatus.setText("");
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
            txtStatus.setText("BALANCE");
            txtBalance.setText(Integer.toString(bal));
            txtChange.setText(Integer.toString(0));
        } else {
            bal = Math.abs(bal);
            txtBalance.setText(Integer.toString(0));
            txtChange.setText(Integer.toString(bal));
            txtStatus.setText("PAID");
        }
    }//GEN-LAST:event_txtPaymentKeyPressed

    private void txtPaymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPaymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPaymentActionPerformed

    private void search_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_buttonMouseExited
        search_button.setForeground(Color.white);
    }//GEN-LAST:event_search_buttonMouseExited

    private void search_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_buttonActionPerformed
        if (name.getText().equals("") || birthday.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please fill up all needed data.");
            return;
        } 
        else{
            display(name.getText().toUpperCase(), birthday.getText());
        }
    }//GEN-LAST:event_search_buttonActionPerformed

    private void search_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_search_buttonMouseEntered
        search_button.setForeground(Color.green);
    }//GEN-LAST:event_search_buttonMouseEntered

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
            java.util.logging.Logger.getLogger(Customer_balance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Customer_balance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Customer_balance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Customer_balance.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Customer_balance().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton add_button;
    private javax.swing.JLabel backButton;
    private javax.swing.JTextField birthday;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JButton search_button;
    private javax.swing.JTable table;
    private javax.swing.JLabel txtBalance;
    private javax.swing.JLabel txtCategory;
    private javax.swing.JLabel txtChange;
    private javax.swing.JLabel txtName;
    private javax.swing.JTextField txtPayment;
    private javax.swing.JLabel txtProduct;
    private javax.swing.JLabel txtQuantity;
    private javax.swing.JLabel txtStatus;
    private javax.swing.JLabel txtTotal;
    // End of variables declaration//GEN-END:variables
}
