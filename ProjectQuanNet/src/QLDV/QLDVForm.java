    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLDV;

import QLHV.FormQLHV;
import java.awt.Color;

import java.sql.DriverManager;   
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dang Do
 */
public class QLDVForm extends javax.swing.JFrame {
    private java.sql.Connection conn = null;
    DefaultTableModel table = new DefaultTableModel();
    DefaultTableModel table1 = new DefaultTableModel();
    /**
     * Creates new form QLDVForm
     */
    public QLDVForm() {
        initComponents();
        Connect();
        LoadDV();
        LoadDonDV();
        this.getContentPane().setBackground(new java.awt.Color(189,231,253));
        this.setLocationRelativeTo(null);
    }
    private void Connect() { //ket noi csdl
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.print("ket noi thanh cong");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLDVForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "DANGDO_CONNECT", "USERPASS");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }       
    
    
    private void LoadDV() {
         table = (DefaultTableModel) DVlist.getModel();
        try {
            PreparedStatement st = conn.prepareStatement("Select * from DichVu ORDER BY MADV ASC");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object a[] = {rs.getString("MaDV"), rs.getString("TenDV"), rs.getString("LoaiDV"),rs.getString("DonGia"), rs.getString("DonVi")};
                table.addRow(a);
            }
    }   catch (SQLException ex) {
            ex.printStackTrace();
        }
        DVlist.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (DVlist.getSelectedRow() >= 0) {
                        txtMaDV.setText(DVlist.getValueAt(DVlist.getSelectedRow(), 0) + "");
                        txtTenDV.setText(DVlist.getValueAt(DVlist.getSelectedRow(), 1) + "");
                        txtLoaiDV.setText(DVlist.getValueAt(DVlist.getSelectedRow(), 2) + "");
                        txtDonGia.setText(DVlist.getValueAt(DVlist.getSelectedRow(), 3) + "");
                       
                        txtDonVi.setText(DVlist.getValueAt(DVlist.getSelectedRow(), 4) + "");
                      
                    }
                }

            });
    }
    public void LoadDonDV()
    {
        table1 = (DefaultTableModel) tabledon.getModel();
        try {
            PreparedStatement st = conn.prepareStatement("Select * from orderdv ORDER BY MADH ASC");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object a[] = {rs.getString("MaDH"), rs.getString("MaDV"), rs.getString("NgayDH"),rs.getString("SoLuong"), rs.getString("ThanhTien"),rs.getString("TenMay")};
                table1.addRow(a);
            }       
    }   catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void TimKiemDV(String TenDVFind) throws Exception {
        table = (DefaultTableModel) DVlist.getModel();
        try {
            PreparedStatement ps = conn.prepareStatement("Select * From DichVu Where TenDV='" + TenDVFind + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object a[] = {rs.getString("MaDV"), rs.getString("TenDV"), rs.getString("LoaiDV"), rs.getString("DonGia"),rs.getString("DonVi")};
                table.addRow(a);
            }
            DVlist.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                     if (DVlist.getSelectedRow() >= 0) {
                        txtMaDV.setText(DVlist.getValueAt(DVlist.getSelectedRow(), 0) + "");
                        txtTenDV.setText(DVlist.getValueAt(DVlist.getSelectedRow(), 1) + "");
                        txtLoaiDV.setText(DVlist.getValueAt(DVlist.getSelectedRow(), 2) + "");
                        txtDonGia.setText(DVlist.getValueAt(DVlist.getSelectedRow(), 3) + "");
                        txtDonVi.setText(DVlist.getValueAt(DVlist.getSelectedRow(), 4) + "");
                      
                    }
                }
        });} catch (SQLException e) {

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
        jLabel6 = new javax.swing.JLabel();
        txtMaDV = new javax.swing.JTextField();
        txtTenDV = new javax.swing.JTextField();
        txtDonGia = new javax.swing.JTextField();
        txtDonVi = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        DVlist = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        Them = new javax.swing.JButton();
        CapNhat = new javax.swing.JButton();
        TimKiem = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtLoaiDV = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabledon = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("QUẢN LÝ DỊCH VỤ");

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("QUẢN LÝ DỊCH VỤ");

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel2.setText("Mã dịch vụ");

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel3.setText("Tên dịch vụ");

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel4.setText("Loại dịch vụ");

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel5.setText("Đơn giá");

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel6.setText("Đơn vị");

        txtDonGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDonGiaActionPerformed(evt);
            }
        });

        DVlist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã dịch vụ", "Tên dịch vụ", "Loại dịch vụ", "Đơn giá", "Đơn vị"
            }
        ));
        jScrollPane1.setViewportView(DVlist);

        jPanel1.setBackground(new java.awt.Color(189, 231, 253));

        Them.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\THEM.png")); // NOI18N
        Them.setText("Thêm");
        Them.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Them.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemActionPerformed(evt);
            }
        });

        CapNhat.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\capnhat.png")); // NOI18N
        CapNhat.setText("Cập nhật");
        CapNhat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CapNhat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        CapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CapNhatActionPerformed(evt);
            }
        });

        TimKiem.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\timkiem.png")); // NOI18N
        TimKiem.setText("Tra cứu");
        TimKiem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        TimKiem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimKiemActionPerformed(evt);
            }
        });

        Reset.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\reset.png")); // NOI18N
        Reset.setText("Reset");
        Reset.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Reset.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\back.png")); // NOI18N
        jButton1.setText("Back");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Them, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                        .addComponent(CapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Them, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabledon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đơn hàng", "Mã dịch vụ", "Ngày đặt hàng", "Số lượng", "Thành tiền", "Tên máy"
            }
        ));
        jScrollPane2.setViewportView(tabledon);

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("ĐƠN ĐẶT DỊCH VỤ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtLoaiDV, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addGap(115, 115, 115))))
            .addGroup(layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(jLabel1)
                .addGap(0, 248, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtLoaiDV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtDonGia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtDonVi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDonGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDonGiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDonGiaActionPerformed

    private void ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemActionPerformed
        StringBuilder sb = new StringBuilder();
        if (txtTenDV.getText().equals("")) {
            sb.append("Tên dịch vụ không được để trống!!!");
            txtTenDV.setBackground(Color.BLUE);
        } else {
            txtTenDV.setBackground(Color.white);
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
         if (txtLoaiDV.getText().equals("")) {
            sb.append("Loại dịch vụ không được để trống!!!");
            txtLoaiDV.setBackground(Color.BLUE);
        } else {
            txtLoaiDV.setBackground(Color.white);
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
         if (txtDonGia.getText().equals("")) {
            sb.append("Đơn giá không được để trống!!!");
            txtDonGia.setBackground(Color.BLUE);
        } else {
            txtDonGia.setBackground(Color.white);
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        
        try {
            PreparedStatement ps = conn.prepareStatement("Insert into DichVu(TENDV,LOAIDV,DONGIA,DONVI) values (?,?,?,?)");
            
            ps.setString(1, txtTenDV.getText());
            ps.setString(2, txtLoaiDV.getText()); 
            ps.setString(3, txtDonGia.getText());
            ps.setString(4, txtDonVi.getText());    

    
            int num = ps.executeUpdate();
            if (num > 0) {
                JOptionPane.showMessageDialog(this, "Dịch vụ được thêm vào thành công!");
                table.setRowCount(0);
                LoadDV();
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập thông tin đầy đủ");
        }
    }//GEN-LAST:event_ThemActionPerformed

    private void TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemActionPerformed
        String TenDVFind = txtTenDV.getText();
        try {
            table.setRowCount(0);
            TimKiemDV(TenDVFind);
             if(table.getRowCount()==0)
            {
                JOptionPane.showMessageDialog(this, "Dịch vụ không tìm thấy!");
            }
        } catch (Exception ex) {
            Logger.getLogger(QLDVForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TimKiemActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        txtMaDV.setText("");
        txtTenDV.setText("");
        txtLoaiDV.setText(""); 
        txtDonGia.setText("");
        txtDonVi.setText("");   

        table.setRowCount(0);
        LoadDV();
        
    }//GEN-LAST:event_ResetActionPerformed

    private void CapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CapNhatActionPerformed
         StringBuilder sb = new StringBuilder();
        if (txtTenDV.getText().equals("")) {
            sb.append("Tên dịch vụ không được để trống!!!");
            txtTenDV.setBackground(Color.BLUE);
        } else {
            txtTenDV.setBackground(Color.white);
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
         if (txtLoaiDV.getText().equals("")) {
            sb.append("Loại dịch vụ không được để trống!!!");
            txtLoaiDV.setBackground(Color.BLUE);
        } else {
            txtLoaiDV.setBackground(Color.white);
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        if (txtDonGia.getText().equals("")) {
            sb.append("Đơn giá không được để trống!!!");
            txtDonGia.setBackground(Color.BLUE);
        } else {
            txtDonGia.setBackground(Color.white);
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try {
            PreparedStatement ps = conn.prepareStatement("update DichVu set  TenDV = ?,LoaiDV=?, DonGia=?, DonVi=? where MaDV = ?");
            ps.setString(5, txtMaDV.getText());
            ps.setString(1, txtTenDV.getText());       
            ps.setString(2, txtLoaiDV.getText()); 
            ps.setString(3, txtDonGia.getText());
            ps.setString(4, txtDonVi.getText());

            int num = ps.executeUpdate();
            if (num > 0) {
                JOptionPane.showMessageDialog(this, "Dịch vụ được cập nhật thành công!");
                table.setRowCount(0);
                LoadDV();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_CapNhatActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
            dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(QLDVForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLDVForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLDVForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLDVForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLDVForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CapNhat;
    private javax.swing.JTable DVlist;
    private javax.swing.JButton Reset;
    private javax.swing.JButton Them;
    private javax.swing.JButton TimKiem;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabledon;
    private javax.swing.JTextField txtDonGia;
    private javax.swing.JTextField txtDonVi;
    private javax.swing.JTextField txtLoaiDV;
    private javax.swing.JTextField txtMaDV;
    private javax.swing.JTextField txtTenDV;
    // End of variables declaration//GEN-END:variables
}
