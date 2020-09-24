/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Utility;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


/**
 * 
 * @author SAD
 */
public class background extends JPanel{
    private Image gam;
    String bg="/img/background.jpg";

    public String getBg() {
        return bg;
    }

    public void setBg(String bg) {
        this.bg = bg;
    }
    

    public background() {
        setOpaque(true);
        gam=new ImageIcon(getClass().getResource(bg)).getImage();
    }

    public void setGambar(String gambar){
        try{
            gam=new ImageIcon(getClass().getResource(gambar)).getImage();
            repaint();
        }
        catch(Exception z){};
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D gd=(Graphics2D)g.create();
        gd.drawImage(gam, 0,0,getWidth(),getHeight(),null);
        gd.dispose();
    }



}
