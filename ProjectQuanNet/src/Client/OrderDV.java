/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import QLTK.QLTKForm;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dang Do
 */
public class OrderDV extends javax.swing.JFrame {

    private java.sql.Connection conn = null;
    DefaultTableModel table = new DefaultTableModel();
     private Timer t;
    public OrderDV() {
        initComponents();
        Connect();
        runTime();
        this.getContentPane().setBackground(new java.awt.Color(189,231,253));
        this.setLocationRelativeTo(null);
    }
         private void Connect() { //ket noi csdl
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.print("ket noi thanh cong");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        try {

            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "DANGDO_CONNECT", "USERPASS");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }       
         public void runTime(){
         
         t = new Timer(1000, new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
             
             SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");  
             txtDate.setText(dFormat.format(new java.util.Date()));
          }
      });
        
       t.start();
       
    }
    public void LoadOrder()
    {
        table = (DefaultTableModel) list.getModel();
        try {
            PreparedStatement ps = conn.prepareStatement("Select * From (Select * From ORDERDV ORDER BY MADH DESC) WHERE ROWNUM=1");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object a[] = {rs.getString("MADH"),rs.getString("NGAYDH"), rs.getString("MADV"), rs.getString("SOLUONG"), rs.getString("THANHTIEN"),rs.getString("TENMAY")};
                table.addRow(a);
            }}
            catch(Exception e)
                    {
                    e.printStackTrace();
                    }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbLoai = new javax.swing.JComboBox<>();
        cbTenDV = new javax.swing.JComboBox<>();
        txtGia = new javax.swing.JLabel();
        txtSL = new javax.swing.JTextField();
        pane = new javax.swing.JScrollPane();
        list = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        bXacnhan = new javax.swing.JButton();
        bExit = new javax.swing.JButton();
        bChon = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTenMay = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("ĐẶT DỊCH VỤ");

        jLabel2.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel2.setText("Loại dịch vụ");

        jLabel3.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel3.setText("Tên dịch vụ");

        jLabel4.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel4.setText("Giá");

        jLabel5.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        jLabel5.setText("Số lượng");

        cbLoai.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        cbLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thức ăn", "Nước giải khát", "Thẻ cào" }));
        cbLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbLoaiActionPerformed(evt);
            }
        });

        cbTenDV.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        cbTenDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTenDVActionPerformed(evt);
            }
        });

        txtGia.setBackground(new java.awt.Color(255, 255, 255));
        txtGia.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtGia.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtSL.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N

        pane.setBackground(new java.awt.Color(255, 255, 255));

        list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đơn hàng", "Ngày đặt", "Mã dịch vụ", "Số lượng", "Thành tiền", "Tên máy"
            }
        ));
        pane.setViewportView(list);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bXacnhan.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        bXacnhan.setText("XÁC NHẬN");
        bXacnhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bXacnhanActionPerformed(evt);
            }
        });

        bExit.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        bExit.setText("BACK");
        bExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExitActionPerformed(evt);
            }
        });

        bChon.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        bChon.setText("CHỌN");
        bChon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bChonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bChon, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bXacnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bExit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(bChon, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bXacnhan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(bExit, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(189, 231, 253));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 255));
        jLabel6.setText("TỔNG TIỀN");

        txtTongTien.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        txtTongTien.setText("0000");
        txtTongTien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\ngay.png")); // NOI18N

        txtDate.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 255));
        jLabel8.setText("TÊN MÁY");

        txtTenMay.setText("???");
        txtTenMay.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(txtTongTien)
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTenMay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTenMay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8)
                        .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6))
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pane)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(169, 169, 169))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtSL, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pane, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bXacnhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bXacnhanActionPerformed
        
        int respone = JOptionPane.showConfirmDialog(this, "Bạn có muốn đặt dịch vụ không", "Xác nhận", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(respone == JOptionPane.YES_OPTION )
        {
            
            try {
                PreparedStatement ps1 = conn.prepareStatement("SELECT MADV FROM DICHVU WHERE TENDV=?");
                ps1.setString(1,cbTenDV.getSelectedItem().toString());
                ResultSet rs = ps1.executeQuery();
                rs.next();
                PreparedStatement ps = conn.prepareStatement("Insert into ORDERDV(MADV,SOLUONG,THANHTIEN,NGAYDH,TENMAY) values ('"+rs.getString("MADV")+"',?,?,?,'"+txtTenMay.getText()+"')");
                 ps.setString(1, txtSL.getText());
                 int Gia = Integer.parseInt(txtGia.getText());
                 int SL =Integer.parseInt(txtSL.getText());
                 ps.setString(2, String.valueOf(Gia*SL));   
                 ps.setString(3,txtDate.getText());
 
            int num = ps.executeUpdate();
            if (num > 0) {
                JOptionPane.showMessageDialog(this, "Đặt hàng thành công!");
                LoadOrder();
                TongTien();
                
            }
            } catch (SQLException ex) {
                Logger.getLogger(OrderDV.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
        else if (respone == JOptionPane.NO_OPTION)
        {
            
        }
        else if (respone == JOptionPane.CLOSED_OPTION)
        {
            
        }
        
    }//GEN-LAST:event_bXacnhanActionPerformed

    private void cbLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbLoaiActionPerformed
         
       
        if(cbLoai.getSelectedItem().equals("Thức ăn"))
         {
             try {
            PreparedStatement st;
            st = conn.prepareStatement("Select TENDV from DICHVU WHERE LOAIDV='Thuc an' GROUP BY TENDV");
            ResultSet rs = st.executeQuery();
            cbTenDV.removeAllItems();
            cbTenDV.setSelectedItem(null);
            while(rs.next())
            { 
                cbTenDV.addItem(rs.getString("TENDV"));   
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDV.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
         else if(cbLoai.getSelectedItem().equals("Nước giải khát"))
         {
             try {
            PreparedStatement st;
            st = conn.prepareStatement("Select TENDV from DICHVU WHERE LOAIDV='Nuoc giai khat' GROUP BY TENDV");
            ResultSet rs = st.executeQuery();
            cbTenDV.removeAllItems();
            cbTenDV.setSelectedItem(null);
            while(rs.next())
            {   
            cbTenDV.addItem(rs.getString("TENDV"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDV.class.getName()).log(Level.SEVERE, null, ex);
        }
         }
         if(cbLoai.getSelectedItem().equals("Thẻ cào"))
         {
             try {
            PreparedStatement st;
            st = conn.prepareStatement("Select TENDV from DICHVU WHERE LOAIDV='The cao' GROUP BY TENDV");
            ResultSet rs = st.executeQuery();
            cbTenDV.removeAllItems();
            cbTenDV.setSelectedItem(null);
            while(rs.next())
            { 
                cbTenDV.addItem(rs.getString("TENDV"));   
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDV.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
    }//GEN-LAST:event_cbLoaiActionPerformed
    public void TongTien()
    {
        int Tong=0;
        for(int i=0;i<table.getRowCount();i++)
        {
            Tong+=Integer.parseInt(table.getValueAt(i, 4).toString());
        }
        txtTongTien.setText(String.valueOf(Tong));
    }
    private void cbTenDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTenDVActionPerformed
        
    }//GEN-LAST:event_cbTenDVActionPerformed

    private void bChonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bChonActionPerformed
        HienGia();
    }//GEN-LAST:event_bChonActionPerformed

    private void bExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExitActionPerformed
        
        dispose();
    }//GEN-LAST:event_bExitActionPerformed
    public void HienGia()
    {
         try {
            String Gia = cbTenDV.getSelectedItem().toString();
            PreparedStatement st;
            st = conn.prepareStatement("Select DONGIA from DICHVU WHERE TENDV = '"+Gia+"' ");
            ResultSet rs = st.executeQuery();
            while(rs.next())
            {   
                String Giaca=rs.getString("DONGIA");
                txtGia.setText(Giaca);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderDV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
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
            java.util.logging.Logger.getLogger(OrderDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OrderDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OrderDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OrderDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new OrderDV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bChon;
    private javax.swing.JButton bExit;
    private javax.swing.JButton bXacnhan;
    private javax.swing.JComboBox<String> cbLoai;
    private javax.swing.JComboBox<String> cbTenDV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTable list;
    private javax.swing.JScrollPane pane;
    private javax.swing.JLabel txtDate;
    private javax.swing.JLabel txtGia;
    private javax.swing.JTextField txtSL;
    public static javax.swing.JLabel txtTenMay;
    public static javax.swing.JLabel txtTongTien;
    // End of variables declaration//GEN-END:variables
}
