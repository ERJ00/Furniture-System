/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JavaClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author user
 */
public class Transaction_history extends javax.swing.JFrame {

    ArrayList<CustomerData> customer = new ArrayList<>();
    
    public Transaction_history() {
        initComponents();
        retrieve();
        display();
    }

    private void add_item(CustomerData data){
       customer.add(data);
    }

    private void retrieve() {
    String filePath = "C:\\Users\\user\\Desktop\\System Project\\Furniture-System\\src\\Database\\transaction_history.txt"; // Replace with the actual file path

    try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
        String line;

        while ((line = reader.readLine()) != null) {
            line = Encryption.decrypt(line);
            String[] arr_line = line.split(" / ");
            
            if (arr_line.length < 14) {
                System.err.println("Invalid line format: " + line);
                continue; // Skip this line and proceed to the next iteration
            }

            CustomerData temp = new CustomerData(); // Create a new instance for each item
            
            try {
                temp.setStatus(arr_line[0].trim());
                temp.setName(arr_line[1].trim());
                temp.setBirthday(arr_line[2].trim());
                temp.setContactNumber(arr_line[3].trim());
                temp.setAddress(arr_line[4].trim());
                temp.setProductName(arr_line[5].trim());
                temp.setCategory(arr_line[6].trim());
                temp.setQuantity(Integer.parseInt(arr_line[7].trim()));
                temp.setTotalPayment(Integer.parseInt(arr_line[8].trim()));
                temp.setPaymentReceived(Integer.parseInt(arr_line[9].trim()));
                temp.setBalance(Integer.parseInt(arr_line[10].trim()));
                temp.setChange(Integer.parseInt(arr_line[11].trim()));
                temp.setDate(arr_line[12].trim());
                temp.setID(Integer.parseInt(arr_line[13].trim()));
            } catch (NumberFormatException e) {
                // Handle the exception gracefully (e.g., log the error, skip the item, etc.)
                System.err.println("Error parsing data: " + e.getMessage());
                continue; // Skip this item and proceed to the next iteration
            }

            add_item(temp);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
}
    
    private void display(){
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.RIGHT );
        
//        Object[] column = {"ID", "PRODUCT", "BRAND", "PRICE", "CATEGORY", "SUPPLIER", "QUANTITY", "DATE"};
//        model.setColumnIdentifiers(column);
//        table.setDefaultRenderer(String.class, centerRenderer);
//        
//        TableColumnModel colModel = table.getColumnModel();
//        colModel.getColumn(0).setPreferredWidth(50); 
//        colModel.getColumn(1).setPreferredWidth(120);
//        colModel.getColumn(2).setPreferredWidth(120);
//        colModel.getColumn(3).setPreferredWidth(70);
//        colModel.getColumn(4).setPreferredWidth(150);
//        colModel.getColumn(5).setPreferredWidth(150); 
//        colModel.getColumn(6).setPreferredWidth(100);
//        colModel.getColumn(7).setPreferredWidth(100);

        for (CustomerData customer_data : customer) {
            
            Object[] temp = {customer_data.getStatus(), customer_data.getName(), customer_data.getBirthday(), customer_data.getContactNumber(),
                            customer_data.getAddress(), customer_data.getProductName(), customer_data.getCategory(), Integer.toString(customer_data.getQuantity()),
                            customer_data.getTotalPayment(), customer_data.getPaymentReceived(), customer_data.getBalance(), customer_data.getChange(), customer_data.getDate()};
            model.addRow(temp);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        backButton = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Transaction History");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        table.setBackground(new java.awt.Color(204, 204, 204));
        table.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STATUS", "NAME", "BIRTHDAY", "CONTACT", "ADDRESS", "PRODUCT", "CATEGORY", "QUANTITY", "TOTAL", "RECEIVED", "BALANCE", "CHANGE", "DATE"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false, false, false, false, false, false
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
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(1).setResizable(false);
            table.getColumnModel().getColumn(2).setResizable(false);
            table.getColumnModel().getColumn(3).setResizable(false);
            table.getColumnModel().getColumn(4).setResizable(false);
            table.getColumnModel().getColumn(5).setResizable(false);
            table.getColumnModel().getColumn(6).setResizable(false);
            table.getColumnModel().getColumn(7).setResizable(false);
            table.getColumnModel().getColumn(8).setResizable(false);
            table.getColumnModel().getColumn(9).setResizable(false);
            table.getColumnModel().getColumn(10).setResizable(false);
            table.getColumnModel().getColumn(11).setResizable(false);
            table.getColumnModel().getColumn(12).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 70, 990, 410));

        jLabel11.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("transaction history");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1000, 40));

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Back_button.png"))); // NOI18N
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/BG2.jpg"))); // NOI18N
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if(table.isEditing() == false){
            //JOptionPane.showMessageDialog(null,"You can not edit this Table.");
            return;
        }
    }//GEN-LAST:event_tableMouseClicked

    private void backButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backButtonMouseClicked
        Main main = new Main();
        main.show();
        dispose();
    }//GEN-LAST:event_backButtonMouseClicked

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
            java.util.logging.Logger.getLogger(Transaction_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaction_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaction_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaction_history.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Transaction_history().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JLabel backButton;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
