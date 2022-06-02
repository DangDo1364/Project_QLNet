/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLTK;

import static Client.LoginForm.tk;
import QLHV.FormQLHV;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


public class QLTKForm extends javax.swing.JFrame {

    private java.sql.Connection conn = null;
    DefaultTableModel table = new DefaultTableModel();
    FormQLHV form1 = new FormQLHV();
    private Timer t;
    public QLTKForm() {
        initComponents();
        Connect();
        runTime();
        LoadTK();
        this.getContentPane().setBackground(new java.awt.Color(189,231,253));
        this.setLocationRelativeTo(null);
    }
    
     private void Connect() { //ket noi csdl
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.print("ket noi thanh cong");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QLTKForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "DANGDO_CONNECT", "USERPASS");

        } catch (SQLException ex) {
            Logger.getLogger(QLTKForm.class.getName()).log(Level.SEVERE, null, ex);
        }

    }       
     
     private void LoadTK() {
         table = (DefaultTableModel) TKlist.getModel();
        try {
            PreparedStatement st = conn.prepareStatement("Select * from TAIKHOANHV ");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object a[] = {rs.getString("TENTAIKHOAN"), rs.getString("MATKHAU"),rs.getString("NHOMNGUOIDUNG"), rs.getString("TIENCONLAI"),rs.getString("TRANGTHAI")};
                table.addRow(a);
            }
    }   catch (SQLException ex) {
            Logger.getLogger(QLTKForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        TKlist.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (TKlist.getSelectedRow() >= 0) {
                        txtTenTK.setText(TKlist.getValueAt(TKlist.getSelectedRow(), 0) + "");
                        txtMK.setText(TKlist.getValueAt(TKlist.getSelectedRow(), 1) + "");     
                        txtNhomND.setText(TKlist.getValueAt(TKlist.getSelectedRow(), 2) + "");                    
                        txtTien.setText(TKlist.getValueAt(TKlist.getSelectedRow(), 3) + "");
                        txtTrangThai.setText(TKlist.getValueAt(TKlist.getSelectedRow(), 4) + "");                    
                    }
                }

            });
        
    }
    public void TimKiemTK(String TenTKFind) throws Exception {
        table = (DefaultTableModel) TKlist.getModel();
        try {
            PreparedStatement ps = conn.prepareStatement("Select * From TAIKHOANHV Where TenTaiKhoan='" + TenTKFind + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object a[] = {rs.getString("TenTaiKhoan"), rs.getString("MatKhau"), rs.getString("NhomNguoiDung"),rs.getString("TienConLai"),rs.getString("TrangThai")};
                table.addRow(a);
            }
            TKlist.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                     if (TKlist.getSelectedRow() >= 0) {
                        txtTenTK.setText(TKlist.getValueAt(TKlist.getSelectedRow(), 0) + "");
                        txtMK.setText(TKlist.getValueAt(TKlist.getSelectedRow(), 1) + "");  
                        txtNhomND.setText(TKlist.getValueAt(TKlist.getSelectedRow(), 2) + "");                    
                        txtTien.setText(TKlist.getValueAt(TKlist.getSelectedRow(), 3) + "");
                        txtTrangThai.setText(TKlist.getValueAt(TKlist.getSelectedRow(), 4) + "");
                      
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTenTK = new javax.swing.JTextField();
        txtNhomND = new javax.swing.JTextField();
        txtTrangThai = new javax.swing.JTextField();
        txtTien = new javax.swing.JTextField();
        jScrollPane = new javax.swing.JScrollPane();
        TKlist = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        CapNhat = new javax.swing.JButton();
        TimKiem = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        Them = new javax.swing.JButton();
        ThemTien = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtTienThem = new javax.swing.JTextField();
        txtMK = new javax.swing.JPasswordField();
        check = new javax.swing.JCheckBox();
        jLabel2 = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("QUẢN LÝ TÀI KHOẢN");

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("QUẢN LÝ TÀI KHOẢN");

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel3.setText("Tên tài khoản");

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel4.setText("Mật khẩu");

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel6.setText("Nhóm người dùng");

        jLabel7.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel7.setText("Tiền còn lại");

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel8.setText("Trạng thái");

        txtTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTrangThaiActionPerformed(evt);
            }
        });

        TKlist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên tài khoản", "Mật khẩu", "Nhóm người dùng", "Tiền còn lại", "Trạng thái"
            }
        ));
        jScrollPane.setViewportView(TKlist);

        jPanel1.setBackground(new java.awt.Color(189, 231, 253));

        CapNhat.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        CapNhat.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\capnhat.png")); // NOI18N
        CapNhat.setText("Cập nhật");
        CapNhat.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        CapNhat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CapNhat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        CapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CapNhatActionPerformed(evt);
            }
        });

        TimKiem.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        TimKiem.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\timkiem.png")); // NOI18N
        TimKiem.setText("Tra cứu");
        TimKiem.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        TimKiem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        TimKiem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimKiemActionPerformed(evt);
            }
        });

        Reset.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        Reset.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\reset.png")); // NOI18N
        Reset.setText("Reset");
        Reset.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        Reset.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Reset.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        Them.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        Them.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\THEM.png")); // NOI18N
        Them.setText("Thêm");
        Them.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        Them.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Them.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemActionPerformed(evt);
            }
        });

        ThemTien.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        ThemTien.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\THEM.png")); // NOI18N
        ThemTien.setText("Thêm tiền");
        ThemTien.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        ThemTien.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ThemTien.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ThemTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemTienActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\THEM.png")); // NOI18N
        jButton1.setText("Thêm hội viên");
        jButton1.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\back.png")); // NOI18N
        jButton2.setText("Back");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(Them, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ThemTien, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(112, 112, 112))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Them, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ThemTien, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel9.setText("Tiền thêm");

        check.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\ngay.png")); // NOI18N

        txtDate.setText("Time");
        txtDate.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel7)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtTenTK, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtNhomND, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtTien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTienThem, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(check)))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGap(241, 241, 241)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTenTK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel4)
                                .addComponent(txtMK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(check, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNhomND, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTrangThai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtTienThem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTrangThaiActionPerformed

    private void TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemActionPerformed
         String TenTKFind = txtTenTK.getText();
         table.setRowCount(0);
        try {
            TimKiemTK(TenTKFind);
             if(table.getRowCount()==0)
            {
                JOptionPane.showMessageDialog(this, "Tài khoản không tìm thấy!");
            }
        } catch (Exception ex) {
            Logger.getLogger(QLTKForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TimKiemActionPerformed

    private void ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemActionPerformed
        StringBuilder sb = new StringBuilder();
       
        //tentk
         if (txtTenTK.getText().equals("")) {
            sb.append("Tên tài khoản không được để trống!!!");
            txtTenTK.setBackground(Color.BLUE);
        } else {
            txtTenTK.setBackground(Color.white);
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        // mk   
         if (txtMK.getText().equals("")) {
            sb.append("Mật khẩu không được để trống!!!");
            txtMK.setBackground(Color.BLUE);
        } else {
            txtMK.setBackground(Color.white);
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb);
            return;
        }               
        try {
             PreparedStatement st = conn.prepareStatement("Select * from TAIKHOANHV WHERE TENTAIKHOAN=?");
              st.setString(1,txtTenTK.getText());
              ResultSet rs = st.executeQuery();
        if(rs.next()){
            JOptionPane.showMessageDialog(this, "Tài khoản đã tồn tại!");
        }  
        else
        {
            PreparedStatement ps = conn.prepareStatement("Insert into TAIKHOANHV(TENTAIKHOAN,MATKHAU,NHOMNGUOIDUNG,TIENCONLAI,TRANGTHAI) values (?,?,'Member',0,'Not-actived')");
            ps.setString(1, txtTenTK.getText());
            ps.setString(2, txtMK.getText());

            int num = ps.executeUpdate();
            if (num > 0) {
                JOptionPane.showMessageDialog(this, "Tài khoản được thêm vào thành công!");
                table.setRowCount(0);
                LoadTK();
            }
            
        }     

        } catch (Exception e) {
            e.printStackTrace();
        }
         
       

                
        
        
       
        
         
        
    }//GEN-LAST:event_ThemActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        txtTenTK.setText("");
        txtMK.setText("");
        txtNhomND.setText(""); 
        txtTien.setText("");    
        txtTrangThai.setText("");
        txtTienThem.setText("");
      

        table = (DefaultTableModel) TKlist.getModel();
        int rowcount = table.getRowCount();
        for (int i = rowcount - 1; i >= 0; i--) {
            table.removeRow(i);
        }
        LoadTK();
    }//GEN-LAST:event_ResetActionPerformed

    private void CapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CapNhatActionPerformed
        try {
            PreparedStatement ps = conn.prepareStatement("update TAIKHOANHV set  MatKhau = ?,NhomNguoiDung=?, TrangThai=? where TenTaiKhoan = ?");
            ps.setString(4, txtTenTK.getText());
            ps.setString(1, txtMK.getText());       
            ps.setString(2, txtNhomND.getText()); 
            ps.setString(3, txtTrangThai.getText());

            int num = ps.executeUpdate();
            if (num > 0) {
                JOptionPane.showMessageDialog(this, "Tài khoản được cập nhật thành công!");
                table.setRowCount(0);
                LoadTK();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_CapNhatActionPerformed
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
    private void ThemTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemTienActionPerformed
        int TienThem = Integer.parseInt(txtTienThem.getText());
        if(TienThem>5000)
        {
        try {
            PreparedStatement ps = conn.prepareStatement("update TAIKHOANHV set  TienConLai = TienConLai + ? where TenTaiKhoan = ?");
            ps.setString(2, txtTenTK.getText());
            ps.setString(1, txtTienThem.getText());       
            // them vao nhat ki giao dich them tien
            PreparedStatement ps1 = conn.prepareStatement("Insert into NHATKIGDTHEMTIEN(TENTAIKHOAN,TIENTHEM,NGAYGD) values (?,?,?)");
            ps1.setString(1, txtTenTK.getText());
            ps1.setString(2, txtTienThem.getText());
            ps1.setString(3, txtDate.getText()); 
            
            ps1.executeUpdate();
            
            int num = ps.executeUpdate();   
            if (num > 0) {
                JOptionPane.showMessageDialog(this, "Thêm tiền vào tài khoản thành công!");
                table.setRowCount(0);
                LoadTK();

            }
        } catch (SQLException e) {
            e.printStackTrace(); 
            
        }
        }
        else
        {
                 JOptionPane.showMessageDialog(this, "Số tiền bổ sung tối thiểu là 5000!");

        }
        
    }//GEN-LAST:event_ThemTienActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();  
        form1.setVisible(true);
        form1.txtTenTaiKhoan.setText(txtTenTK.getText());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void checkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkActionPerformed
        if(check.isSelected())
        {
            txtMK.setEchoChar((char)0);
        }
        else
        {
            txtMK.setEchoChar('*');
        }
               
    }//GEN-LAST:event_checkActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(QLTKForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QLTKForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QLTKForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QLTKForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLTKForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CapNhat;
    private javax.swing.JButton Reset;
    private javax.swing.JTable TKlist;
    private javax.swing.JButton Them;
    private javax.swing.JButton ThemTien;
    private javax.swing.JButton TimKiem;
    private javax.swing.JCheckBox check;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane;
    private javax.swing.JLabel txtDate;
    private javax.swing.JPasswordField txtMK;
    private javax.swing.JTextField txtNhomND;
    public static javax.swing.JTextField txtTenTK;
    private javax.swing.JTextField txtTien;
    private javax.swing.JTextField txtTienThem;
    private javax.swing.JTextField txtTrangThai;
    // End of variables declaration//GEN-END:variables

  
}
