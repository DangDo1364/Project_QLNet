/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package QLMT;



import Client.GiaoDienHoiVien1;
import Sever.ManagerGUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Dang Do
 */
public class FormQLMT extends javax.swing.JFrame {

    private Timer t;
    private java.sql.Connection conn = null;
    DefaultTableModel table = new DefaultTableModel();
    DefaultTableModel table1 = new DefaultTableModel();
    GiaoDienHoiVien1 hv1 ;
   
    String dsecond, dminute,dhour;
    public FormQLMT() {
        initComponents();
        Connect();
        runTime();
        LoadMT();
        LoadGD();
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
             SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
             SimpleDateFormat dFormat = new SimpleDateFormat("dd-MM-yyyy");
            LabelTime.setText(sdf.format(new java.util.Date()));
            LabelDate.setText(dFormat.format(new java.util.Date()));    
          }
      });
        
       t.start();
    }    
    public void MoSau (float TinhTien)
    {   
        DecimalFormat f = new DecimalFormat("00");
        DecimalFormat f1 = new DecimalFormat("0.0");
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        hv1.txtTimeBD.setText(sdf.format(date));
         
          t = new Timer(1000, new ActionListener() {
            int h=0;
            int m=0;
            int s=0;
            float Tien=0;
            String Tien1=null;
          @Override
          public void actionPerformed(ActionEvent e) {
            
            s++;     
            Tien= Tien+TinhTien ;
            dsecond = f.format(s);
            dminute = f.format(m);
            dhour = f.format(h);
            Tien1 = f1.format(Tien);
            hv1.txtTimeSD.setText(dhour+":"+dminute+":"+dsecond);
            hv1.txtTienTK.setText(Tien1);
            if(s==60)
            {
                s=0;
                m++;
                hv1.txtTimeSD.setText(dhour+":"+dminute+":"+dsecond);
            }
            else if(m==60)
            {
                m=0;
                h++;
                hv1.txtTimeSD.setText(dhour+":"+dminute+":"+dsecond);
            }
                       
          }

         
      });
       t.start();   
    }   
    public void Tat(String TenMay, float Tien,float GiaDichVu)
    {   
          
        DecimalFormat f = new DecimalFormat("00");
        DecimalFormat f1 = new DecimalFormat("0.0");
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        hv1.txtTimeBD.setText(sdf.format(date));
         
          t = new Timer(1000, new ActionListener() {
            int h=0;
            int m=0;
            int s=0;
            float TienTru = Tien;
            String TienTru1=null;
          @Override
          public void actionPerformed(ActionEvent e) {
            
            s++;     
            TienTru=TienTru-GiaDichVu ;
            dsecond = f.format(s);
            dminute = f.format(m);
            dhour = f.format(h);
            TienTru1 = f1.format(TienTru);
            hv1.txtTimeSD.setText(dhour+":"+dminute+":"+dsecond);
            hv1.txtTienTK.setText(TienTru1);
            if(s==60)
            {
                s=0;
                m++;
                hv1.txtTimeSD.setText(dhour+":"+dminute+":"+dsecond);
            }
            else if(m==60)
            {
                m=0;
                h++;
                hv1.txtTimeSD.setText(dhour+":"+dminute+":"+dsecond);
            }
            if(TienTru<0)
            {
                hv1.dispose();
                try {
                    PreparedStatement ps1 = conn.prepareStatement("update MAYTRAM SET  TRANGTHAIMAY = 'Locked' WHERE TENMAY='"+TenMay+"' ");
                    ps1.executeUpdate();

                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                table1.setRowCount(0);
                LoadMT();
                t.stop();
            }
                       
          }

         
      });
          t.start();
    }   
    public void LoadMT()
    {
        table1 = (DefaultTableModel) tableMT.getModel();
        try {
            PreparedStatement st = conn.prepareStatement("Select TenMay,TenNhom,TrangThaiMay from MayTram Order by TenMay ASC");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object a[] = {rs.getString("TenMay"), rs.getString("TenNhom"),rs.getString("TrangThaiMay")};
                table1.addRow(a);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private void LoadGD() {
         table = (DefaultTableModel) tableGD.getModel();
        try {
            PreparedStatement st = conn.prepareStatement("Select * from NHATKIGD Order by MaGD ASC");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object a[] = {rs.getString("MAGD"), rs.getString("TENMAY"),rs.getString("NGAYGD"), rs.getString("THOIGIANBATDAU"),rs.getString("THOIGIANKETTHUC"), rs.getString("TINHTIEN")};
                table.addRow(a);
            }
    }   catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void TinhTien(String MaGD,String TenMay)
    {
            String timestart = null;
            String timestop =  null;    
            try {
            
            
            PreparedStatement ps = conn.prepareStatement("Select THOIGIANBATDAU,THOIGIANKETTHUC From NHATKIGD WHERE MaGD='"+MaGD+"'" );
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                timestart = rs.getString("THOIGIANBATDAU");
                timestop = rs.getString("THOIGIANKETTHUC");
            }
            }catch(Exception e)
            {
            e.printStackTrace();

            }
        
             
             float giostart  = Float.parseFloat(timestart.substring(0, 2));
             float giostop  = Float.parseFloat(timestop.substring(0, 2));
             
              float pstart  = Float.parseFloat(timestart.substring(3, 5));
             float piostop  = Float.parseFloat(timestop.substring(3, 5));
             
              float sstart  = Float.parseFloat(timestart.substring(6, 8));
             float siostop  = Float.parseFloat(timestop.substring(6, 8));
             
            // lấy giá dịch vụ loại máy
            
             
            float GiaDichVu;
            
            try {
             PreparedStatement ps2 = conn.prepareStatement("Select TRANGTHAIMAY,TENNHOM FROM MAYTRAM WHERE TENMAY='"+TenMay+"'");
            ResultSet rs = ps2.executeQuery();
            rs.next();
            PreparedStatement ps3 = conn.prepareStatement("Select GIADICHVU FROM NHOMND_NHOMMT WHERE TENNHOMND='Guest' AND TENNHOMMT='"+rs.getString("TENNHOM")+"'");
            ResultSet rs1 = ps3.executeQuery();
            rs1.next();
            GiaDichVu = rs1.getFloat("GIADICHVU");
        
 
            // tính tiền
           
            
              float totalstart = giostart*3600 + pstart*60 + sstart ;
             float totalstop = giostop*3600 + piostop*60 + siostop ;
             
   
             float tinhtien = (totalstop - totalstart) * GiaDichVu ;
               if((totalstop - totalstart) < 1000)
             {     
                PreparedStatement st = conn.prepareStatement("Select TenNhom from MayTram where TenMay='"+TenMay+"'");
                ResultSet rst = st.executeQuery();
                rst.next();
                float  Tinhtienmay =  0 ;
                 if(rs.getString("TenNhom").equals("VIP"))
                    {
                        Tinhtienmay =  3000 ;
                     }
                 else if(rs.getString("TenNhom").equals("Basic")){
                        Tinhtienmay =  2000 ;
                    }
                 
                JOptionPane.showMessageDialog(null,"Thành tiền: "+Tinhtienmay+"VND");
   
                       
                String sql = "UPDATE NHATKIGD SET TINHTIEN='"+Tinhtienmay+"' WHERE MAGD = '"+MaGD+"' ";
                PreparedStatement ps;
                 try {
                     ps = conn.prepareStatement(sql);
                     ps.executeUpdate();
                     table.setRowCount(0);
                     LoadGD();
                 } catch (SQLException ex) {
                     ex.printStackTrace();
                 }
             }      
             else{
                  float  Tinhtienmay =  tinhtien ;
                 JOptionPane.showMessageDialog(null,"Thành tiền: "+Tinhtienmay+"VND");
       
                String sql = "UPDATE NHATKIGD SET TINHTIEN='"+Tinhtienmay+"' WHERE MAGD = '"+MaGD+"' ";
                PreparedStatement ps;
                 try {
                     ps = conn.prepareStatement(sql);
                     ps.executeUpdate();
                     table.setRowCount(0);
                     LoadGD();
                 } catch (SQLException ex) {
                     ex.printStackTrace();
                 }
             }
               } catch (Exception e) {
        }
             
           
               
                 
             
             
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableMT = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableGD = new javax.swing.JTable();
        ThemMay = new javax.swing.JButton();
        CapNhat = new javax.swing.JButton();
        MoMayTruoc = new javax.swing.JButton();
        MoMaySau = new javax.swing.JButton();
        DongMay = new javax.swing.JButton();
        TinNhan = new javax.swing.JButton();
        txtTenMay = new javax.swing.JTextField();
        LabelTime = new javax.swing.JTextField();
        LabelDate = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 204, 255));
        jLabel1.setText("QUẢN LÝ MÁY TRẠM");

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tableMT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Tên máy", "Tên nhóm", "Trạng thái máy"
            }
        ));
        tableMT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableMT);

        tableGD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã giao dịch", "Tên máy", "Ngày giao dịch", "Ngày bắt đầu", "Ngày kết thúc", "Tính tiền"
            }
        ));
        jScrollPane2.setViewportView(tableGD);

        ThemMay.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\themmaytram.png")); // NOI18N
        ThemMay.setText("THÊM MÁY");
        ThemMay.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ThemMay.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        ThemMay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemMayActionPerformed(evt);
            }
        });

        CapNhat.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\capnhatmaytram.png")); // NOI18N
        CapNhat.setText("CẬP NHẬT MÁY");
        CapNhat.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        CapNhat.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        CapNhat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CapNhatActionPerformed(evt);
            }
        });

        MoMayTruoc.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\momaytram.png")); // NOI18N
        MoMayTruoc.setText("MỞ MÁY TRƯỚC");
        MoMayTruoc.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MoMayTruoc.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        MoMayTruoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoMayTruocActionPerformed(evt);
            }
        });

        MoMaySau.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\momaytram.png")); // NOI18N
        MoMaySau.setText("MỞ MÁY SAU");
        MoMaySau.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        MoMaySau.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        MoMaySau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoMaySauActionPerformed(evt);
            }
        });

        DongMay.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\khoamaytram.png")); // NOI18N
        DongMay.setText("ĐÓNG MÁY");
        DongMay.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        DongMay.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        DongMay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DongMayActionPerformed(evt);
            }
        });

        TinNhan.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\guitinnhan.png")); // NOI18N
        TinNhan.setText("TIN NHẮN");
        TinNhan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        TinNhan.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        TinNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TinNhanActionPerformed(evt);
            }
        });

        jLabel2.setText("TÊN MÁY");

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\dongho.png")); // NOI18N

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\ngay.png")); // NOI18N

        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 509, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ThemMay, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CapNhat, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(MoMayTruoc, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MoMaySau, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(72, 72, 72)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TinNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DongMay, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(LabelDate)
                            .addComponent(txtTenMay)
                            .addComponent(LabelTime, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ThemMay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(MoMaySau, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(DongMay, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(CapNhat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(MoMayTruoc, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TinNhan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenMay, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(LabelTime, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(LabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        
    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void tableMTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMTMouseClicked
        if(tableMT.getValueAt(tableMT.getSelectedRow(), 2).equals("Broken"))
        {
             JOptionPane.showMessageDialog(null, "Máy đã bị lỗi");
        }
        else
        {
            if (tableMT.getSelectedRow() >= 0) {
            txtTenMay.setText(tableMT.getValueAt(tableMT.getSelectedRow(), 0) + "");
        }
        }
        
    }//GEN-LAST:event_tableMTMouseClicked

    private void ThemMayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemMayActionPerformed
        FormMTThem f1 = new FormMTThem();
        f1.setVisible(true);
        dispose();
    }//GEN-LAST:event_ThemMayActionPerformed

    private void CapNhatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CapNhatActionPerformed
       
        
        try {
            
            if(txtTenMay.getText().equals(""))
            {
                JOptionPane.showMessageDialog(null, "Vui lòng chọn máy");
            }
            else{
            FormMT f1 = new FormMT();
            f1.setVisible(true);
            PreparedStatement st = conn.prepareStatement("Select * from MayTram where TenMay='"+txtTenMay.getText()+"'");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
               f1.txtTenMay.setText(rs.getString("TenMay"));
               f1.txtNhomMay.setText(rs.getString("TenNhom"));         
               f1.txtTT.setText(rs.getString("TrangThaiMay"));        
               f1.txtGhiChu.setText(rs.getString("GhiChu"));
               dispose();
               FormQLMT form = new FormQLMT();
               form.setVisible(true);
            }

            }
        } catch (Exception e) {
            
        }
        
    }//GEN-LAST:event_CapNhatActionPerformed

    private void MoMaySauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoMaySauActionPerformed
        
        try{
            String TenMay=txtTenMay.getText();
            PreparedStatement ps2 = conn.prepareStatement("Select TRANGTHAIMAY,TENNHOM FROM MAYTRAM WHERE TENMAY='"+TenMay+"'");
            ResultSet rs = ps2.executeQuery();
            rs.next();
            PreparedStatement ps3 = conn.prepareStatement("Select GIADICHVU FROM NHOMND_NHOMMT WHERE TENNHOMND='Guest' AND TENNHOMMT='"+rs.getString("TENNHOM")+"'");
            ResultSet rs1 = ps3.executeQuery();
            rs1.next();
            if(rs.getString("TrangThaiMay").equals("Connected"))
            {
                JOptionPane.showMessageDialog(null, "Máy đã mở");
            }
            else if(rs.getString("TrangThaiMay").equals("Locked"))           
            {
            String sql = "INSERT INTO NHATKIGD (NGAYGD,THOIGIANBATDAU,TENMAY) VALUES ('"+LabelDate.getText()+"','"+LabelTime.getText()+"','"+TenMay+"')";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            PreparedStatement ps1 = conn.prepareStatement("update MAYTRAM set  TRANGTHAIMAY = 'Connected' where TENMAY='"+TenMay+"' ");
            ps1.executeUpdate();
            JOptionPane.showMessageDialog(null, "Đã mở máy");
            table.setRowCount(0);
            LoadGD();
            hv1 = new GiaoDienHoiVien1();
            hv1.txtTenMay.setText(TenMay);
            MoSau(rs1.getFloat("GIADICHVU"));
            hv1.setVisible(true);
            }
           
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn máy");
        }
    }//GEN-LAST:event_MoMaySauActionPerformed

    private void DongMayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DongMayActionPerformed
        
        
         try{
            int row=tableGD.getSelectedRow();
            String MaGD =tableGD.getModel().getValueAt(row, 0).toString();
            String TenMay =tableGD.getModel().getValueAt(row, 1).toString();
         
            PreparedStatement ps2 = conn.prepareStatement("Select TRANGTHAIMAY FROM MAYTRAM WHERE TENMAY='"+TenMay+"'");
            ResultSet rs = ps2.executeQuery();
            rs.next();
            if(rs.getString("TrangThaiMay").equals("Locked"))
            {
                JOptionPane.showMessageDialog(null, "Máy đã đóng");
            }
            else if(rs.getString("TrangThaiMay").equals("Connected"))           
            { 
            PreparedStatement ps1 = conn.prepareStatement("update MAYTRAM SET  TRANGTHAIMAY = 'Locked' WHERE TENMAY='"+TenMay+"' ");
            ps1.executeUpdate();
            String sql = "UPDATE NHATKIGD SET THOIGIANKETTHUC = '"+LabelTime.getText()+"' WHERE MAGD = '"+MaGD+"' ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Đã đóng máy");
            table.setRowCount(0);
            LoadGD();
            TinhTien(MaGD,TenMay);
            t.stop();
            hv1.dispose();
            table1.setRowCount(0);
            LoadMT();
            }
           
        }catch(Exception e)
        {
           JOptionPane.showMessageDialog(null, "Vui lòng chọn máy đóng");
        }
    }//GEN-LAST:event_DongMayActionPerformed

    private void MoMayTruocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoMayTruocActionPerformed
        
            try {
            ThemTien tt = new ThemTien(this,rootPaneCheckingEnabled);
            tt.setVisible(true);
            float TienTraTruoc = Float.parseFloat(tt.txtTien.getText());
            String TenMay=txtTenMay.getText();
            
            float GiaDichVu;
            PreparedStatement ps2 = conn.prepareStatement("Select TRANGTHAIMAY,TENNHOM FROM MAYTRAM WHERE TENMAY='"+TenMay+"'");
            ResultSet rs2 = ps2.executeQuery();
            rs2.next();
            PreparedStatement ps3 = conn.prepareStatement("Select GIADICHVU FROM NHOMND_NHOMMT WHERE TENNHOMND='Guest' AND TENNHOMMT='"+rs2.getString("TENNHOM")+"'");
            ResultSet rs3 = ps3.executeQuery();
            rs3.next();
            GiaDichVu = rs3.getFloat("GIADICHVU");
        
            int time = (int) (TienTraTruoc / GiaDichVu);
            int h = time / 3600;
            int m = (time - (h*3600)) / 60 ;
            int s = (time -(h*3600)-(m*60));
        
            String timestart = LabelTime.getText();
            
             float giostart  = Float.parseFloat(timestart.substring(0, 2));
             
             float pstart  = Float.parseFloat(timestart.substring(3, 5));

             float sstart  = Float.parseFloat(timestart.substring(6, 8));
            
             int giostop = (int) (giostart + h);
             int pstop = (int) (pstart + m);
            int sstop = (int) (sstart + s);
            if(sstop >=60)
            {
                pstop = (int)(pstop + sstop/60);
                sstop =  sstop%60;
            }
             if(pstop>=60)
             {
                 giostop = (int)(giostop + pstop/60);      
                 pstop = pstop%60;
             }        
             if(giostop>=24)
             {
                 giostop=giostop % 24;
             }
            DecimalFormat f = new DecimalFormat("00");
            String gio = f.format(giostop);
            String phut = f.format(pstop);
            String giay = f.format(sstop);
            /*String phut = String.valueOf(pstop);
            String giay = String.valueOf(sstop);*/
            
            
            
            
            String timestop = gio+":"+phut+":"+giay ;
            PreparedStatement ps1 = conn.prepareStatement("Select TRANGTHAIMAY FROM MAYTRAM WHERE TENMAY='"+TenMay+"'");
            ResultSet rs1 = ps1.executeQuery();
            rs1.next();
            if(rs1.getString("TrangThaiMay").equals("Connected"))
            {
                JOptionPane.showMessageDialog(null, "Máy đã mở");
            }
            else if(rs1.getString("TrangThaiMay").equals("Locked"))           
            {
            String sql = "INSERT INTO NHATKIGD (NGAYGD,THOIGIANBATDAU,THOIGIANKETTHUC,TENMAY,TINHTIEN) VALUES ('"+LabelDate.getText()+"','"+LabelTime.getText()+"','"+timestop+"','"+TenMay+"','"+TienTraTruoc+"')";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            PreparedStatement ps4 = conn.prepareStatement("update MAYTRAM set  TRANGTHAIMAY = 'Connected' where TENMAY='"+TenMay+"' ");
            ps4.executeUpdate();
            JOptionPane.showMessageDialog(null, "Đã mở máy");
                      
            table.setRowCount(0);
            LoadGD();
            hv1 = new GiaoDienHoiVien1();
            hv1.txtTenMay.setText(TenMay);
            Tat(TenMay,Float.parseFloat(tt.txtTien.getText()),GiaDichVu);
            hv1.setVisible(true);
            table1.setRowCount(0);
            LoadMT();
            }
            
         
         } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Vui lòng chọn máy");
        }   
        
    }//GEN-LAST:event_MoMayTruocActionPerformed

    private void TinNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TinNhanActionPerformed
        ManagerGUI chat = new ManagerGUI();
        chat.textField.setText("20");
        chat.setVisible(true);
       
    }//GEN-LAST:event_TinNhanActionPerformed

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
            java.util.logging.Logger.getLogger(FormQLMT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormQLMT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormQLMT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormQLMT.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormQLMT().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CapNhat;
    private javax.swing.JButton DongMay;
    private javax.swing.JTextField LabelDate;
    private javax.swing.JTextField LabelTime;
    private javax.swing.JButton MoMaySau;
    private javax.swing.JButton MoMayTruoc;
    private javax.swing.JButton ThemMay;
    private javax.swing.JButton TinNhan;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tableGD;
    private javax.swing.JTable tableMT;
    private javax.swing.JTextField txtTenMay;
    // End of variables declaration//GEN-END:variables
}
