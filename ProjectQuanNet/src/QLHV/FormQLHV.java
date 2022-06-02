
package QLHV;

import QLNV.FormQLNV;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


public class FormQLHV extends javax.swing.JFrame {

    private Connection conn = null;
    DefaultTableModel table = new DefaultTableModel();
    public FormQLHV() {
        initComponents();
        Connect();
        LoadHV();
        this.getContentPane().setBackground(new java.awt.Color(189,231,253));
        this.setLocationRelativeTo(null);
    }
    private void Connect() { //ket noi csdl
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.print("ket noi thanh cong");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormQLHV.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "DANGDO_CONNECT", "USERPASS");

        } catch (SQLException ex) {
            Logger.getLogger(FormQLHV.class.getName()).log(Level.SEVERE, null, ex);
        }

    }       
    private void LoadHV() {
         table = (DefaultTableModel) HVlist.getModel();
        try {
            PreparedStatement st = conn.prepareStatement("Select * from HoiVien order by MaHV asc");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object a[] = {rs.getString("MaHV"), rs.getString("TenHV"), rs.getString("TenTaiKhoan"), 
                    rs.getString("SDT"), rs.getString("Email"), rs.getString("GioiTinh")};
                table.addRow(a);
            }
    }   catch (SQLException ex) {
            Logger.getLogger(FormQLHV.class.getName()).log(Level.SEVERE, null, ex);
        }
        HVlist.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
                @Override
                public void valueChanged(ListSelectionEvent e) {
                    if (HVlist.getSelectedRow() >= 0) {
                        txtMaHV.setText(HVlist.getValueAt(HVlist.getSelectedRow(), 0) + "");
                        txtTenHV.setText(HVlist.getValueAt(HVlist.getSelectedRow(), 1) + "");   
                        txtTenTaiKhoan.setText(HVlist.getValueAt(HVlist.getSelectedRow(), 2) + "");                          
                        txtSDT.setText(HVlist.getValueAt(HVlist.getSelectedRow(), 3) + "");
                        txtEmail.setText(HVlist.getValueAt(HVlist.getSelectedRow(), 4) + "");
                        String gt = (String) HVlist.getValueAt(HVlist.getSelectedRow(), 5);
                        if (gt.equals("Nam")) {
                            txtNam.setSelected(true);
                        } else {
                            txtNu.setSelected(true);
                        }

                    }
                }

            });
    }
   
     public void TimKiemHV(String TENHVFind) throws Exception {
        table = (DefaultTableModel) HVlist.getModel();
        try {
            PreparedStatement ps = conn.prepareStatement("Select * From HoiVien Where TENHV='" + TENHVFind + "'");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Object a[] = {rs.getString("MaHV"), rs.getString("TenHV"), rs.getString("TenTaiKhoan"),
                    rs.getString("SDT"), rs.getString("Email"), rs.getString("GioiTinh")};
                    table.addRow(a);   
                
            }
        }  
        catch (SQLException e) {

            e.printStackTrace();
        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        HVlist = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMaHV = new javax.swing.JTextField();
        txtTenHV = new javax.swing.JTextField();
        txtTenTaiKhoan = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtNam = new javax.swing.JRadioButton();
        txtNu = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        Them = new javax.swing.JButton();
        CapNhat = new javax.swing.JButton();
        TimKiem = new javax.swing.JButton();
        Resest = new javax.swing.JButton();
        bHuy = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("QUẢN LÝ HỘI VIÊN");

        HVlist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hội viên", "Tên hội viên", "Tên tài khoản", "SDT", "Email", "Giới tính"
            }
        ));
        jScrollPane1.setViewportView(HVlist);

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("QUẢN LÝ HỘI VIÊN");

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel2.setText("Mã hội viên");

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel3.setText("Tên hội viên");

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel4.setText("Giới tính");

        jLabel5.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel5.setText("Tên tài khoản");

        jLabel7.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel7.setText("Số điện thoại");

        jLabel8.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel8.setText("Email");

        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
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

        jPanel1.setBackground(new java.awt.Color(189, 231, 253));

        Them.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        Them.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\THEM.png")); // NOI18N
        Them.setText("Thêm");
        Them.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Them.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Them.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemActionPerformed(evt);
            }
        });

        CapNhat.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        CapNhat.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\capnhat.png")); // NOI18N
        CapNhat.setText("Cập nhật");
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
        TimKiem.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        TimKiem.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        TimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TimKiemActionPerformed(evt);
            }
        });

        Resest.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        Resest.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\reset.png")); // NOI18N
        Resest.setText("Reset");
        Resest.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Resest.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        Resest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResestActionPerformed(evt);
            }
        });

        bHuy.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        bHuy.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\huyhoivien.png")); // NOI18N
        bHuy.setText("Hủy");
        bHuy.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        bHuy.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        bHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bHuyActionPerformed(evt);
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
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Resest, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Them, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(bHuy, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(CapNhat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CapNhat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Them, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Resest, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel4))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtNam)
                                .addGap(53, 53, 53)
                                .addComponent(txtNu))
                            .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtSDT)
                            .addComponent(txtTenHV)
                            .addComponent(txtMaHV)
                            .addComponent(txtTenTaiKhoan)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane1))
            .addGroup(layout.createSequentialGroup()
                .addGap(278, 278, 278)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtMaHV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(txtTenHV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtNam)
                                .addComponent(jLabel4))
                            .addComponent(txtNu))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        if (txtTenHV.getText().equals("")) {
            sb.append("Tên hội viên không được để trống!!!");
            txtTenHV.setBackground(Color.BLUE);
        } else {
            txtTenHV.setBackground(Color.white);
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        if (txtTenTaiKhoan.getText().equals("")) {
            sb.append("Tên tài khoản không được để trống!!!");
            txtTenTaiKhoan.setBackground(Color.BLUE);
        } else {
            txtTenTaiKhoan.setBackground(Color.white);
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb);
            return;
        }
        try {
            PreparedStatement st = conn.prepareStatement("Select * from HoiVien where TenTaiKhoan='"+txtTenTaiKhoan.getText()+"'");
            ResultSet rs = st.executeQuery();

            if(!rs.next())
            {
            if (txtSDT.getText().matches("^[0-9]{10}$") == true && txtSDT.getText().length() > 2) {    
            PreparedStatement ps = conn.prepareStatement("Insert into HoiVien(TENHV,TENTAIKHOAN,SDT,EMAIL,GIOITINH) values (?,?,?,?,?)");
         
            ps.setString(1, txtTenHV.getText());
            ps.setString(2, txtTenTaiKhoan.getText()); 
            ps.setString(3, txtSDT.getText());
            ps.setString(4, txtEmail.getText());    

            txtNam.setText("Nam");
            txtNu.setText("Nữ");
            
            if (txtNam.isSelected()) {
                ps.setString(5, txtNam.getText());
            }
            if (txtNu.isSelected()) {
                ps.setString(5, txtNu.getText());
            }
            
            // update trạng thái
             PreparedStatement ps1 = conn.prepareStatement("update TAIKHOANHV set TRANGTHAI='Actived' where TENTAIKHOAN=?");
             ps1.setString(1,txtTenTaiKhoan.getText());
             ps1.executeUpdate();
          
            int num = ps.executeUpdate();
            if (num > 0) {
                JOptionPane.showMessageDialog(this, "Hội viên được thêm vào thành công!");
                table.setRowCount(0);
                LoadHV();
            }
            }
            
            else
            {
                JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ");
            }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "Tài khoản bị trùng!");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Tài khoản không tồn tại!");
            e.printStackTrace();
        }
 
              

    }//GEN-LAST:event_ThemActionPerformed

    private void TimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TimKiemActionPerformed
        String find = txtTenHV.getText();
        try {
            table.setRowCount(0);
            TimKiemHV(find);
             if(table.getRowCount()==0)
            {
                JOptionPane.showMessageDialog(this, "Hội viên không tìm thấy!");
            }
        } catch (Exception ex) {
            Logger.getLogger(FormQLHV.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TimKiemActionPerformed

    private void ResestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResestActionPerformed
        table.setRowCount(0);
        txtMaHV.setText("");
        txtTenHV.setText("");
        txtTenTaiKhoan.setText(""); 
        txtSDT.setText("");
        txtEmail.setText("");   
        txtNam.setSelected(false);
        txtNu.setSelected(false);

        LoadHV();
    }//GEN-LAST:event_ResestActionPerformed

    private void CapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CapNhatActionPerformed
        if(txtSDT.getText().matches("^[0-9]{10}$") == true && txtSDT.getText().length() > 2)
        {
        try {
          
            PreparedStatement ps = conn.prepareStatement("update HoiVien set  TenHV = ?"
                    + ",TenTaiKhoan = ?,SDT=?, Email=?, GioiTinh=? where MaHV = ?");
            ps.setString(6, txtMaHV.getText());      
            ps.setString(1, txtTenHV.getText());       
            ps.setString(2, txtTenTaiKhoan.getText()); 
            ps.setString(3, txtSDT.getText());
            ps.setString(4, txtEmail.getText());
            txtNam.setText("Nam");
            txtNu.setText("Nữ");
            if (txtNam.isSelected()) {
                ps.setString(5, txtNam.getText());
            }
            if (txtNu.isSelected()) {
                ps.setString(5, txtNu.getText());
            }
            int num = ps.executeUpdate();
            if (num > 0) {
                JOptionPane.showMessageDialog(this, "Hội viên được cập nhật thành công!");
                table.setRowCount(0);
                LoadHV();

            }
          
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Số điện thoại không hợp lệ!");
        }
        
        
    }//GEN-LAST:event_CapNhatActionPerformed

    private void bHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bHuyActionPerformed
        try {
            PreparedStatement ps = conn.prepareStatement("update TaiKhoanHV set  TrangThai = 'De-Actived' where TenTaiKhoan = ?");
            ps.setString(1,txtTenTaiKhoan.getText());
            ps.executeUpdate();
            PreparedStatement ps1 = conn.prepareStatement("update HoiVien set TenTaiKhoan ='' where TenHV= ? ");
            ps1.setString(1, txtTenHV.getText());     
            int num = ps1.executeUpdate();
            if (num > 0) {
                JOptionPane.showMessageDialog(this, "Hội viên đã bị hủy!");
                txtMaHV.setText("");
                txtTenHV.setText("");
                txtTenTaiKhoan.setText(""); 
                txtSDT.setText("");
                txtEmail.setText("");   
                txtNam.setSelected(false);
                txtNu.setSelected(false);
                table.setRowCount(0);
                LoadHV();
            }
        } catch (Exception e) {
            
        }
    }//GEN-LAST:event_bHuyActionPerformed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

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
            java.util.logging.Logger.getLogger(FormQLHV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormQLHV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormQLHV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormQLHV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormQLHV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CapNhat;
    private javax.swing.JTable HVlist;
    private javax.swing.JButton Resest;
    private javax.swing.JButton Them;
    private javax.swing.JButton TimKiem;
    private javax.swing.JButton bHuy;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtEmail;
    public static javax.swing.JTextField txtMaHV;
    private javax.swing.JRadioButton txtNam;
    private javax.swing.JRadioButton txtNu;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenHV;
    public static javax.swing.JTextField txtTenTaiKhoan;
    // End of variables declaration//GEN-END:variables

    

}
