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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author user
 */
public class Out_of_stock extends javax.swing.JFrame {

   ArrayList<Product> item = new ArrayList<>();
    
    public Out_of_stock() {
        initComponents();
        retrieve();
        display();
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
            String[] arr_line = line.split(" / ");
                temp.setID(Integer.parseInt(arr_line[0].trim()));
                temp.setPrice(Integer.parseInt(arr_line[1].trim()));
                temp.setQuantity(Integer.parseInt(arr_line[2].trim()));
                temp.setProductName(arr_line[3].trim());
                temp.setBrand(arr_line[4].trim());
                temp.setDescription(arr_line[5].trim());
                temp.setCategory(arr_line[6].trim());
                temp.setSupplier(arr_line[7].trim());
                temp.setDate(arr_line[8].trim());
                add_item(temp);
                temp = new Product(); // Create a new instance for each item
        }
    }   catch (IOException e) {
        e.printStackTrace();
        }
    }
    
    private void display(){
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.RIGHT );
        
        Object[] column = {"ID", "PRODUCT", "BRAND", "PRICE", "CATEGORY", "DESCRIPTION"};
        model.setColumnIdentifiers(column);
        table.setDefaultRenderer(String.class, centerRenderer);
        
        TableColumnModel colModel = table.getColumnModel();
        colModel.getColumn(0).setPreferredWidth(100); 
        colModel.getColumn(1).setPreferredWidth(120);
        colModel.getColumn(2).setPreferredWidth(120);
        colModel.getColumn(3).setPreferredWidth(70);
        colModel.getColumn(4).setPreferredWidth(150);
        colModel.getColumn(5).setPreferredWidth(300); 

        for (Product product : item) {
            
            if (product.getQuantity() == 0){
                Object[] temp = {Integer.toString(product.getID()), product.getProductName(), product.getBrand(), Integer.toString(product.getPrice()), product.getCategory(), product.getDescription()};
                model.addRow(temp);
            }
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
        setTitle("Out Of Stock Products");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N

        table.setBackground(new java.awt.Color(204, 204, 204));
        table.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table.setGridColor(new java.awt.Color(0, 0, 0));
        table.setRowHeight(20);
        table.setRowSelectionAllowed(false);
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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 70, 746, 390));

        jLabel11.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("OUT OF STOCK PRODUCTS");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 800, 40));

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Back_button.png"))); // NOI18N
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if(table.isEditing() == false){
           JOptionPane.showMessageDialog(null,"You can not edit this Table.");
        }
    }//GEN-LAST:event_tableMouseClicked

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
            java.util.logging.Logger.getLogger(Out_of_stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Out_of_stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Out_of_stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Out_of_stock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Out_of_stock().setVisible(true);
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
