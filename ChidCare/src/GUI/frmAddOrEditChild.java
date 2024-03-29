/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * frmChildList.java
 *
 * Created on Aug 12, 2010, 8:44:40 AM
 */
package GUI;

import BL.ChildBL;
import DAL.ResultSetComboboxModel;
import GUI.Component.RightPanel;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Admin
 */
public class frmAddOrEditChild extends javax.swing.JPanel {

    private ResultSet rs;
    private int ChildCode;
    private int GroupAgeCode;
    private String LastName;
    private String FirstName;
    private String DateOfBirth;
    private String Sex;
    private String Address;
    private String CurrentMedication;
    private String PassIllness;
    private String DoctorName;
    private String ParentName;
    private String ParentWorkNumber;
    private String ParentMobileNumber;
    private String NextOfKinContact;
    private String NoteAboutChild;
    private String RegistrationDate;
    private String DateReceived;
    private String ParentEmailAddress;
    private final String Title;
    private ResultSetComboboxModel cbm;
    private String[] model;
    private ChildBL childbl;
    private RightPanel RightPanel;

    /** Creates new form frmChildList */
    public frmAddOrEditChild(String title, RightPanel rihtpanel) {
        Title = title;
        cbm = new ResultSetComboboxModel();
        this.model = cbm.ComboboxModel("AgeGroup", "tbl_AgeGroup");
        initComponents();
        plTable.setBorder(BorderFactory.createTitledBorder(null, Title + " of the Children", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Times New Roman", 1, 17)));
        setText();
        RightPanel = rihtpanel;
    }

    public frmAddOrEditChild(String title, int Code, RightPanel rihtpanel) {
        Title = title;
        cbm = new ResultSetComboboxModel();
        this.model = cbm.ComboboxModel("AgeGroup", "tbl_AgeGroup");
        ChildCode = Code;
        initComponents();
        plTable.setBorder(BorderFactory.createTitledBorder(null, Title + " of the Children", TitledBorder.DEFAULT_JUSTIFICATION, TitledBorder.DEFAULT_POSITION, new Font("Times New Roman", 1, 17)));
        setText();
        RightPanel = rihtpanel;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        plTable = new javax.swing.JPanel();
        plButton = new javax.swing.JPanel();
        btSave = new javax.swing.JButton();
        btReset = new javax.swing.JButton();
        btClose = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtBirthday = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        cbAgeGroup = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        rbMale = new javax.swing.JRadioButton();
        rbFemale = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        txtParentName = new javax.swing.JTextField();
        txtParentWorkName = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtParentEmailAddress = new javax.swing.JTextField();
        txtParentMobileNumber = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jLabel32 = new javax.swing.JLabel();
        txtNextOfKinContact = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        txtNoteAboutChild = new javax.swing.JTextField();
        txtRegistrationDate = new com.toedter.calendar.JDateChooser();
        jLabel34 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        txtDateReceived = new com.toedter.calendar.JDateChooser();
        jPanel9 = new javax.swing.JPanel();
        txtCurrentMedication = new javax.swing.JTextField();
        txtPastIllness = new javax.swing.JTextField();
        txtDoctorName = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();

        plTable.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add of the Children", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 17))); // NOI18N

        btSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/save-16x16.png"))); // NOI18N
        btSave.setText(" Save");
        btSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSaveActionPerformed(evt);
            }
        });

        btReset.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/arrow-circle-double-135.png"))); // NOI18N
        btReset.setText(" Reset");
        btReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btResetActionPerformed(evt);
            }
        });

        btClose.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/cross.png"))); // NOI18N
        btClose.setText(" Close");
        btClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout plButtonLayout = new javax.swing.GroupLayout(plButton);
        plButton.setLayout(plButtonLayout);
        plButtonLayout.setHorizontalGroup(
            plButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plButtonLayout.createSequentialGroup()
                .addContainerGap(505, Short.MAX_VALUE)
                .addComponent(btSave, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btReset, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btClose)
                .addGap(42, 42, 42))
        );
        plButtonLayout.setVerticalGroup(
            plButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(plButtonLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(plButtonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSave)
                    .addComponent(btReset)
                    .addComponent(btClose)))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail Child"));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Last Name");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Sex");

        txtBirthday.setDateFormatString("MMMM/dd/yyyy");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Birthday");

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Address");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Age Group");

        cbAgeGroup.setModel(new DefaultComboBoxModel(model));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("First Name");

        buttonGroup1.add(rbMale);
        rbMale.setText("Male");

        buttonGroup1.add(rbFemale);
        rbFemale.setText("Female");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(jLabel20)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                    .addComponent(txtBirthday, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(rbMale)
                        .addGap(15, 15, 15)
                        .addComponent(rbFemale))
                    .addComponent(txtLastName, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                    .addComponent(txtAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 296, Short.MAX_VALUE)
                    .addComponent(cbAgeGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbMale)
                            .addComponent(rbFemale))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbAgeGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(txtBirthday, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addGap(30, 30, 30))))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Detail Parent"));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("Parent Name");

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Parent Work Number");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Parent Mobile Number");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Parent Email Address");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12)
                            .addComponent(jLabel15))
                        .addGap(15, 15, 15)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtParentName)
                            .addComponent(txtParentWorkName, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(txtParentEmailAddress, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                            .addComponent(txtParentMobileNumber)))
                    .addComponent(jLabel14))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtParentName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtParentWorkName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtParentMobileNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtParentEmailAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Other information"));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel32.setText("Next Of Kin Contact");

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel33.setText("Note About Child");

        txtRegistrationDate.setDateFormatString("MMMM/dd/yyyy");

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel34.setText("Registration Date");

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel35.setText("End Date");

        txtDateReceived.setDateFormatString("MMMM/dd/yyyy");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel35)
                            .addComponent(jLabel33)
                            .addComponent(jLabel32))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDateReceived, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtRegistrationDate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNoteAboutChild)
                            .addComponent(txtNextOfKinContact, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel34))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(txtNextOfKinContact, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel33)
                    .addComponent(txtNoteAboutChild, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel34)
                    .addComponent(txtRegistrationDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel35)
                    .addComponent(txtDateReceived, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30))
        );

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("History disease"));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setText("Doctor Name");

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel30.setText("Past Illness");

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel31.setText("Current Medication");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(13, 13, 13)
                        .addComponent(txtCurrentMedication, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel29)
                        .addGap(45, 45, 45)
                        .addComponent(txtDoctorName, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(57, 57, 57)
                        .addComponent(txtPastIllness, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(txtCurrentMedication, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPastIllness, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtDoctorName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel29))
                .addContainerGap(61, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout plTableLayout = new javax.swing.GroupLayout(plTable);
        plTable.setLayout(plTableLayout);
        plTableLayout.setHorizontalGroup(
            plTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(plButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plTableLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(plTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(plTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        plTableLayout.setVerticalGroup(
            plTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, plTableLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(plTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(plTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE))
                .addGap(23, 23, 23)
                .addComponent(plButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(plTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(plTable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(42, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSaveActionPerformed
        // TODO add your handling code here:
        Boolean test = check();
        if (test == false) {
            return;
        }
        getText();
        Save();
        setText();
    }//GEN-LAST:event_btSaveActionPerformed

    private void btCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCloseActionPerformed
        // TODO add your handling code here:
        close();
    }//GEN-LAST:event_btCloseActionPerformed

    private void btResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btResetActionPerformed
        setText(0);
    }//GEN-LAST:event_btResetActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btClose;
    private javax.swing.JButton btReset;
    private javax.swing.JButton btSave;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbAgeGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPanel plButton;
    private javax.swing.JPanel plTable;
    private javax.swing.JRadioButton rbFemale;
    private javax.swing.JRadioButton rbMale;
    private javax.swing.JTextField txtAddress;
    private com.toedter.calendar.JDateChooser txtBirthday;
    private javax.swing.JTextField txtCurrentMedication;
    private com.toedter.calendar.JDateChooser txtDateReceived;
    private javax.swing.JTextField txtDoctorName;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtNextOfKinContact;
    private javax.swing.JTextField txtNoteAboutChild;
    private javax.swing.JTextField txtParentEmailAddress;
    private javax.swing.JTextField txtParentMobileNumber;
    private javax.swing.JTextField txtParentName;
    private javax.swing.JTextField txtParentWorkName;
    private javax.swing.JTextField txtPastIllness;
    private com.toedter.calendar.JDateChooser txtRegistrationDate;
    // End of variables declaration//GEN-END:variables

    private void close() {
        for (int i = 0; i < RightPanel.getCount(); i++) {
            if (RightPanel.getTabTitle(Title + " Children", i)) {
                RightPanel.RemoveTabAt(i);
            }
        }
    }

    private Boolean check() {
        String strEmail = "\\w+(\\.\\w+)*@\\w+(\\.\\w+)+";
        Date d = new Date();
        if (txtLastName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please, Enter LastName");
            txtLastName.requestFocus();
            return false;
        } else if (txtFirstName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please, Enter FirstName");
            txtFirstName.requestFocus();
            return false;
        } else if (txtAddress.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please, Enter Address");
            txtAddress.requestFocus();
            return false;
        } else if (txtParentName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please, Enter ParentName");
            txtParentName.requestFocus();
            return false;
        } else if (txtParentMobileNumber.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "Please, Enter ParentMobileNumber");
            txtParentMobileNumber.requestFocus();
            return false;
        } //        try {
        //            int age = Integer.parseInt(txtParentMobileNumber.getText());
        //        } catch (Exception e) {
        //            JOptionPane.showMessageDialog(this, "PhoneNumBer must Number");
        //            return;
        //        }
        else if (txtParentEmailAddress.getText().length() != 0) {
            if (!Pattern.matches(strEmail, txtParentEmailAddress.getText())) {
                JOptionPane.showMessageDialog(this, "Email no match!");
                txtParentEmailAddress.requestFocus();
                txtParentEmailAddress.selectAll();
                return false;
            }
        } else if (txtBirthday.getDate() != null) {
            if (txtBirthday.getCalendar().getTime().after(d)) {
                JOptionPane.showMessageDialog(this, "Birthday Date < today");
                txtBirthday.setDate(null);
                txtBirthday.requestFocus();
                return false;
            }
        } else if (txtRegistrationDate.getDate() != null) {
            if (txtRegistrationDate.getCalendar().getTime().after(d)) {
                JOptionPane.showMessageDialog(this, "RegistrationDate Date <= today");
                txtRegistrationDate.setDate(null);
                txtRegistrationDate.requestFocus();
                return false;
            }
        } else if (txtDateReceived.getDate().after(txtRegistrationDate.getDate())) {
            JOptionPane.showMessageDialog(this, "RegistrationDate < DateReceived");
            txtDateReceived.setDate(null);
            txtDateReceived.requestFocus();
            return false;
        }
        return true;
    }

    private void setText(int x) {
        txtAddress.setText("");
        txtCurrentMedication.setText("");
        txtPastIllness.setText("");
        txtDoctorName.setText("");
        txtParentWorkName.setText("");
        txtParentMobileNumber.setText("");
        txtNextOfKinContact.setText("");
        txtNoteAboutChild.setText("");
        txtParentEmailAddress.setText("");
        txtDateReceived.setDate(null);

    }

    private void setText() {
        if (Title.equals("Edit")) {
            if (ChildCode >= 1) {
                childbl = new ChildBL();
                rs = childbl.ExecuteSQLProc(ChildCode);
                try {
                    if (rs.next()) {
                        ChildCode = Integer.parseInt(rs.getString("ChildCode"));
                        txtLastName.setText(rs.getString("LastName"));
                        txtFirstName.setText(rs.getString("FirstName"));
                        txtAddress.setText(rs.getString("Address"));
                        txtCurrentMedication.setText(rs.getString("CurrentMedication"));
                        txtPastIllness.setText(rs.getString("PassIllness"));
                        txtDoctorName.setText(rs.getString("DoctorName"));
                        txtParentName.setText(rs.getString("ParentName"));
                        txtParentWorkName.setText(rs.getString("ParentWorkNumber"));
                        txtParentMobileNumber.setText(rs.getString("ParentMobileNumber"));
                        txtNextOfKinContact.setText(rs.getString("NextOfKinContact"));
                        txtNoteAboutChild.setText(rs.getString("NoteAboutChild"));
                        txtParentEmailAddress.setText(rs.getString("ParentEmailAddress"));
                        txtBirthday.setDate(rs.getDate("DateOfBirth"));
                        txtRegistrationDate.setDate(rs.getDate("RegistrationDate"));
                        txtDateReceived.setDate(rs.getDate("DateReceived"));
                        if (rs.getBoolean("Sex")) {
                            rbMale.setSelected(true);
                        } else {
                            rbFemale.setSelected(true);
                        }
                        cbAgeGroup.setSelectedIndex(rs.getInt("GroupAgeCode") - 1);
                        txtLastName.setEditable(false);
                        txtFirstName.setEditable(false);
                        rbMale.setEnabled(false);
                        rbFemale.setEnabled(false);
                        txtBirthday.setEnabled(false);
                        txtParentName.setEditable(false);
                        txtRegistrationDate.setEnabled(false);

                    } else {
                        JOptionPane.showMessageDialog(null, "Not find this ChildCode");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(frmAddOrEditChild.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else if (Title.equals("Add")) {
            txtLastName.setText("");
            txtFirstName.setText("");
            txtAddress.setText("");
            txtCurrentMedication.setText("");
            txtPastIllness.setText("");
            txtDoctorName.setText("");
            txtParentName.setText("");
            txtParentWorkName.setText("");
            txtParentMobileNumber.setText("");
            txtNextOfKinContact.setText("");
            txtNoteAboutChild.setText("");
            txtParentEmailAddress.setText("");
            txtBirthday.setDate(null);
            txtRegistrationDate.setDate(null);
            txtDateReceived.setDate(null);

        }
    }

    private void getText() {
        GroupAgeCode = (cbAgeGroup.getSelectedIndex() + 1);
        LastName = txtLastName.getText();
        FirstName = txtFirstName.getText();
        DateOfBirth = txtBirthday.getCalendar().getTime().toLocaleString();
        Sex = "0";
        if (rbMale.isSelected()) {
            Sex = "1";
        }
        Address = txtAddress.getText();
        CurrentMedication = txtCurrentMedication.getText();
        PassIllness = txtPastIllness.getText();
        DoctorName = txtDoctorName.getText();
        ParentName = txtParentName.getText();
        ParentWorkNumber = txtParentWorkName.getText();
        ParentMobileNumber = txtParentMobileNumber.getText();
        NextOfKinContact = txtNextOfKinContact.getText();
        NoteAboutChild = txtNoteAboutChild.getText();
        RegistrationDate = txtRegistrationDate.getCalendar().getTime().toLocaleString();
        DateReceived = txtDateReceived.getCalendar().getTime().toLocaleString();
        ParentEmailAddress = txtParentEmailAddress.getText();
    }

    private void Save() {
        int j = 0;
        childbl = new ChildBL(Title, ChildCode, GroupAgeCode, LastName, FirstName, DateOfBirth, Sex, Address, CurrentMedication, PassIllness, DoctorName, ParentName, ParentWorkNumber, ParentMobileNumber, NextOfKinContact, NoteAboutChild, RegistrationDate, DateReceived, ParentEmailAddress);
        childbl.setStatement();
        childbl.ExecuteSQLProc();
        for (int i = 0; i < RightPanel.getCount(); i++) {
            if (RightPanel.getTabTitle("Child List", i)) {
                RightPanel.RemoveTabAt(i);
                j = i;
            }
        }
        if (j > 0) {
            RightPanel.addSubPane("Child List", RightPanel, null);
        }
    }
}
