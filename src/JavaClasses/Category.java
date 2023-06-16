/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JavaClasses;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author user
 */
public class Category extends javax.swing.JFrame {

    ArrayList<Product> item = new ArrayList<>();
    ArrayList product_category = new ArrayList<>();
    public Category() {
        initComponents();
        retrieve();
    }
    
    private void add_item(Product data){
       item.add(data);
    }

    private void retrieve() {
    String filePath = "C:\\Users\\Merrell\\Desktop\\ProgLang-Project\\Java-Project\\Furniture-System\\src\\Database\\received_product_history.txt"; // Replace with the actual file path

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
    
    private void add_category(String PC){
        for(Product product : item){
            if(product.getCategory().equals(PC)){
                return;
            }
        }
        product_category.add(PC);
    }
    
    private void display(String prod_category){
        
        DefaultTableModel model = (DefaultTableModel)table.getModel();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.RIGHT );
        
        model.setRowCount(0);
        
        Object[] column = {"ID", "PRODUCT", "BRAND", "PRICE", "QUANTITY", "DESCRIPTION"};
        model.setColumnIdentifiers(column);
        table.setDefaultRenderer(String.class, centerRenderer);
        
        TableColumnModel colModel = table.getColumnModel();
        colModel.getColumn(0).setPreferredWidth(100); 
        colModel.getColumn(1).setPreferredWidth(150);
        colModel.getColumn(2).setPreferredWidth(150);
        colModel.getColumn(3).setPreferredWidth(100);
        colModel.getColumn(4).setPreferredWidth(150);
        colModel.getColumn(5).setPreferredWidth(300); 

        for (Product product : item) {
            
            if (product.getCategory().equals(prod_category)){
                Object[] temp = {Integer.toString(product.getID()), product.getProductName(), product.getBrand(), Integer.toString(product.getPrice()), Integer.toString(product.getQuantity()), product.getDescription()};
                model.addRow(temp);
            }
        }
        table.setModel(model);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        backButton = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        category = new javax.swing.JComboBox<>();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Product Category");
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
        jLabel11.setText("PRODUCT CATEGORY");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 800, 40));

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Back_button.png"))); // NOI18N
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

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
        table.getAccessibleContext().setAccessibleName("");

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 780, 380));

        category.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        category.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryActionPerformed(evt);
            }
        });
        getContentPane().add(category, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 180, 40));

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

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        DefaultComboBoxModel mod = new DefaultComboBoxModel(product_category.toArray());
        category.setModel(mod);
        category.setSelectedItem(null);
    }//GEN-LAST:event_formWindowOpened

    private void categoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryActionPerformed
        System.out.println(category.getSelectedItem());
        display((String) category.getSelectedItem());
    }//GEN-LAST:event_categoryActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        if(table.isEditing() == false){
           //JOptionPane.showMessageDialog(null,"You can not edit this Table.");
           return;
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
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Category.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Category().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JLabel backButton;
    private javax.swing.JComboBox<String> category;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
