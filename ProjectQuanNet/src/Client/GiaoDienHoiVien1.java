/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import static Client.LoginForm.tk;
import static QLHV.FormQLHV.txtTenTaiKhoan;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dang Do
 */
public class GiaoDienHoiVien1 extends javax.swing.JFrame {

    private Timer t;
    private java.sql.Connection conn = null;
    String dsecond,dminute,dhour;
    
    DecimalFormat f = new DecimalFormat("00");
    int s=0;
    int m=0;
    int h=0;
   
    public GiaoDienHoiVien1() {
        initComponents();
        Connect();
        runTime();
       
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
            
        }

    }       
    public void runTime(){
         
         t = new Timer(1000, new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
             SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
             SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
            txtTime.setText(sdf.format(new java.util.Date()));
            txtDate1.setText(dFormat.format(new java.util.Date()));
              
          }
      });
        
       t.start();
    }
    
   
    public void Load()
    {   
        
       
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        txtTimeBD.setText(sdf.format(date));
        t = new Timer(1000, new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            s++;
           
            dsecond = f.format(s);
            dminute = f.format(m);
            dhour = f.format(h);
            txtTimeSD.setText(dhour+":"+dminute+":"+dsecond);
            if(s==60)
            {
                s=0;
                m++;
                txtTimeSD.setText(dhour+":"+dminute+":"+dsecond);
            }
            else if(m==60)
            {
                m=0;
                h++;
                txtTimeSD.setText(dhour+":"+dminute+":"+dsecond);
            }
            
            
          }
      });
        t.start();
       
       
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bTN = new javax.swing.JButton();
        bDV = new javax.swing.JButton();
        txtDate1 = new javax.swing.JLabel();
        txtTime = new javax.swing.JLabel();
        txtTenMay = new javax.swing.JLabel();
        txtTimeBD = new javax.swing.JLabel();
        txtTimeSD = new javax.swing.JLabel();
        txtTienTK = new javax.swing.JLabel();
        txtTienNguoc = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocation(new java.awt.Point(1100, 0));

        jPanel2.setBackground(new java.awt.Color(51, 102, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel1.setText("Tên máy");

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel2.setText("Thời gian bắt đầu");

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel3.setText("Thời gian sử dụng");

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 12)); // NOI18N
        jLabel4.setText("Tiền ");

        bTN.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        bTN.setText("Tin Nhắn");
        bTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bTNActionPerformed(evt);
            }
        });

        bDV.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        bDV.setText("Dịch Vụ");
        bDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDVActionPerformed(evt);
            }
        });

        txtDate1.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtDate1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtTime.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtTenMay.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtTimeBD.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtTimeSD.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtTienTK.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\ngay.png")); // NOI18N

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\dongho.png")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addComponent(bTN, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTienNguoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(bDV, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 14, Short.MAX_VALUE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTime, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                            .addComponent(txtDate1, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtTenMay, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtTienTK, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTimeSD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTimeBD, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenMay, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTimeBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTimeSD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTienTK, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTienNguoc, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bTN, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bDV, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(txtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(txtDate1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 39, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bTNActionPerformed
        ClientGUI chat = new ClientGUI();
        chat.inputName.setText(txtTenMay.getText());
        chat.inputIP.setText("127.0.0.1");
        chat.inputPort.setText("20");
        chat.setVisible(true);
    }//GEN-LAST:event_bTNActionPerformed

    private void bDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDVActionPerformed
        OrderDV dv = new OrderDV();
        dv.txtTenMay.setText(txtTenMay.getText());
        dv.setVisible(true);
    }//GEN-LAST:event_bDVActionPerformed

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
            java.util.logging.Logger.getLogger(GiaoDienHoiVien1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoDienHoiVien1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoDienHoiVien1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoDienHoiVien1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GiaoDienHoiVien1().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bDV;
    private javax.swing.JButton bTN;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel txtDate1;
    public static javax.swing.JLabel txtTenMay;
    private javax.swing.JLabel txtTienNguoc;
    public static javax.swing.JLabel txtTienTK;
    private javax.swing.JLabel txtTime;
    public static javax.swing.JLabel txtTimeBD;
    public static javax.swing.JLabel txtTimeSD;
    // End of variables declaration//GEN-END:variables
}
