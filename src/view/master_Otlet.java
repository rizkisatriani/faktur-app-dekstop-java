/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package view;

import Utility.autonumber;
import Utility.cetak;
import Utility.koneksi;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author User
 */
public class master_Otlet extends javax.swing.JFrame {
DefaultTableModel tb; 

      koneksi coon=new koneksi();
 SimpleDateFormat tahun = new SimpleDateFormat("yy");
 SimpleDateFormat bulan = new SimpleDateFormat("MM");
    autonumber auto=new autonumber();
   NumberFormat kurensi = NumberFormat.getInstance();
    cetak Cetak=new cetak();
 int tottal;
 boolean tab;
  boolean status;
    /**
     * Creates new form master_barang
     */
    public master_Otlet() {
        initComponents(); 
        tabelmodel();
        setLocationRelativeTo(this); 
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        txtcari = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtkode = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtnama = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtalamat = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtnotelp = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel6.setText("Cari");

        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcariKeyReleased(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel5.setText("Email");

        txtemail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtemailKeyReleased(evt);
            }
        });

        jLabel1.setText("Kode");

        txtkode.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtkodeKeyReleased(evt);
            }
        });

        jLabel2.setText("Nama");

        txtnama.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnamaKeyReleased(evt);
            }
        });

        jLabel3.setText("Alamat");

        txtalamat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtalamatKeyReleased(evt);
            }
        });

        jLabel4.setText("No Telp");

        txtnotelp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnotelpKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtkode, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(txtnotelp, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(8, 8, 8)))
                    .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtkode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtnama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtalamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtnotelp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jButton1.setText("Refresh");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Simpan");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jButton2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jButton2KeyReleased(evt);
            }
        });

        jButton3.setText("Edit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Hapus");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcari)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
            if (txtkode.getText().equals("")||txtnama.getText().equals("")) {
        JOptionPane.showMessageDialog(this,"Data belum lengkap");
    }
    else{
coon.simpanData("update tbl_otlet	set "
                + " Nama ='"+txtnama.getText()+"', "
                + " alamat= '"+txtalamat.getText()+"', "
                + " No_telp= '"+txtnotelp.getText()+"', "
                + " email = '"+txtemail.getText()+"' " 
                + " where "

                + " kode ='"+txtkode.getText()+"' " );
                  
        bersihaset();
        tabelmodel(); 
         }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
               coon.simpanData("delete from tbl_otlet where kode="+
	"'"+txtkode.getText()+"'");
        tabelmodel(); 
        bersihaset(); 
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int baris=jTable1.getSelectedRow();
txtkode.setText(jTable1.getValueAt(baris,0).toString());
txtnama.setText(jTable1.getValueAt(baris,1).toString());
txtalamat.setText(jTable1.getValueAt(baris,2).toString());
txtnotelp.setText(jTable1.getValueAt(baris,3).toString());
txtemail.setText(jTable1.getValueAt(baris,4).toString()); 
    }//GEN-LAST:event_jTable1MouseClicked

    private void txtcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyReleased
    if (txtcari.equals("")) {
        
    }
    else{
        cari(txtcari.getText());
    }
        
    }//GEN-LAST:event_txtcariKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
bersihaset();
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtkodeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtkodeKeyReleased
        // TODO add your handling code here:
if (evt.getKeyCode()==KeyEvent.VK_ENTER) { 
            txtnama.requestFocus();
        } 
    }//GEN-LAST:event_txtkodeKeyReleased

    private void txtnamaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnamaKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
            txtalamat.requestFocus();
        }
    }//GEN-LAST:event_txtnamaKeyReleased

    private void txtalamatKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtalamatKeyReleased
if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
             txtnotelp.requestFocus();
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_txtalamatKeyReleased

    private void txtnotelpKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnotelpKeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
             txtemail.requestFocus();
        }
    }//GEN-LAST:event_txtnotelpKeyReleased

    private void txtemailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtemailKeyReleased
        // TODO add your handling code here:
if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
             jButton2.requestFocus();
        }
    }//GEN-LAST:event_txtemailKeyReleased

    private void jButton2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jButton2KeyReleased
        // TODO add your handling code here:
        if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
             if (txtkode.getText().equals("")||txtnama.getText().equals("")) {
        JOptionPane.showMessageDialog(this,"Data belum lengkap");
    }
    else{
coon.simpanData("insert into tbl_otlet	values"
                + "	('"+txtkode.getText()+"'," 
                + "'"+txtnama.getText()+"',"
                + "'"+txtalamat.getText()+"',"
                + "'"+txtnotelp.getText()+"',"
                + " '"+txtemail.getText()+"');");
                  
        bersihaset();
        tabelmodel(); 
         }
        }
    }//GEN-LAST:event_jButton2KeyReleased

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
          if (txtkode.getText().equals("")||txtnama.getText().equals("")) {
        JOptionPane.showMessageDialog(this,"Data belum lengkap");
    }
    else{
coon.simpanData("insert into tbl_otlet	values"
                + "	('"+txtkode.getText()+"'," 
                + "'"+txtnama.getText()+"',"
                + "'"+txtalamat.getText()+"',"
                + "'"+txtnotelp.getText()+"',"
                + " '"+txtemail.getText()+"');");
                  
        bersihaset();
        tabelmodel(); 
         }
    }//GEN-LAST:event_jButton2MouseClicked

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
            java.util.logging.Logger.getLogger(master_Otlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(master_Otlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(master_Otlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(master_Otlet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new master_Otlet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtalamat;
    private javax.swing.JTextField txtcari;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtkode;
    private javax.swing.JTextField txtnama;
    private javax.swing.JTextField txtnotelp;
    // End of variables declaration//GEN-END:variables

    public void tabelmodel(){
       tb =new DefaultTableModel();
       tb.addColumn("Kode ");
       tb.addColumn("Nama");
       tb.addColumn("Alamat");
       tb.addColumn("No Telp");
       tb.addColumn("Email");
       try {
           
   
         ResultSet res = coon.ambilData("select *from tbl_otlet");
        while (res.next()){
                    tb.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3)
                    ,res.getString(4),res.getString(5)});
                } 
      
        jTable1.setModel(tb); 
          } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this, ex);
        }   
    }
public void cari(String cari){ 
       tb =new DefaultTableModel();
       tb.addColumn("Kode ");
       tb.addColumn("Nama");
       tb.addColumn("Alamat");
       tb.addColumn("No Telp");
       tb.addColumn("Email");
       try {
           
   
         ResultSet res = coon.ambilData("select *from tbl_otlet where kode  like '%"+cari+"%' or nama like '%"+cari+"%'");
        while (res.next()){
                    tb.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3)
                    ,res.getString(4),res.getString(5)});
                } 
      
        jTable1.setModel(tb); 
          } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this, ex);
        }   
    }
void bersihaset(){
	txtkode.setText("");
	txtnama.setText("");
	txtalamat.setText("");
	txtnotelp.setText("");
	txtemail.setText(""); 
	 
}
public void Setkodeaset1(){
        try {          
     auto.SetAutoNumber("tbl_otlet","kode","OT-"); 
     txtkode.setText(auto.GetAutoNumber());    
        } catch (Exception e) {
       System.out.printf(null, e);
        }
  }
}

