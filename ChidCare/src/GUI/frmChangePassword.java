/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmChangePassword.java
 *
 * Created on Sep 6, 2010, 9:57:24 AM
 */
package GUI;

import BL.UserBL;
import GUI.Component.MD5Password;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class frmChangePassword extends javax.swing.JDialog {

    private int UserCode;
    private String Password;
    private String NewPassword;
    private String OldPassword;
    private String ConfirmPassword;
    private UserBL userbl;

    /** Creates new form frmChangePassword */
    public frmChangePassword(java.awt.Frame parent, boolean modal, int Code, String pass) {
        super(parent, modal);
        UserCode = Code;
        Password = pass;
        initComponents();
        Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation((ds.width - this.getWidth()) / 2, (ds.height - this.getHeight()) / 2);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        txtNewPassword = new javax.swing.JPasswordField();
        txtConfirmNewPassword = new javax.swing.JPasswordField();
        btOk = new javax.swing.JButton();
        btCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chenge Password - Child Care");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Chenge Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        jLabel1.setText("Old Password :");

        jLabel2.setText("New Password :");

        jLabel3.setText("Confirm New Password :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNewPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
                    .addComponent(txtPassword)
                    .addComponent(txtConfirmNewPassword))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtConfirmNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        btOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Button-Refresh-16x16.png"))); // NOI18N
        btOk.setText("Ok");
        btOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOkActionPerformed(evt);
            }
        });

        btCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cross.png"))); // NOI18N
        btCancel.setText("Cancel");
        btCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(165, Short.MAX_VALUE)
                .addComponent(btOk, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btCancel)
                .addGap(23, 23, 23))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btOk)
                    .addComponent(btCancel))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOkActionPerformed
        // TODO add your handling code here:
        ChangePassword();
    }//GEN-LAST:event_btOkActionPerformed

    private void btCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btCancelActionPerformed
    /**
     * @param args the command line arguments
     */
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancel;
    private javax.swing.JButton btOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField txtConfirmNewPassword;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables

    private boolean Check() {
        String oldPassword = new String(txtPassword.getPassword());
        String newPassword = new String(txtNewPassword.getPassword());
        String confirmPassword = new String(txtConfirmNewPassword.getPassword());
        if (oldPassword.equals("") || oldPassword == null) {
            CreateWarningDialog("Please enter the Old Password!", "Chenge Password - Child Care");
            txtPassword.requestFocus();
            return false;
        } else if (newPassword.equals("") || newPassword == null) {
            CreateWarningDialog("Please enter the New Password!", "Chenge Password - Child Care");
            txtNewPassword.requestFocus();
            return false;
        } else if (confirmPassword.equals("") || confirmPassword == null) {
            CreateWarningDialog("Please enter the Confirm new Password!", "Chenge Password - Child Care");
            txtConfirmNewPassword.requestFocus();
            return false;
        } else {
            try {
                OldPassword = MD5Password.getEncodedPassword(oldPassword);
                NewPassword = MD5Password.getEncodedPassword(newPassword);
                ConfirmPassword = MD5Password.getEncodedPassword(confirmPassword);
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(frmChangePassword.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        if (!OldPassword.equals(Password)) {
            CreateWarningDialog("Old Password invalid, Please Re-enter Password!", "Chenge Password - Child Care");
            txtPassword.requestFocus();
            return false;
        } else if (!ConfirmPassword.equals(NewPassword)) {
            CreateWarningDialog("Confirm new Password invalid, Please Re-enter Confirm new Password!", "Chenge Password - Child Care");
            txtConfirmNewPassword.requestFocus();
            return false;
        }
        return true;
    }

    private void ChangePassword() {

        Boolean check = Check();
        if (!check) {
            return;
        } else {
            int i = CreateOptionDialog("Are you sure want Change Password ?", "Change Password - Child Care");
            if (i == 0) {
                userbl = new UserBL();
                userbl.ChengePassword(UserCode, NewPassword);
                this.dispose();
            }
        }
    }

    private void CreateWarningDialog(String info, String title) {
        JOptionPane.showMessageDialog(this, info, title, JOptionPane.WARNING_MESSAGE);
    }

    private int CreateOptionDialog(String info, String title) {
        Object[] options = {"Yes", "No"};
        int confirm = JOptionPane.showOptionDialog(this, info, title, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
        return confirm;
    }
}
