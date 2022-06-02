/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sever;

import static Client.LoginForm.tk;
import QLNV.FormQLNV;
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
public class LoginSever extends javax.swing.JFrame {
    private java.sql.Connection conn = null;
    public LoginSever() {
        initComponents();
        this.setLocationRelativeTo(null);
        connect();
    }

   public void connect()
    {
       try {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        System.out.print("ket noi thanh cong");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormQLNV.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            
           conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","DANGDO_CONNECT", "USERPASS");
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
   
    }
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        txtTenDN = new javax.swing.JTextField();
        txtMK = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        bDangNhap = new javax.swing.JButton();
        bThoat = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        txtTenDN.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        txtMK.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMKMouseClicked(evt);
            }
        });
        txtMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMKActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel1.setText("Tên đăng nhập");

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel2.setText("Mật khẩu");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenDN, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenDN, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(41, 41, 41))
        );

        bDangNhap.setBackground(new java.awt.Color(255, 255, 255));
        bDangNhap.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        bDangNhap.setText("Đăng nhập");
        bDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDangNhapActionPerformed(evt);
            }
        });

        bThoat.setBackground(new java.awt.Color(255, 255, 255));
        bThoat.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        bThoat.setText("Thoát");
        bThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bThoatActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("TIỆM NET DVD");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(bDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(bThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel3)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bThoatActionPerformed
       dispose();
    }//GEN-LAST:event_bThoatActionPerformed

    private void bDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDangNhapActionPerformed
       
        try {
                 PreparedStatement st = conn.prepareStatement("Select * from TAIKHOANNV WHERE TENTAIKHOANNV=? AND MATKHAU=?");
                 st.setString(1,txtTenDN.getText());
                 st.setString(2,txtMK.getText());
                 ResultSet rs = st.executeQuery();
                if(txtTenDN.getText().equals("quanly") && txtMK.getText().equals("quanly"))
                {
                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
                     dispose();
                    GiaoDienQuanLy ql = new GiaoDienQuanLy();
                    ql.setVisible(true);
                    ql.txtTenDN.setText(txtTenDN.getText());
                   
                }
                else if(rs.next())
                { 
                   
                  JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
                  dispose();
                  GiaoDienQuanLy ql = new GiaoDienQuanLy();
                  ql.setVisible(true);
                  ql.txtTenDN.setText(txtTenDN.getText());
                  ql.QLDV.setEnabled(false);
                  ql.QLNV.setEnabled(false);
                }
                else 
                {
                     JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu");
                     txtTenDN.setText("");
                     txtMK.setText("");
                }
                
                 
        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }//GEN-LAST:event_bDangNhapActionPerformed

    private void txtMKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMKActionPerformed
        try {
                 PreparedStatement st = conn.prepareStatement("Select * from TAIKHOANNV WHERE TENTAIKHOANNV=? AND MATKHAU=?");
                 st.setString(1,txtTenDN.getText());
                 st.setString(2,txtMK.getText());
                 ResultSet rs = st.executeQuery();
                if(txtTenDN.getText().equals("quanly") && txtMK.getText().equals("quanly"))
                {
                    JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
                     dispose();
                    GiaoDienQuanLy ql = new GiaoDienQuanLy();
                    ql.setVisible(true);
                    ql.txtTenDN.setText(txtTenDN.getText());
                   
                }
                else if(rs.next())
                { 
                   
                  JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
                  dispose();
                  GiaoDienQuanLy ql = new GiaoDienQuanLy();
                  ql.setVisible(true);
                  ql.txtTenDN.setText(txtTenDN.getText());
                  ql.QLDV.setEnabled(false);
                  ql.QLNV.setEnabled(false);
                }
                else 
                {
                     JOptionPane.showMessageDialog(null, "Sai tên đăng nhập hoặc mật khẩu");
                     txtTenDN.setText("");
                     txtMK.setText("");
                }
                
                 
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_txtMKActionPerformed

    private void txtMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMKMouseClicked
        txtMK.setText("");
    }//GEN-LAST:event_txtMKMouseClicked

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
            java.util.logging.Logger.getLogger(LoginSever.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginSever.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginSever.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginSever.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginSever().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDangNhap;
    private javax.swing.JButton bThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPasswordField txtMK;
    private javax.swing.JTextField txtTenDN;
    // End of variables declaration//GEN-END:variables
}
