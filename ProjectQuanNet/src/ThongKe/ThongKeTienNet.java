/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThongKe;

import QLDV.QLDVForm;
import QLHV.FormQLHV;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class ThongKeTienNet extends javax.swing.JFrame {

    private java.sql.Connection conn = null;
    DefaultTableModel table = new DefaultTableModel();
    DefaultTableModel table1 = new DefaultTableModel();
    private Timer t;
    
    public ThongKeTienNet() {
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
            Logger.getLogger(QLDVForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {

            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "DANGDO_CONNECT", "USERPASS");

        } catch (SQLException ex) {
           ex.printStackTrace();
        }

    }       
    public void WritePDF()
    {   
        try {
            
        String file_name = "C:\\Java\\ProjectQuanNet\\ThongKeTienNet '"+txtDate.getText()+"'.pdf";
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(file_name));
        
        doc.open();
        Paragraph para = new Paragraph("THONG KE TIEN NET KHONG HOI VIEN");
        Paragraph para1 = new Paragraph("                         ");
        
        //add table 
        PdfPTable table = new PdfPTable(6);
        
        PdfPCell c1 = new PdfPCell(new Phrase("MAGD"));
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("NGAYGD"));
        table.addCell(c1);
        c1= new PdfPCell(new Phrase("BATDAU"));
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("KETTHUC"));
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("TIEN"));
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("TENMAY"));
        table.addCell(c1);
        table.setHeaderRows(1);
        doc.add(para);
        doc.add(para1);
        PreparedStatement st = conn.prepareStatement("Select * from NHATKIGD where NGAYGD='"+txtDate.getText()+"' ORDER BY MAGD ASC");
        ResultSet rs = st.executeQuery();
        
        while(rs.next())
                {
                    table.addCell(rs.getString("MaGD"));
                    table.addCell(rs.getString("NgayGD"));
                    table.addCell(rs.getString("ThoiGianBatDau"));
                    table.addCell(rs.getString("ThoiGianKetThuc"));
                    table.addCell(rs.getString("TinhTien"));
                    table.addCell(rs.getString("TenMay"));
                   
                }
          
        doc.add(table);
        
        Paragraph para4 = new Paragraph("                         ");
        Paragraph para2 = new Paragraph("THONG KE TIEN THEM HOI VIEN");
        Paragraph para3 = new Paragraph("                         ");
        doc.add(para4);
        doc.add(para2);
        doc.add(para3);
        
        PdfPTable table1 = new PdfPTable(4);
        
        PdfPCell c2 = new PdfPCell(new Phrase("MaGD"));
        table1.addCell(c2);
        c2 = new PdfPCell(new Phrase("TenTaiKhoan"));
        table1.addCell(c2);
        c2 = new PdfPCell(new Phrase("TienThem"));
        table1.addCell(c2);
        c2 = new PdfPCell(new Phrase("NgayGD"));
        table1.addCell(c2);
        table1.setHeaderRows(1);
        PreparedStatement st1 = conn.prepareStatement("Select * from NHATKIGDTHEMTIEN where NGAYGD='"+txtDate.getText()+"' ORDER BY MAGD ASC");
        ResultSet rs1 = st1.executeQuery();
        
        while(rs1.next())
                {
                    table1.addCell(rs1.getString("MaGD"));                  
                    table1.addCell(rs1.getString("TENTAIKHOAN"));
                    table1.addCell(rs1.getString("TIENTHEM"));
                    table1.addCell(rs1.getString("NgayGD"));
                }
        
         doc.add(table1);
        Paragraph para7 = new Paragraph("                         ");
        Paragraph para8 = new Paragraph("TONG TIEN NGAY "+txtDate.getText()+": "+txtTongTien.getText()+" VND");
        Paragraph para9 = new Paragraph("                         ");
        doc.add(para7);
        doc.add(para8);
        doc.add(para9);
        
        doc.close();
        
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
     public void LoadTienThem()
    {
        table = (DefaultTableModel) TKNlist.getModel();
        
        try {
            PreparedStatement st = conn.prepareStatement("Select * from NHATKIGD where NGAYGD='"+txtDate.getText()+"'");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object a[] = {rs.getString("MAGD"), rs.getString("NGAYGD"),rs.getString("TENMAY"), rs.getString("THOIGIANBATDAU"),rs.getString("THOIGIANKETTHUC"), rs.getString("TINHTIEN")};
                table.addRow(a);
            }
    }   catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void LoadTraTruoc()
    {
        table1 = (DefaultTableModel) ThongKeHV.getModel();
        try {
            PreparedStatement st = conn.prepareStatement("Select * from NHATKIGDTHEMTIEN where NGAYGD='"+txtDate.getText()+"'");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Object a[] = {rs.getString("MAGD"), rs.getString("TENTAIKHOAN"),rs.getString("TIENTHEM"), rs.getString("NGAYGD")};
                table1.addRow(a);
            }
    }   catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void TongTienNet()
    {   
        table = (DefaultTableModel) TKNlist.getModel();
        int rowcount = table.getRowCount();
        for (int i = rowcount - 1; i >= 0; i--) {
            table.removeRow(i);
        }
         table1 = (DefaultTableModel) ThongKeHV.getModel();
        int rowcount1 = table1.getRowCount();
        for (int i = rowcount1 - 1; i >= 0; i--) {
            table1.removeRow(i);
        }
        LoadTienThem();
        LoadTraTruoc();
        float Tong=0;
        for(int i=0;i<table.getRowCount();i++)
        {
            Tong+=Float.parseFloat(table.getValueAt(i, 5).toString());
        }
        int Tong1=0;
        for(int i=0;i<table1.getRowCount();i++)
        {
            Tong+=Float.parseFloat(table1.getValueAt(i, 2).toString());
        }
        float TongTien=Tong+Tong1;
        txtTongTien.setText(String.valueOf(TongTien));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TKNlist = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        Load = new javax.swing.JButton();
        bExit = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        ThongKeHV = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TKNlist.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Giao Dịch", "Ngày ", "Máy Trạm", "Thời Gian Bắt Đầu", "Thời Gian Kết Thúc", "Thành Tiền"
            }
        ));
        jScrollPane1.setViewportView(TKNlist);

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("THỐNG KÊ TIỀN NET");

        Load.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        Load.setText("LOAD");
        Load.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LoadActionPerformed(evt);
            }
        });

        bExit.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        bExit.setText("BACK");
        bExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExitActionPerformed(evt);
            }
        });

        ThongKeHV.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Giao Dịch", "Tên Tài Khoản", "Tiền Thêm", "Ngày Giao Dịch"
            }
        ));
        jScrollPane2.setViewportView(ThongKeHV);

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 255));
        jLabel2.setText("TỔNG THU");

        txtTongTien.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtTongTien.setText("0000");
        txtTongTien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        txtDate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\ngay.png")); // NOI18N
        jLabel3.setText("Ngày");

        jButton1.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jButton1.setText("XUẤT FILE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2)
                .addGap(33, 33, 33)
                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(Load, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bExit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(278, 278, 278))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 408, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Load, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(bExit, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LoadActionPerformed
        
        TongTienNet();
        
    }//GEN-LAST:event_LoadActionPerformed

    private void bExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExitActionPerformed
        dispose();
        ThongKe tk = new ThongKe();
        tk.setVisible(true);
    }//GEN-LAST:event_bExitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            WritePDF();
            JOptionPane.showMessageDialog(this, "Xuất file thành công!");
            Desktop.getDesktop().open(new File("C://Java//ProjectQuanNet//ThongKeTienNet '"+txtDate.getText()+"'.pdf"));
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            java.util.logging.Logger.getLogger(ThongKeTienNet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeTienNet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeTienNet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeTienNet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKeTienNet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Load;
    private javax.swing.JTable TKNlist;
    private javax.swing.JTable ThongKeHV;
    private javax.swing.JButton bExit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField txtDate;
    private javax.swing.JLabel txtTongTien;
    // End of variables declaration//GEN-END:variables
}
