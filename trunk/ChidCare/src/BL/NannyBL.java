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
public class NannyBL {

    private String sql;
    private MyConnection connec;
    private ResultSet Result;
    private int Record;
    private String message;
    private String Evt;
    private int NannyCode;
    private int ClassCode;
    private int ChildCode;
    private String Name;
    private String DateOfBirth;
    private String Sex;
    private String Address;
    private String Phone;
    private String Email;
    private String Charge;
    private String WorkingHours;

    public NannyBL(String _Evt, int _NannyCode, int _ClassCode, int _ChildCode, String _Name, String _DateOfBirth, String _Sex, String _Address, String _Phone, String _Email, String _Charge, String _WorkingHours) {

        Evt = _Evt;
        NannyCode = _NannyCode;
        ClassCode = _ClassCode;
        ChildCode = _ChildCode;
        Name = _Name;
        DateOfBirth = _DateOfBirth;
        Sex = _Sex;
        Address = _Address;
        Phone = _Phone;
        Email = _Email;
        Charge = _Charge;
        WorkingHours = _WorkingHours;
        connec = new MyConnection();

    }

    public NannyBL(String _Evt, int _NannyCode) {
        Evt = _Evt;
        NannyCode = _NannyCode;
        connec = new MyConnection();
    }

    public NannyBL() {
        connec = new MyConnection();
    }

    public void setStatement() {
        if (Evt.equals("Add")) {
            this.sql = "Execute spInserttbl_Nanny " + ClassCode + ", '" + Name + "', '" + DateOfBirth + "', "
                    + Sex + ", '" + Address + "', '" + Phone + "', '" + Email + "', '" + Charge + "', "
                    + WorkingHours + ", " + ChildCode;
            this.message = " Record has been Insert in the table Nanny succesfully!";
        } else if (Evt.equals("Edit")) {
            this.sql = "Execute spUpdatetbl_Nanny " + NannyCode + ", " + ClassCode + ", '" + Name + "', '"
                    + DateOfBirth + "', " + Sex + ", '" + Address + "', '" + Phone + "', '" + Email + "', '"
                    + Charge + "', " + WorkingHours + ", " + ChildCode;
            this.message = " Record has been Update in the table Nanny succesfully!";
        } else if (Evt.equals("Delete")) {
            this.sql = "Execute spDeletetbl_Nanny " + NannyCode + " ";
            this.message = " Record has been Deleted in the table Nanny";
        }
    }

    public void ExecuteSQLProc() {
        if (this.sql.equals("") || this.sql == null) {
            return;
        }
        Record = connec.ExecuteSQLUpdate(sql);
        JOptionPane.showMessageDialog(null, Record + message);
    }

    public ResultSet ExecuteSQLProc(String proc, int Code) {
        this.sql = "Execute " + proc + " " + Code + " ";
        Result = connec.ExecuteSQLResult(sql);
        return Result;
    }

    public int getRecord() {
        return Record;
    }
}
