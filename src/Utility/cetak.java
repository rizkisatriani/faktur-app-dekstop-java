/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utility;
import Utility.koneksi;
import com.lowagie.text.pdf.ArabicLigaturizer;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashMap; 
import java.util.Iterator; 
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRuntimeException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author MyUnity
 */
public class cetak {
     JasperExportManager jem;
JasperReport jasperReport1;
    JasperDesign jasperDesign1;
    JasperPrint jasperPrint1;
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    
    public void cetak(File x,Map<String, Object> param){
     try{
          
             jasperDesign1 = JRXmlLoader.load(x);
         jasperReport1 = JasperCompileManager.compileReport(jasperDesign1);
         // jasperReport1=(JasperReport) JRLoader.loadObject(x);
                   jasperPrint1 = JasperFillManager.fillReport(jasperReport1, param,koneksi.getconnetion());
          // JasperViewer.viewReport(jasperPrint1);
         JasperViewer jp=new JasperViewer(jasperPrint1,false);
         jp.setExtendedState(MAXIMIZED_BOTH);
         jp.setVisible(true);
         
              
        } catch (Exception e ){
            PrintStream ps=null;
         try {
             File file=new File("D:/log.txt");
             ps = new PrintStream(file);
             JOptionPane.showMessageDialog(null, e.getMessage());
             e.printStackTrace(ps);
             txt(e);
         } catch (FileNotFoundException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
         } finally {
             ps.close();
         }
        }
    }
    public void cetaklangsung(File x,Map<String, Object> param){
     try{
          
             jasperDesign1 = JRXmlLoader.load(x);
         jasperReport1 = JasperCompileManager.compileReport(jasperDesign1);
         // jasperReport1=(JasperReport) JRLoader.loadObject(x);
                   jasperPrint1 = JasperFillManager.fillReport(jasperReport1, param,koneksi.getconnetion());
          // JasperViewer.viewReport(jasperPrint1);.
                   
         JasperPrintManager.printReport(jasperPrint1, false);
         
              
        } catch (Exception e ){
            PrintStream ps=null;
         try {
             File file=new File("D:/log.txt");
             ps = new PrintStream(file);
             JOptionPane.showMessageDialog(null, e.getMessage());
             e.printStackTrace(ps);
             txt(e);
         } catch (FileNotFoundException ex) {
             JOptionPane.showMessageDialog(null, ex.getMessage());
         } finally {
             ps.close();
         }
        }
    }
    void txt(Exception e){
         try {
            List<String> line=new ArrayList<>();
            line.add(""+e.toString());
             Path file=Paths.get("C:/log.txt");
             Files.write(file, line, Charset.forName("UTF-8"));
         } catch (IOException ex) {
           JOptionPane.showMessageDialog(null, ex);
         }
    }
}
