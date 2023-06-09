/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package JavaClasses;

import java.awt.Color;

/**
 *
 * @author user
 */
public class Display_customer_data extends javax.swing.JFrame {

    /**
     * Creates new form Display_customer_data
     */
    public Display_customer_data() {
        initComponents();
    }
    
    public Display_customer_data(CustomerData data) {
        initComponents();
        
        status.setText(data.getStatus());
        name.setText(data.getName());
        birthday.setText(data.getBirthday());
        contact.setText(data.getContactNumber());
        address.setText(data.getAddress());
        productName.setText(data.getProductName());
        category.setText(data.getCategory());
        quantity.setText(Integer.toString(data.getQuantity()));
        totalPayment.setText(Integer.toString(data.getTotalPayment()));
        received.setText(Integer.toString(data.getPaymentReceived()));
        balance.setText(Integer.toString(data.getBalance()));
        change.setText(Integer.toString(data.getChange()));
        date.setText(data.getDate());
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        add_button = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        change = new javax.swing.JLabel();
        balance = new javax.swing.JLabel();
        received = new javax.swing.JLabel();
        totalPayment = new javax.swing.JLabel();
        quantity = new javax.swing.JLabel();
        category = new javax.swing.JLabel();
        productName = new javax.swing.JLabel();
        address = new javax.swing.JLabel();
        contact = new javax.swing.JLabel();
        birthday = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        BG = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Perpetua Titling MT", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Informations");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 500, 40));

        jPanel1.setBackground(new java.awt.Color(0, 36, 66));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel4.setText("NAME                      :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 190, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel5.setText("CONTACT NO.        :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 190, 20));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel6.setText("ADDRESS                :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 190, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("PRODUCT               :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 190, 20));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("QUANTITY              :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 220, 190, 20));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("DATE                        :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 370, 190, 20));

        add_button.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        add_button.setForeground(new java.awt.Color(255, 255, 255));
        add_button.setContentAreaFilled(false);
        add_button.setLabel("OK");
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
        jPanel1.add(add_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 410, 110, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("BIRTHDAY             : ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, 190, 20));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel13.setText("STATUS                   :");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 190, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("CATEGORY             :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 190, 20));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel14.setText("TOTAL PAYMENT   :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 190, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel15.setText("RECEIVED               :");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 190, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel16.setText("BALANCE                 :");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 190, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel17.setText("CHANGE                  :");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, 190, 20));

        date.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        date.setForeground(new java.awt.Color(255, 255, 255));
        date.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, 190, 20));

        change.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        change.setForeground(new java.awt.Color(255, 255, 255));
        change.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(change, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 340, 190, 20));

        balance.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        balance.setForeground(new java.awt.Color(255, 255, 255));
        balance.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(balance, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 190, 20));

        received.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        received.setForeground(new java.awt.Color(255, 255, 255));
        received.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(received, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 280, 190, 20));

        totalPayment.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        totalPayment.setForeground(new java.awt.Color(255, 255, 255));
        totalPayment.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(totalPayment, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 190, 20));

        quantity.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        quantity.setForeground(new java.awt.Color(255, 255, 255));
        quantity.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(quantity, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 220, 190, 20));

        category.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        category.setForeground(new java.awt.Color(255, 255, 255));
        category.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(category, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 190, 20));

        productName.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        productName.setForeground(new java.awt.Color(255, 255, 255));
        productName.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(productName, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 190, 20));

        address.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        address.setForeground(new java.awt.Color(255, 255, 255));
        address.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(address, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, 190, 20));

        contact.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        contact.setForeground(new java.awt.Color(255, 255, 255));
        contact.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, 190, 20));

        birthday.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        birthday.setForeground(new java.awt.Color(255, 255, 255));
        birthday.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(birthday, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, 190, 20));

        name.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        name.setForeground(new java.awt.Color(255, 255, 255));
        name.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(name, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 40, 190, 20));

        status.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        status.setForeground(new java.awt.Color(255, 255, 255));
        status.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jPanel1.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 190, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 480, 450));

        BG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Display.jpg"))); // NOI18N
        getContentPane().add(BG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, -1));

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
        dispose();
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
            java.util.logging.Logger.getLogger(Display_customer_data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Display_customer_data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Display_customer_data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Display_customer_data.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Display_customer_data().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BG;
    private javax.swing.JButton add_button;
    private javax.swing.JLabel address;
    private javax.swing.JLabel balance;
    private javax.swing.JLabel birthday;
    private javax.swing.JLabel category;
    private javax.swing.JLabel change;
    private javax.swing.JLabel contact;
    private javax.swing.JLabel date;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel name;
    private javax.swing.JLabel productName;
    private javax.swing.JLabel quantity;
    private javax.swing.JLabel received;
    private javax.swing.JLabel status;
    private javax.swing.JLabel totalPayment;
    // End of variables declaration//GEN-END:variables
}
