 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ThongKe;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Dang Do
 */
public class ThongKeDV extends javax.swing.JFrame {

     private java.sql.Connection conn = null;
    DefaultTableModel table = new DefaultTableModel();
    private Timer t;
    public ThongKeDV() {
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
            ex.printStackTrace();
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
            
        String file_name = "C:\\Java\\ProjectQuanNet\\ThongKeTienDV '"+txtDate.getText()+"'.pdf";
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream(file_name));
        
        doc.open();
        Paragraph para = new Paragraph("THONG KE TIEN NET DICH VU");
        Paragraph para1 = new Paragraph("                         ");
        
        //add table 
        PdfPTable table = new PdfPTable(6);
        
        PdfPCell c1 = new PdfPCell(new Phrase("MADH"));
        table.addCell(c1);
        c1= new PdfPCell(new Phrase("MADV"));
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("SOLUONG"));
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("TIEN"));
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("NGAYDH"));
        table.addCell(c1);
        c1 = new PdfPCell(new Phrase("TENMAY"));
        table.addCell(c1);
        table.setHeaderRows(1);
        doc.add(para);
        doc.add(para1);
        PreparedStatement st = conn.prepareStatement("Select * from ORDERDV where NGAYDH='"+txtDate.getText()+"' ORDER BY MADH ASC");
        ResultSet rs = st.executeQuery();
        
        while(rs.next())
                {
                    table.addCell(rs.getString("MADH"));
                    table.addCell(rs.getString("MADV"));
                    table.addCell(rs.getString("SOLUONG"));
                    table.addCell(rs.getString("THANHTIEN"));
                    table.addCell(rs.getString("NGAYDH"));
                    table.addCell(rs.getString("TENMAY"));
                   
                }
          
        doc.add(table);
        Paragraph para7 = new Paragraph("                         ");
        Paragraph para8 = new Paragraph("TONG TIEN NGAY "+txtDate.getText()+": "+txtTongTien.getText()+" VND");
        Paragraph para9 = new Paragraph("                         ");
        doc.add(para7);
        doc.add(para8);
        doc.add(para9);
        doc.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }   
    public void LoadOrder()
    {          
        table = (DefaultTableModel) listOrder.getModel();
        try {
            PreparedStatement ps = conn.prepareStatement("Select * From ORDERDV WHERE NGAYDH='"+txtDate.getText()+"'");
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
    public void TinhTongTien()
    {
        table = (DefaultTableModel) listOrder.getModel();
        int rowcount = table.getRowCount();
        for (int i = rowcount - 1; i >= 0; i--) {
            table.removeRow(i);
        }
        int Tong=0;
        LoadOrder();
        for(int i=0;i<table.getRowCount();i++)
        {
            Tong+=Integer.parseInt(table.getValueAt(i, 4).toString());
        }
         txtTongTien.setText(String.valueOf(Tong));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listOrder = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        bLoad = new javax.swing.JButton();
        bExit = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtDate = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Cambria", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 255));
        jLabel1.setText("THỐNG KÊ DỊCH VỤ");

        listOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã đơn dịch vụ", "Ngày đặt ", "Tên dịch vụ", "Số lượng", "Thành tiền", "Tên máy"
            }
        ));
        jScrollPane1.setViewportView(listOrder);

        jLabel2.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 204));
        jLabel2.setText("TỐNG THU");

        txtTongTien.setFont(new java.awt.Font("Cambria", 0, 14)); // NOI18N
        txtTongTien.setText("0000");
        txtTongTien.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel4.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 204));
        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Java\\ProjectQuanNet\\Images_Pro\\ngay.png")); // NOI18N
        jLabel4.setText("NGÀY");

        bLoad.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        bLoad.setText("LOAD");
        bLoad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLoadActionPerformed(evt);
            }
        });

        bExit.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        bExit.setText("BACK");
        bExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bExitActionPerformed(evt);
            }
        });

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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel2)
                        .addGap(43, 43, 43)
                        .addComponent(txtTongTien)
                        .addGap(58, 58, 58)
                        .addComponent(bLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(bExit, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtDate, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(txtTongTien)
                        .addComponent(bLoad, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(bExit, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bLoadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLoadActionPerformed
        TinhTongTien();
    }//GEN-LAST:event_bLoadActionPerformed

    private void bExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bExitActionPerformed
        dispose();
        ThongKe tk = new ThongKe();
        tk.setVisible(true);
    }//GEN-LAST:event_bExitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try
        {
            WritePDF();
            JOptionPane.showMessageDialog(this, "Xuất file thành công!");
            Desktop.getDesktop().open(new File("C://Java//ProjectQuanNet//ThongKeTienDV '"+txtDate.getText()+"'.pdf"));
        }catch(Exception e)
        {
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
            java.util.logging.Logger.getLogger(ThongKeDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThongKeDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThongKeDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThongKeDV.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThongKeDV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bExit;
    private javax.swing.JButton bLoad;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listOrder;
    private javax.swing.JTextField txtDate;
    private javax.swing.JLabel txtTongTien;
    // End of variables declaration//GEN-END:variables
}
