/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utility;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Intel
 */
public class autonumbertransaksi {
    String auto;
    koneksi conn =new koneksi();

    public autonumbertransaksi() {
    }

    public void SetAutoNumber(String tabel,String kode,String insial) {
try {
    
String sql = "SELECT * FROM "+tabel+" ORDER BY "+kode+" DESC";

ResultSet rs ;
rs=conn.ambilData(sql);
if (rs.next()) {
String kd_barang = rs.getString(kode).substring(1,4); 
String AN = "" +(Integer.parseInt(kd_barang) + 1);
String Nol = "";
 
if(AN.length()==1)
{Nol = "000";}
else if(AN.length()==2)
{Nol = "00";}
else if(AN.length()==3)
{Nol = "0";}
else if(AN.length()==4)
{Nol = "";}
 auto=(""+ Nol +AN+insial );
} 
else {
auto=("0001"+insial);
}

} catch (Exception e) {
JOptionPane.showMessageDialog(null, e+"autonum");
    
}
}
    public String GetAutoNumber(){
        
        return auto;
    }
}