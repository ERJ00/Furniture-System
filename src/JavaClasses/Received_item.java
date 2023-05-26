/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JavaClasses;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Received_item extends javax.swing.JFrame {

    ArrayList<Product> item = new ArrayList<>();
    
    public Received_item() {
        initComponents();
        retrieve();
    }

    public boolean check_ID(int ID){
        for (Product product : item) {
            
            if (product.getID() == ID){
                return true;
            }
        }
        return false;
    }
    
    public void add_item(Product data){
        item.add(data);
    }
    
    private void retrieve() {
    String filePath = "C:\\Users\\user\\Desktop\\System Project\\Java\\Furniture_System\\src\\Database\\products.txt"; // Replace with the actual file path

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
    
    public void save(Product data){
        BufferedWriter buffWriter = null;

//        try{
//            buffWriter = new BufferedWriter(new FileWriter(new File("C:\\Users\\user\\Desktop\\System Project\\Java\\Furniture_System\\src\\Database\\received_produc_history.txt"),true));
//            buffWriter.write(data.getID() + " / " + data.getPrice() + " / " + data.getQuantity() + " / " + data.getProductName()+ " / " + data.getBrand() + " / " + data.getDescription() + " / " + data.getCategory() + " / " + data.getSupplier() + " / " + data.getDate() + " / \n");
//            buffWriter.close();
//        }catch(FileNotFoundException e){
//        System.out.println("File not found!");
//        
//        }catch (IOException ex) {
//            Logger.getLogger(Received_item.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        try (FileWriter f = new FileWriter("C:\\Users\\user\\Desktop\\System Project\\Java\\Furniture_System\\src\\Database\\received_product_history.txt", true);
                BufferedWriter b = new BufferedWriter(f);
                PrintWriter p = new PrintWriter(b);) {

            p.println(data.getID() + " / " + data.getPrice() + " / " + data.getQuantity() + " / " + data.getProductName()+ " / " + data.getBrand() + " / " + data.getDescription() + " / " + data.getCategory() + " / " + data.getSupplier() + " / " + data.getDate() + " / ");

        } catch (IOException i) {
            i.printStackTrace();
        }
        
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\user\\Desktop\\System Project\\Java\\Furniture_System\\src\\Database\\products.txt");
            
            for (Product product : item) {
                myWriter.write(Integer.toString(product.getID()) + " / ");
                myWriter.write(Integer.toString(product.getPrice()) + " / ");
                myWriter.write(Integer.toString(product.getQuantity()) + " / ");
                myWriter.write(product.getProductName() + " / ");
                myWriter.write(product.getBrand() + " / ");
                myWriter.write(product.getDescription() + " / ");
                myWriter.write(product.getCategory() + " / ");
                myWriter.write(product.getSupplier() + " / ");
                myWriter.write(product.getDate() + " / \n");
            }
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        backButton = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_brand = new javax.swing.JTextField();
        txt_product_name = new javax.swing.JTextField();
        txt_quantity = new javax.swing.JTextField();
        txt_price = new javax.swing.JTextField();
        txt_description = new javax.swing.JTextField();
        txt_supplier = new javax.swing.JTextField();
        add_button = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txt_category = new javax.swing.JTextField();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Product Received");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Product received");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 800, 40));

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Back_button.png"))); // NOI18N
        backButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backButtonMouseClicked(evt);
            }
        });
        getContentPane().add(backButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 36, 66));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("PRODUCT : ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 190, 40));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("BRAND :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 190, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("UNIT PRICE :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 190, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("QUANTITY :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 190, 40));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("DESCRIPTION :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 190, 40));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("SUPPLIER :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 170, 190, 40));

        txt_brand.setBackground(new java.awt.Color(204, 204, 204));
        txt_brand.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_brand.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txt_brand, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 240, 30));

        txt_product_name.setBackground(new java.awt.Color(204, 204, 204));
        txt_product_name.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_product_name.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txt_product_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 240, 30));

        txt_quantity.setBackground(new java.awt.Color(204, 204, 204));
        txt_quantity.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_quantity.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txt_quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 130, 240, 30));

        txt_price.setBackground(new java.awt.Color(204, 204, 204));
        txt_price.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_price.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txt_price, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 240, 30));

        txt_description.setBackground(new java.awt.Color(204, 204, 204));
        txt_description.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_description.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txt_description, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 240, 30));

        txt_supplier.setBackground(new java.awt.Color(204, 204, 204));
        txt_supplier.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_supplier.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txt_supplier, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 240, 30));

        add_button.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        add_button.setForeground(new java.awt.Color(255, 255, 255));
        add_button.setText("ADD");
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
        jPanel1.add(add_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 130, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("CATEGORY :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 240, 40));

        txt_category.setBackground(new java.awt.Color(204, 204, 204));
        txt_category.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_category.setForeground(new java.awt.Color(0, 0, 0));
        jPanel1.add(txt_category, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, 240, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 740, 400));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/BG.jpeg"))); // NOI18N
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void add_buttonMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_buttonMouseEntered
        add_button.setForeground(Color.green);
    }//GEN-LAST:event_add_buttonMouseEntered

    private void add_buttonMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_add_buttonMouseExited
        add_button.setForeground(Color.white);
    }//GEN-LAST:event_add_buttonMouseExited

    private void add_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_add_buttonActionPerformed
        Product data = new  Product();
        Random rand = new Random();
        int ID;
        do{
            ID = rand.nextInt(11111, 99999);
        }while(check_ID(ID) == true);
        data.setID(ID);
        data.setProductName(txt_product_name.getText());
        data.setBrand(txt_brand.getText().toUpperCase());
        data.setPrice(Integer.parseInt(txt_price.getText()));
        data.setQuantity(Integer.parseInt(txt_quantity.getText()));
        data.setDescription(txt_description.getText());
        data.setSupplier(txt_supplier.getText());
        data.setCategory(txt_category.getText().toUpperCase());
        data.setDate(String.valueOf(java.time.LocalDate.now()));

        try {
            if ((txt_product_name.getText().equals("")) || (txt_brand.getText().equals("")) ||
                (txt_price.getText().equals("")) || (txt_quantity.getText().equals("")) ||
                (txt_description.getText().equals("")) || (txt_supplier.getText().equals("")) ||
                (txt_category.getText().equals("")) ){
                JOptionPane.showMessageDialog(null,"Please fill up all needed data.");
            }
            else {
                Display_info info = new Display_info(data);
                txt_product_name.setText("");
                txt_brand.setText("");
                txt_price.setText("");
                txt_quantity.setText("");
                txt_description.setText("");
                txt_supplier.setText("");
                txt_category.setText("");
                add_item(data);
                save(data);
                info.show();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_add_buttonActionPerformed

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
            java.util.logging.Logger.getLogger(Received_item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Received_item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Received_item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Received_item.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Received_item().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton add_button;
    private javax.swing.JLabel backButton;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_brand;
    private javax.swing.JTextField txt_category;
    private javax.swing.JTextField txt_description;
    private javax.swing.JTextField txt_price;
    private javax.swing.JTextField txt_product_name;
    private javax.swing.JTextField txt_quantity;
    private javax.swing.JTextField txt_supplier;
    // End of variables declaration//GEN-END:variables
}
