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

    private int a;
    private String sql;
    private MyConnection connec;
    private ResultSet Result;
    private int Record;
    private String message;

    public NannyBL(String evt, int NannyCode, int ClassCode, int ChildCode, String Name, String DateOfBirth, String Sex, String Address, String Phone, String Email, String Charge, String WorkingHours) {

        if (evt.equals("Add")) {
            this.sql = "Execute spInserttbl_Nanny " + ClassCode + ", '" + Name + "', '" + DateOfBirth + "', "
                    + Sex + ", '" + Address + "', '" + Phone + "', '" + Email + "', '" + Charge + "', "
                    + WorkingHours + ", " + ChildCode;
            this.message = " Record has been Insert in the table Nanny succesfully!";
        } else if (evt.equals("Edit")) {
            this.sql = "Execute spUpdatetbl_Nanny " + NannyCode + ", " + ClassCode + ", '" + Name + "', '"
                    + DateOfBirth + "', " + Sex + ", '" + Address + "', '" + Phone + "', '" + Email + "', '"
                    + Charge + "', " + WorkingHours + ", " + ChildCode;
            this.message = " Record has been Update in the table Nanny succesfully!";
        }
        if (this.sql.equals("") || this.sql == null) {
            return;
        }
        connec = new MyConnection();
        Record = connec.ExecuteSQLUpdate(sql);
        JOptionPane.showMessageDialog(null, Record + message);
    }

    public NannyBL(String evt, int NannyCode) {
        if (evt.equals("Delete")) {
            this.sql = "Execute spDeletetbl_Nanny " + NannyCode + " ";
            this.message = " Record has been Deleted in the table Nanny";
        }
        if (this.sql.equals("") || this.sql == null) {
            return;
        }
        connec = new MyConnection();
        Record = connec.ExecuteSQLUpdate(sql);
        JOptionPane.showMessageDialog(null, Record + message);
    }

    public NannyBL() {
    }

    public ResultSet getResult(String proc, int Code) {

        connec = new MyConnection();
        this.sql = "Execute " + proc + " " + Code + " ";
        Result = connec.ExecuteSQLResult(sql);
        return Result;
    }

    public int getRecord() {
        return Record;
    }
}
