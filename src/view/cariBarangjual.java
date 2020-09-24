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
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class cariBarangjual extends javax.swing.JFrame {
DefaultTableModel tb; 

   DecimalFormat df=new DecimalFormat("#.##");
      koneksi coon=new koneksi();
 SimpleDateFormat tahun = new SimpleDateFormat("yy");
 SimpleDateFormat bulan = new SimpleDateFormat("MM");
    autonumber auto=new autonumber();
   NumberFormat kurensi = NumberFormat.getInstance();
    cetak Cetak=new cetak();
 int tottal;
 boolean tab;
    /**
     * Creates new form cariBarangjual
     */
    public cariBarangjual() {
        initComponents();
        tabelmodel();
        setLocationRelativeTo(rootPane);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        txtcari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel6.setText("Cari");

        txtcari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtcariKeyReleased(evt);
            }
        });

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
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTable1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtcari))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtcari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtcariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtcariKeyReleased
        if (txtcari.equals("")) {

        }
        else{
            cari(txtcari.getText());
        }

    }//GEN-LAST:event_txtcariKeyReleased

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        // TODO add your handling code here:
        int baris=jTable1.getSelectedRow();
        Penjualan.txtkdbarang.setText(jTable1.getValueAt(baris,0).toString());
        Penjualan.txtnamabarang.setText(jTable1.getValueAt(baris,1).toString());
        Penjualan.txtsatuan.setText(jTable1.getValueAt(baris,2).toString());
        Penjualan.txtharga.setText(jTable1.getValueAt(baris,4).toString());
        Penjualan.txtstock.setText(jTable1.getValueAt(baris,5).toString());
      
         double jual,modal,untung;
            float persen;
            jual=Integer.valueOf(jTable1.getValueAt(baris,4).toString());
            modal=Integer.valueOf(jTable1.getValueAt(baris,3).toString());
            untung=jual-modal;
            persen=(float) (untung/modal)*100;
              Penjualan.txtpersen.setText(""+df.format(persen));
dispose();
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTable1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyReleased
        // TODO add your handling code here:
           if (evt.getKeyCode()==KeyEvent.VK_ENTER) {
          int baris=jTable1.getSelectedRow()-1;
        Penjualan.txtkdbarang.setText(jTable1.getValueAt(baris,0).toString());
        Penjualan.txtnamabarang.setText(jTable1.getValueAt(baris,1).toString());
        Penjualan.txtsatuan.setText(jTable1.getValueAt(baris,2).toString());
        Penjualan.txtharga.setText(jTable1.getValueAt(baris,4).toString());
        Penjualan.txtstock.setText(jTable1.getValueAt(baris,5).toString());
      
         double jual,modal,untung;
            float persen;
            jual=Integer.valueOf(jTable1.getValueAt(baris,4).toString());
            modal=Integer.valueOf(jTable1.getValueAt(baris,3).toString());
            untung=jual-modal;
            persen=(float) (untung/modal)*100;
              Penjualan.txtpersen.setText(""+df.format(persen));
              Penjualan.txtqty.requestFocus();
dispose();
        }
    }//GEN-LAST:event_jTable1KeyReleased

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
            java.util.logging.Logger.getLogger(cariBarangjual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cariBarangjual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cariBarangjual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cariBarangjual.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cariBarangjual().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtcari;
    // End of variables declaration//GEN-END:variables
 public void tabelmodel(){
       tb =new DefaultTableModel();
       tb.addColumn("Kode ");
       tb.addColumn("Nama");
       tb.addColumn("satuan");
       tb.addColumn("Harga Modal");
       tb.addColumn("Harga Jual");
       tb.addColumn("Stok");
       try {
           
   
         ResultSet res = coon.ambilData("select *from tblbarang");
        while (res.next()){
                    tb.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3)
                    ,res.getString(4),res.getString(5),res.getString(6)});
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
       tb.addColumn("Satuan");
       tb.addColumn("Harga Modal");
       tb.addColumn("Harga Jual");
       tb.addColumn("Stok");
       try {
           
   
         ResultSet res = coon.ambilData("select *from tblbarang where kode  like '%"+cari+"%' or nama like '%"+cari+"%'");
        while (res.next()){
                    tb.addRow(new Object[]{res.getString(1),res.getString(2),res.getString(3)
                    ,res.getString(4),res.getString(5),res.getString(5)});
                } 
      
        jTable1.setModel(tb); 
          } catch (SQLException ex) {
           JOptionPane.showMessageDialog(this, ex);
        }   
    }
}
