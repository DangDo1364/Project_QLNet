/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Client;

import static Client.GiaoDienHoiVien.txtTenTK;
import static Client.GiaoDienHoiVien.txtTimeBD;
import static Client.GiaoDienHoiVien.txtTimeSD;
import QLNV.FormQLNV;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.Border;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Dang Do
 */
public class LoginForm extends JFrame{
    private java.sql.Connection conn = null;
    public static JTextField tk;
    ResultSet rs;
    public static Timer t;
     String dsecond, dminute,dhour;
     int s=0;
     int m=0;
     int h=0;
    GiaoDienHoiVien gd = new GiaoDienHoiVien();  
    public LoginForm() 
    {
        connect();
        login1();
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
     
    public void Tat()
    {
        float Tien = Float.parseFloat(gd.txtTienTK.getText());
        
        int time = (int) (Tien / 1.5);
        int hour = time / 3600;
        int minute = (time - (h*3600)) / 60 ;
        int second = (time -(h*3600)-(m*60));
        
        DecimalFormat f = new DecimalFormat("00");
        java.util.Date date = new java.util.Date();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        gd.txtTimeBD.setText(sdf.format(date));
         
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
            if(s==second && m==minute)
            {
                gd.dispose();    
                try {
                    PreparedStatement ps1 = conn.prepareStatement("update TAIKHOANHV set TIENCONLAI=0 where TENTAIKHOAN='"+gd.txtTenTK.getText()+"'");
                    ps1.executeUpdate();
                } catch (SQLException ex) {
                    Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                LoginForm f1=new LoginForm();
                f1.setVisible(true);
                

                         
            }
              
          }

         
      });
       t.start();   
    }
    private void login1()
    {   
        //font 
        Font f= new Font("Cambria",Font.BOLD,50);
        Font t= new Font("Cambria",Font.BOLD,20);
        Font r= new Font("Cambria",Font.BOLD,25);
        Font l= new Font("Cambria",Font.BOLD,13);
        
        //header
        
        JPanel heading = new JPanel();
        heading.setBackground(new Color(0,0,0,0));
        heading.setBounds(0,0,1350,80);
        JLabel name= new JLabel("TIỆM NET DVD");
        name.setBounds(0,0,1600,100);
        name.setForeground(Color.WHITE);
        name.setFont(f);
        heading.add(name);
        
        //login 
        
        JPanel login = new JPanel();
        login.setLayout(null);
        login.setBackground(new Color(0,0,0,60));  
        login.setBounds(500,250,350,300);
        Border blackline = BorderFactory.createLineBorder(Color.WHITE);
        login.setBorder(blackline);
        
        
        JPanel heading1 = new JPanel();
        heading1.setBackground(Color.WHITE);
        heading1.setBounds(0,0,350,50);
        JLabel name1= new JLabel("DVD Client");
        name1.setBounds(0,0,350,50);
        name1.setForeground(Color.BLACK);
        name1.setFont(r);
        heading1.add(name1);
       
        JLabel username = new JLabel("Tài Khoản");
        username.setBounds(30, 80, 200, 50);
        username.setForeground(Color.WHITE);
        username.setFont(t);
        
        JLabel password = new JLabel("Mật Khẩu");
        password.setForeground(Color.WHITE);
        password.setFont(t);
        password.setBounds(30, 150, 200, 50);
        
        tk= new JTextField(15);
        tk.setBounds(130,90,200,30);
        
        JPasswordField mk = new JPasswordField(15);
        mk.setBounds(130,160,200,30);
        
        JButton dangnhap = new JButton("Đăng Nhập");
        dangnhap.setBounds(50, 230, 100,50);
        dangnhap.setFont(l);
        JButton thoat = new JButton("Reset");
        thoat.setBounds(200, 230, 100,50);
        thoat.setFont(l);
        
        thoat.addActionListener((ActionEvent e) -> {
            tk.setText("");
            mk.setText("");
        });
        
        login.add(heading1);
        login.add(tk);
        login.add(mk);
        login.add(username);
        login.add(password);
        login.add(dangnhap);
        login.add(thoat);
        
        
        // frame
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setVisible(true);
        //background
        ImageIcon bg = new ImageIcon("C:\\Java\\ProjectQuanNet\\src\\IMAGE\\anhlolxanh.jpg");
        JLabel background = new JLabel("",bg,JLabel.CENTER);
        Image img=bg.getImage();
        Image temp_image =img.getScaledInstance(1600, 900, Image.SCALE_SMOOTH);
        bg = new ImageIcon(temp_image);
        background.setBounds(0, 0, 1600, 900);
        this.add(background);
        background.add(heading);
        background.add(login);
        //bat su kien
        dangnhap.addActionListener(new ActionListener() {
         @Override
        public void actionPerformed(ActionEvent event) {
                
            
             try {
                 PreparedStatement st = conn.prepareStatement("Select * from TAIKHOANHV WHERE TENTAIKHOAN=? AND MATKHAU=?");
                 st.setString(1,tk.getText());
                 st.setString(2,mk.getText());
                 ResultSet rs = st.executeQuery();
                 
              if(rs.next())
              {  
                   PreparedStatement ps = conn.prepareStatement("Select TIENCONLAI From TAIKHOANHV WHERE "
                           + "TENTAIKHOAN='"+tk.getText()+"'" );
                  rs = ps.executeQuery();
                     while (rs.next()) {
                         if(rs.getString("TIENCONLAI").equals("0"))
                         {
                             JOptionPane.showMessageDialog(null, "Tài khoản đã hết tiền");
                               tk.setText("");
                                mk.setText("");
                         }
                         else
                         {      
                             JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
                              dispose();
                                gd.txtTenTK.setText(tk.getText());
                              gd.txtTienTK.setText(rs.getString("TIENCONLAI"));
                             
                              Tat();
                              gd.txtTenMay.setText("MÁY 01");
                              gd.setVisible(true);
                              
                                
                         }
                    
                    }                           
                               
              }
              else
              {
                  JOptionPane.showMessageDialog(null, "Sai tên tài khoản hoặc mật khẩu");
                  tk.setText("");
                  mk.setText("");

              }   
             } catch (SQLException ex) {
                 Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
             }
            
            
        }
});
        mk.addActionListener(new ActionListener() {
         @Override
        public void actionPerformed(ActionEvent event) {
                try {
                 PreparedStatement st = conn.prepareStatement("Select * from TAIKHOANHV WHERE TENTAIKHOAN=? AND MATKHAU=?");
                 st.setString(1,tk.getText());
                 st.setString(2,mk.getText());
                 ResultSet rs = st.executeQuery();
                 
              if(rs.next())
              { 
                  
                   PreparedStatement ps = conn.prepareStatement("Select TIENCONLAI From TAIKHOANHV WHERE TENTAIKHOAN='"+tk.getText()+"'" );
                  rs = ps.executeQuery();
                     while (rs.next()) {
                         if(rs.getString("TIENCONLAI").equals("0"))
                         {
                             JOptionPane.showMessageDialog(null, "Tài khoản đã hết tiền");
                               tk.setText("");
                                mk.setText("");
                         }
                         else
                         {      
                             JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
                              dispose();
                                gd.txtTenTK.setText(tk.getText());
                              gd.txtTienTK.setText(rs.getString("TIENCONLAI"));
                             
                              Tat();
                              gd.txtTenMay.setText("MÁY 01");
                              gd.setVisible(true);
                              
                                
                         }
                    
                    }                           
                               
              }
              else
              {
                  JOptionPane.showMessageDialog(null, "Sai tên tài khoản hoặc mật khẩu");
                  tk.setText("");
                  mk.setText("");

              }   
             } catch (SQLException ex) {
                 Logger.getLogger(LoginForm.class.getName()).log(Level.SEVERE, null, ex);
             } 
            
            
        }
        });
    }   
                      
    public static void main(String[] args) 
    {
        new LoginForm().setVisible(true);
    }

   
}
