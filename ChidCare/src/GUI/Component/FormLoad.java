/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI.Component;

import DAL.MyConnection;
import GUI.frmServerConfig;
import GUI.frmLogin;
import Images.ImageHelper;
import java.awt.*;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Nguyen Dinh Tan
 */
public class FormLoad extends JFrame {

    private static ImageIcon bgMain;
    private int  duration;
    private ImageIcon logo;
    public FormLoad(int d)
    {
        duration =d;
        logo = ImageHelper.loadImage("logo.png");
        Image image = logo.getImage();
        bgMain = ImageHelper.loadImage("bgMain.png");
        bgMain.getImage();
        setIconImage(image);
        setTitle("ChildCare Splash Screen");
    }
     // Set up contraints so that the user supplied component and the
    // background image label overlap and resize identically
    private static final GridBagConstraints gbc;
    static {
        gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.NORTHWEST;
    }
    public static JPanel wrapInBackgroundImage(JComponent component, Icon backgroundIcon) {
        return wrapInBackgroundImage(component, backgroundIcon, JLabel.TOP, JLabel.LEADING);
    }

     public static JPanel wrapInBackgroundImage(JComponent component,Icon backgroundIcon, int verticalAlignment, int horizontalAlignment) {

        // make the passed in swing component transparent
        component.setOpaque(false);

        // create wrapper JPanel
        JPanel backgroundPanel = new JPanel(new GridBagLayout());

        // add the passed in swing component first to ensure that it is in front
        backgroundPanel.add(component, gbc);

        // create a label to paint the background image
        JLabel backgroundImage = new JLabel(backgroundIcon);

        // set minimum and preferred sizes so that the size of the image
        // does not affect the layout size
        backgroundImage.setPreferredSize(new Dimension(1,1));
        backgroundImage.setMinimumSize(new Dimension(1,1));

        // align the image as specified.
        backgroundImage.setVerticalAlignment(verticalAlignment);
        backgroundImage.setHorizontalAlignment(horizontalAlignment);

        // add the background label
        backgroundPanel.add(backgroundImage, gbc);

        // return the wrapper
        return backgroundPanel;
    }
   public void showSplash() {

        //JPanel content = (JPanel)getContentPane();
        //content.setBackground(Color.white);

        // Set the window's bounds, centering the window
        int width = 400;
        int height =300;
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screen.width-width)/2;
        int y = (screen.height-height)/2;
        setBounds(x,y,width,height);

        // Display it
        setVisible(true);
        // Wait a little while, maybe while loading resources
        try { Thread.sleep(duration); } catch (Exception e) {}

        setVisible(false);
    }
    public void showSplashAndExit() {
       showSplash();
        System.exit(0);
    }
    public static void main(String[] args) {
        try {
            // Throw a nice little title page up on the screen first
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            FormLoad splash = new FormLoad(2000);
            JPanel foregroundPanel = new JPanel(new BorderLayout(10, 10));
            foregroundPanel.setBackground(Color.white);
            Color oraRed = new Color(156, 20, 20, 255);
            foregroundPanel.setBorder(BorderFactory.createLineBorder(oraRed, 1));
            foregroundPanel.setOpaque(false);
            foregroundPanel.add(new JLabel(" Loading ... Please wait"), BorderLayout.SOUTH);
            splash.setContentPane(wrapInBackgroundImage(foregroundPanel, bgMain));
            //splash.setContentPane(wrapInBackgroundImage(foregroundPanel,new ImageIcon(BackgroundLookupListener.class.getResource("bgMain.png"))));
            //hiddle title bar
            splash.setUndecorated(true);
            splash.showSplash();
            //Call to view login form
            //new Loginuser(null, true).setVisible(true);
            @SuppressWarnings("static-access")
            MyConnection cn = new MyConnection();
            Connection connec = cn.getConnection();
            if(connec != null){
                new frmLogin(null, true).setVisible(true);
            }
            else{
                new frmServerConfig().setVisible(true);
            }
            splash.dispose();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormLoad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(FormLoad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FormLoad.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(FormLoad.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
