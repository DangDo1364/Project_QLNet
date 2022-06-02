/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLNV;

import static QLTK.QLTKForm.txtTenTK;
import java.awt.Color;
import java.awt.List;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
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
public class FormQLNV extends javax.swing.JFrame {

    /**
     * Creates new form FormQLNV
     */
    private Connection conn = null;
    DefaultTableModel table = new DefaultTableModel();

    public FormQLNV() {
        Connect();
        initComponents();
        LoadNV();
        this.getContentPane().setBackground(new java.awt.Color(189,231,253));
        this.setLocationRelativeTo(null);
    }

    private void Connect() { 
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.print("ket noi thanh cong");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormQLNV.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "DANGDO_CONNECT", "USERPASS");

        } catch (SQLException ex) {
            Logger.getLogger(FormQLNV.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void LoadNV() 
    { 
        table = (DefaultTableModel) NVlist.getModel(); 
        try {
            PreparedStatement st = conn.prepareStatement("Select * from NhanVien ORDER BY MANV"); 
            ResultSet rs = st.executeQuery(); 
            while (rs.next()) 
            {
                Object a[] = {rs.getString("MaNV"), rs.getString("TenNV"), rs.getString("TenTaiKhoanNV"), rs.getString("TenNhom"), rs.getString("SDT"), rs.getString("Email"), rs.getString("DiaChi"), rs.getString("GioiTinh")};
                table.addRow(a); 
            } 
            NVlist.getSelectionModel().addListSelectionListener(new ListSelectionListener() 
            {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (NVlist.getSelectedRow() >= 0) {
                        txtMaNV.setText(NVlist.getValueAt(NVlist.getSelectedRow(), 0) + ""); 
                        
                        txtTenNV.setText(NVlist.getValueAt(NVlist.getSelectedRow(), 1) + ""); 
                        txtTenTaiKhoanNV.setText(NVlist.getValueAt(NVlist.getSelectedRow(), 2) + ""); 
                        txtTenNhom.setText(NVlist.getValueAt(NVlist.getSelectedRow(), 3) + "");
                        txtSDT.setText(NVlist.getValueAt(NVlist.getSelectedRow(), 4) + "");
                        txtEmail.setText(NVlist.getValueAt(NVlist.getSelectedRow(), 5) + "");
                        txtDiaChi.setText(NVlist.getValueAt(NVlist.getSelectedRow(), 6) + "");
                        String gt = (String) NVlist.getValueAt(NVlist.getSelectedRow(), 7);
                        if (gt.equals("Nam")) 
                        {
                            txtNam.setSelected(true);
                        } else 
                        {
                            txtNu.setSelected(true);
                        }

                    }
                }

            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void TimKiemNV(String TenNVFind) throws Exception {
        table = (DefaultTableModel) NVlist.getModel(); 
        try {
            PreparedStatement ps = conn.prepareStatement("Select * From NhanVien Where TenNV='" + TenNVFind + "'"); 
            ResultSet rs = ps.executeQuery(); 
            while (rs.next()) 
            {
                Object a[] = {rs.getString("MANV"), rs.getString("TENNV"), rs.getString("TENTAIKHOANNV"), rs.getString("TENNHOM"), rs.getString("SDT"), rs.getString("EMAIL"), rs.getString("DIACHI"), rs.getString("GIOITINH")};
                table.addRow(a);
            }
            NVlist.getSelectionModel().addListSelectionListener(new ListSelectionListener() 
            {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (NVlist.getSelectedRow() >= 0) {
                        
                        txtTenNV.setText(NVlist.getValueAt(NVlist.getSelectedRow(), 1) + "");
                        txtTenTaiKhoanNV.setText(NVlist.getValueAt(NVlist.getSelectedRow(), 2) + "");
                        txtTenNhom.setText(NVlist.getValueAt(NVlist.getSelectedRow(), 3) + "");
                        txtSDT.setText(NVlist.getValueAt(NVlist.getSelectedRow(), 4) + "");
                        txtEmail.setText(NVlist.getValueAt(NVlist.getSelectedRow(), 5) + "");
                        txtDiaChi.setText(NVlist.getValueAt(NVlist.getSelectedRow(), 6) + "");
                        String gt = (String) NVlist.getValueAt(NVlist.getSelectedRow(), 7);
                        if (gt.equals("Nam")) {
                            txtNam.setSelected(true);
                        } else {
                            txtNu.setSelected(true);
                        }

                    }
                }
        });} catch (SQLException e) {

            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtNam = new javax.swing.JRadioButton();
        txtNu = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTenTaiKhoanNV = new javax.swing.JTextField();
        txtTenNhom = new javax.swing.JTextField();
        txtDiaChi = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        Them = new javax.swing.JButton();
        Capnhat = new javax.swing.JButton();
        Timkiem = new javax.swing.JButton();
        Resest = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        NVlist = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("QUẢN LÝ NHÂN VIÊN");
        setBackground(new java.awt.Color(153, 204, 255));

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("QUẢN LÝ NHÂN VIÊN");

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel2.setText("Mã nhân viên");

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel3.setText("Họ và tên");

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel4.setText("Số điện thoại");

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel5.setText("Email");

        jLabel6.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel6.setText("Địa chỉ");

        jLabel7.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel7.setText("Giới tính");

        txtMaNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaNVActionPerformed(evt);
            }
        });

        txtTenNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenNVActionPerformed(evt);
            }
        });

        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        txtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEmailActionPerformed(evt);
            }
        });

        txtNam.setText("Nam");
        txtNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamActionPerformed(evt);
            }
        });

        txtNu.setText("Nữ");
        txtNu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNuActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel8.setText("Tên tài khoản NV");

        jLabel9.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel9.setText("Tên nhóm");

        txtTenTaiKhoanNV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenTaiKhoanNVActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(189, 231, 253));

        Them.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\THEM.png")); // NOI18N
        Them.setText("Thêm");
        Them.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Them.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemActionPerformed(evt);
            }
        });

        Capnhat.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\capnhat.png")); // NOI18N
        Capnhat.setText("Cập nhật");
        Capnhat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Capnhat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Capnhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CapnhatActionPerformed(evt);
            }
        });

        Timkiem.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\timkiem.png")); // NOI18N
        Timkiem.setText("Tra cứu");
        Timkiem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Timkiem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Timkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimkiemActionPerformed(evt);
            }
        });

        Resest.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\reset.png")); // NOI18N
        Resest.setText("Resest");
        Resest.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Resest.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Resest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResestActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(Them, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Capnhat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Resest, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(97, 97, 97))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Them, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Capnhat, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Resest, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Timkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        NVlist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã nhân viên", "Họ và tên", "Tên tài khoản NV", "Tên nhóm", "SDT", "Email", "Địa chỉ", "Giới tính"
            }
        ));
        NVlist.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                NVlistMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(NVlist);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtTenTaiKhoanNV, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtNam)
                            .addGap(45, 45, 45)
                            .addComponent(txtNu))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTenNhom, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 518, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(286, 286, 286))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNam)
                            .addComponent(txtNu)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenTaiKhoanNV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenNhom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenNVActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void txtNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamActionPerformed
         if(txtNam.isSelected()) 
        {
            txtNu.setSelected(false);
        }
    }//GEN-LAST:event_txtNamActionPerformed

    private void txtNuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNuActionPerformed
         if(txtNu.isSelected()) 
        {
            txtNam.setSelected(false);
        }
    }//GEN-LAST:event_txtNuActionPerformed

    private void ThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemActionPerformed
        StringBuilder sb = new StringBuilder();
        if (txtTenNV.getText().equals("")) {
            sb.append("Tên nhân viên không được để trống!!!");
            txtTenNV.setBackground(Color.BLUE);
        } else {
            txtTenNV.setBackground(Color.white);
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        
        try {
            if (txtSDT.getText().matches("^[0-9]{10}$") == true && txtSDT.getText().length() > 2) {    
            PreparedStatement ps = conn.prepareStatement("Insert into NhanVien(TENNV,TENTAIKHOANNV,TENNHOM,SDT,EMAIL,DIACHI,GIOITINH) values(?,?,?,?,?,?,?)"); // câu lệnh thêm
           
            ps.setString(1, txtTenNV.getText()); 
            ps.setString(2, txtTenTaiKhoanNV.getText()); 
            ps.setString(3, txtTenNhom.getText()); 
            ps.setString(4, txtSDT.getText()); 
            ps.setString(5, txtEmail.getText()); 
            ps.setString(6, txtDiaChi.getText()); 

            txtNam.setText("Nam"); 
            txtNu.setText("Nữ");
            if (txtNam.isSelected()) {
                ps.setString(7, txtNam.getText());
            }
            if (txtNu.isSelected()) {
                ps.setString(7, txtNu.getText());
            }
            int num = ps.executeUpdate(); 
            if (num > 0) {
                JOptionPane.showMessageDialog(this, "Nhân viên được thêm vào thành công!");
                table.setRowCount(0); // làm trống lại jtable
                LoadNV(); // load dữ liệu lên jtable

            }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nhập thiếu thông tin, yêu cầu nhập đầy đủ thông tin");
        }


    }//GEN-LAST:event_ThemActionPerformed

    private void txtTenTaiKhoanNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenTaiKhoanNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenTaiKhoanNVActionPerformed

    private void NVlistMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_NVlistMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_NVlistMouseClicked

    private void txtMaNVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaNVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaNVActionPerformed

    private void CapnhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CapnhatActionPerformed
        
        try {
            if (txtSDT.getText().matches("^[0-9]{10}$") == true && txtSDT.getText().length() > 2) {    
            PreparedStatement ps = conn.prepareStatement("update NhanVien set  TenNV = ?, TenTaiKhoanNV = ?, TenNhom=?, SDT=?, Email=?, DiaChi=?, GioiTinh=? where MaNV = ?");
            ps.setString(8, txtMaNV.getText()); 
            ps.setString(1, txtTenNV.getText());
            ps.setString(2, txtTenTaiKhoanNV.getText());
            ps.setString(3, txtTenNhom.getText());
            ps.setString(4, txtSDT.getText());
            ps.setString(5, txtEmail.getText());
            ps.setString(6, txtDiaChi.getText());   

            txtNam.setText("Nam");
            txtNu.setText("Nữ");
            if (txtNam.isSelected()) {
                ps.setString(7, txtNam.getText());
            }
            if (txtNu.isSelected()) {
                ps.setString(7, txtNu.getText());
            }
            int num = ps.executeUpdate();
            if (num > 0) {
                JOptionPane.showMessageDialog(this, "Nhân viên được cập nhật thành công!");
                table.setRowCount(0);
                LoadNV();

            }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Nhập thiếu thông tin, yêu cầu nhập đầy đủ thông tin");
        }
    }//GEN-LAST:event_CapnhatActionPerformed

    private void ResestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResestActionPerformed
        // set text trống
        txtMaNV.setText("");
        txtTenNV.setText("");
        txtTenTaiKhoanNV.setText("");
        txtTenNhom.setText("");
        txtSDT.setText("");
        txtEmail.setText("");
        txtDiaChi.setText("");
        
        txtNam.setSelected(false);
        txtNu.setSelected(false);
        table.setRowCount(0);
        LoadNV();


    }//GEN-LAST:event_ResestActionPerformed

    private void TimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimkiemActionPerformed
        // goi lại hàm tìm kiếm
        String find = txtTenNV.getText();
        try {
            table.setRowCount(0); // set jtable trống
            TimKiemNV(find);
            if(table.getRowCount()==0)
            {
                JOptionPane.showMessageDialog(this, "Nhân viên không tìm thấy!");
            }
        } catch (Exception ex) {
            Logger.getLogger(FormQLNV.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_TimkiemActionPerformed

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
            java.util.logging.Logger.getLogger(FormQLNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormQLNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormQLNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormQLNV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {

                new FormQLNV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Capnhat;
    private javax.swing.JTable NVlist;
    private javax.swing.JButton Resest;
    private javax.swing.JButton Them;
    private javax.swing.JButton Timkiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JRadioButton txtNam;
    private javax.swing.JRadioButton txtNu;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNV;
    private javax.swing.JTextField txtTenNhom;
    private javax.swing.JTextField txtTenTaiKhoanNV;
    // End of variables declaration//GEN-END:variables

}
