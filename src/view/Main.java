/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import static view.MenuUtama.coon;

/**
 *
 * @author User
 */
public class Main {
     public static void main(String[] args) {
        // TODO code application logic 
            try {
             ResultSet res = coon.ambilData("select *from tema");
             res.next();
            UIManager.setLookAndFeel(res.getString(1));
           } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Terjadi error Thema, Pada : \n" + e);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuUtama().setVisible(true);
            }
        });
    }
}
