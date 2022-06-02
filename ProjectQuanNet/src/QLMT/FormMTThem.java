/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLMT;

import java.awt.Color;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dang Do
 */
public class FormMTThem extends javax.swing.JFrame {

    private java.sql.Connection conn = null;
    public FormMTThem() {
        initComponents();
        Connect();
        this.getContentPane().setBackground(new java.awt.Color(189,231,253));
        this.setLocationRelativeTo(null);
    }

   private void Connect() { //ket noi csdl
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.print("ket noi thanh cong");
        } catch (ClassNotFoundException ex) {
            
        }
        try {

            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "DANGDO_CONNECT", "USERPASS");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTenMay = new javax.swing.JTextField();
        txtNhomMay = new javax.swing.JTextField();
        txtTT = new javax.swing.JTextField();
        txtGhiChu = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tên máy");

        jLabel2.setText("Nhóm máy");

        jLabel3.setText("Trạng thái máy");

        jLabel4.setText("Ghi chú");

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 255));
        jLabel5.setText("THÊM MÁY TRẠM");

        jButton1.setText("XÁC NHẬN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("RESET");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("BACK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(37, 37, 37)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtTT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                                    .addComponent(txtNhomMay, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTenMay, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGhiChu)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel5)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTenMay, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNhomMay, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        StringBuilder sb = new StringBuilder();
        if (txtTenMay.getText().equals("")) {
            sb.append("Tên máy không được để trống!!!");
            txtTenMay.setBackground(Color.BLUE);
        } else {
            txtTenMay.setBackground(Color.white);
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        if (txtNhomMay.getText().equals("")) {
            sb.append("Nhóm máy trạm không được để trống!!!");
            txtNhomMay.setBackground(Color.BLUE);
        } else {
            txtNhomMay.setBackground(Color.white);
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        if (txtTT.getText().equals("")) {
            sb.append("Trạng thái máy không được để trống!!!");
            txtTT.setBackground(Color.BLUE);
        } else {
            txtTT.setBackground(Color.white);
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        if (txtGhiChu.getText().equals("")) {
            sb.append("Ghi chú không được để trống!!!");
            txtGhiChu.setBackground(Color.BLUE);
        } else {
            txtGhiChu.setBackground(Color.white);
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try {           
                PreparedStatement ps1 = conn.prepareStatement("Insert into MayTram(TenMay,TenNhom,TrangThaiMay,GhiChu) values(?,?,?,?)"); 
                ps1.setString(1,txtTenMay.getText());
                ps1.setString(2,txtNhomMay.getText());
                ps1.setString(3,txtTT.getText());
                ps1.setString(4,txtGhiChu.getText());
                int num1 = ps1.executeUpdate();
                if (num1 > 0) {
                JOptionPane.showMessageDialog(this, "Máy trạm được thêm thành công!");      
                dispose();
                FormQLMT form = new FormQLMT();
                form.setVisible(true);
                }
                                
        }
            catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Nhóm máy trạm không tồn tại");
        } 
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        txtTenMay.setText("");
        txtNhomMay.setText("");
        txtTT.setText("");
        txtGhiChu.setText("");
        
        txtTenMay.setBackground(Color.white);
        txtNhomMay.setBackground(Color.white);
        txtTT.setBackground(Color.white);
        txtGhiChu.setBackground(Color.white);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        dispose();
        FormQLMT form = new FormQLMT();
        form.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(FormMTThem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMTThem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMTThem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMTThem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMTThem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    public static javax.swing.JTextField txtGhiChu;
    public static javax.swing.JTextField txtNhomMay;
    public static javax.swing.JTextField txtTT;
    public static javax.swing.JTextField txtTenMay;
    // End of variables declaration//GEN-END:variables
}
