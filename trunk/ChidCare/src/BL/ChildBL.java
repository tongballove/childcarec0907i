/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import DAL.MyConnection;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class ChildBL {

    private String sql;
    private MyConnection connec;
    private ResultSet Result;
    private int Record;
    private String message;

    public ChildBL(String evt, int ChildCode, int GroupAgeCode, String LastName, String FirstName, String DateOfBirth, String Sex, String Address, String CurrentMedication,
            String PassIllness, String DoctorName, String ParentName, String ParentWorkNumber, String ParentMobileNumber, String NextOfKinContact, String NoteAboutChild, String RegistrationDate,
            String DateReceived, String ParentEmailAddress) {

        if (evt.equals("Add")) {
            this.sql = "Execute spInserttbl_Child " + GroupAgeCode + ", '" + LastName + "', '" + FirstName + "', '"
                    + DateOfBirth + "', " + Sex + ", '" + Address + "', '" + CurrentMedication + "', '" + PassIllness + "', '"
                    + DoctorName + "', '" + ParentName + "', '" + ParentWorkNumber + "', '" + ParentMobileNumber + "', '"
                    + NextOfKinContact + "', '" + NoteAboutChild + "', '" + RegistrationDate + "', '" + DateReceived + "', '"
                    + ParentEmailAddress + "'";
            this.message = " Record has been Insert in the table Children succesfully!";
        } else if (evt.equals("Edit")) {
            this.sql = "Execute spUpdatettbl_Child " + ChildCode + ", " + GroupAgeCode + ", '" + Address + "', '" + CurrentMedication + "', '"
                    + PassIllness + "', '" + DoctorName + "', '" + ParentWorkNumber + "', '" + ParentMobileNumber + "', '"
                    + NextOfKinContact + "', '" + NoteAboutChild + "', '" + DateReceived + "', '" + ParentEmailAddress + "'";
            this.message = " Record has been Update in the table Children succesfully!";
        }
        if(this.sql.equals("") || this.sql == null){
            return;
        }
        connec = new MyConnection();
        Record = connec.ExecuteSQLUpdate(sql);
        JOptionPane.showMessageDialog(null, Record + message);
    }

    public ChildBL(String evt, int ChildCode) {
        if (evt.equals("Delete")) {
            this.sql = "Execute spDeleteTbl_Child " + ChildCode + " ";
            this.message = " Record has been Deleted in the table Children succesfully!";
        }
        if(this.sql.equals("") || this.sql == null){
            return;
        }
        connec = new MyConnection();
        Record = connec.ExecuteSQLUpdate(sql);
        JOptionPane.showMessageDialog(null, Record + message);
    }

    public ChildBL(){

    }

    public ResultSet getResult(int childCore){

        connec = new MyConnection();
        this.sql = "Execute spSearchChilCodetbl_Child " + childCore;
        Result = connec.ExecuteSQLResult(sql);
        return Result;
    }

    public int getRecord(){
        return Record;
    }
}
