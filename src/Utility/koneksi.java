/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class koneksi {
   

/**
 *
 * @author Intel
 */

        public static Connection koneksi;
        public Statement st;
         private static  com.mysql.jdbc.Connection con;
   
        public static Connection getconnetion(){
        if(koneksi==null){
            try{
                String server="jdbc:mysql://localhost:3306/db_faktur";
                String user="root";
                String password="12345678";
                Class.forName("com.mysql.jdbc.Driver");
                koneksi=DriverManager.getConnection(server,user,password);               
            }catch(Exception x){
                JOptionPane.showMessageDialog(null,"Koneksi Gagal, Pesan error \n"+x);
            }                        
        }
        return koneksi;
    }
     public void koneksi(){
            try{
                getconnetion();
                st=koneksi.createStatement();
            }catch(Exception x){
                JOptionPane.showMessageDialog(null,"Koneksi ambil Gagal, Pesan error \n"+x);
            }          
    }
      public void tutupKoneksi(ResultSet rs){
        try{
            if(rs!=null){
                rs.close();
            }
            st.close();
            koneksi.close();
        }catch(Exception x){
            JOptionPane.showMessageDialog(null,"Tutup Koneksi Gagal, Pesan error \n"+x);
        }
    }
    
    public ResultSet ambilData(String sql){
        ResultSet rs=null;
        try{
            koneksi();
            rs=st.executeQuery(sql);
        }catch(Exception x){
            JOptionPane.showMessageDialog(null,"Ambil Data Gagal, Pesan error  \n"+x);
        }
        return rs;
    }
    public void simpanData(String sql){
        try{            
            koneksi();
            st.executeUpdate(sql);
        }catch(Exception x){
            JOptionPane.showMessageDialog(null,"Simpan Data Gagal, Pesan error : \n"+x);
            System.out.print(x);
        }        
    }
}