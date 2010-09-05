/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import DAL.MyConnection;
import java.sql.ResultSet;
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
    private String Evt;
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

    public ChildBL(String _Evt, int _ChildCode, int _GroupAgeCode, String _LastName, String _FirstName, String _DateOfBirth, String _Sex, String _Address, String _CurrentMedication,
            String _PassIllness, String _DoctorName, String _ParentName, String _ParentWorkNumber, String _ParentMobileNumber, String _NextOfKinContact, String _NoteAboutChild, String _RegistrationDate,
            String _DateReceived, String _ParentEmailAddress) {

        Evt = _Evt;
        ChildCode = _ChildCode;
        GroupAgeCode = _GroupAgeCode;
        LastName = _LastName;
        FirstName = _FirstName;
        DateOfBirth = _DateOfBirth;
        Sex = _Sex;
        Address = _Address;
        CurrentMedication = _CurrentMedication;
        PassIllness = _PassIllness;
        DoctorName = _DoctorName;
        ParentName = _ParentName;
        ParentWorkNumber = _ParentWorkNumber;
        ParentMobileNumber = _ParentMobileNumber;
        NextOfKinContact = _NextOfKinContact;
        NoteAboutChild = _NoteAboutChild;
        RegistrationDate = _RegistrationDate;
        DateReceived = _DateReceived;
        ParentEmailAddress = _ParentEmailAddress;
        connec = new MyConnection();
    }

    public ChildBL(String _Evt, int _ChildCode) {
        ChildCode = _ChildCode;
        Evt = _Evt;
        connec = new MyConnection();
    }

    public ChildBL() {
        connec = new MyConnection();
    }

    public void setStatement() {
        if (Evt.equals("Add")) {
            this.sql = "Execute spInserttbl_Child " + GroupAgeCode + ", '" + LastName + "', '" + FirstName + "', '"
                    + DateOfBirth + "', " + Sex + ", '" + Address + "', '" + CurrentMedication + "', '" + PassIllness + "', '"
                    + DoctorName + "', '" + ParentName + "', '" + ParentWorkNumber + "', '" + ParentMobileNumber + "', '"
                    + NextOfKinContact + "', '" + NoteAboutChild + "', '" + RegistrationDate + "', '" + DateReceived + "', '"
                    + ParentEmailAddress + "'";
            this.message = " Record has been Insert in the table Children succesfully!";
        } else if (Evt.equals("Edit")) {
            this.sql = "Execute spUpdatettbl_Child " + ChildCode + ", " + GroupAgeCode + ", '" + Address + "', '" + CurrentMedication + "', '"
                    + PassIllness + "', '" + DoctorName + "', '" + ParentWorkNumber + "', '" + ParentMobileNumber + "', '"
                    + NextOfKinContact + "', '" + NoteAboutChild + "', '" + DateReceived + "', '" + ParentEmailAddress + "'";
            this.message = " Record has been Update in the table Children succesfully!";
        } else if (Evt.equals("Delete")) {
            this.sql = "Execute spDeleteTbl_Child " + ChildCode + " ";
            this.message = " Record has been Deleted in the table Children succesfully!";
        }
    }

    public void ExecuteSQLProc() {
        if (this.sql.equals("") || this.sql == null) {
            return;
        }
        Record = connec.ExecuteSQLUpdate(sql);
        JOptionPane.showMessageDialog(null, Record + message);
    }

    public ResultSet ExecuteSQLProc(int childCore) {
        this.sql = "Execute spSearchChilCodetbl_Child " + childCore;
        Result = connec.ExecuteSQLResult(sql);
        return Result;
    }

    public int getRecord() {
        return Record;
    }
}
