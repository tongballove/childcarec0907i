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
public class UserBL {
    private String sql;
    private MyConnection connec;
    private ResultSet Result;
    private int Record;
    private String message;

    public UserBL(String evt, int UserCode, String a) {

        if (evt.equals("Add")) {
            this.sql = "Execute spInserttbl_Nanny ";
            this.message = " Record has been Insert in the table Nanny succesfully!";
        } else if (evt.equals("Edit")) {
            this.sql = "Execute spUpdatetbl_Nanny " + UserCode + ", " ;
            this.message = " Record has been Update in the table Nanny succesfully!";
        }
        if (this.sql.equals("") || this.sql == null) {
            return;
        }
        connec = new MyConnection();
        Record = connec.ExecuteSQLUpdate(sql);
        JOptionPane.showMessageDialog(null, Record + message);
    }

    public UserBL(String evt, int UserCode) {
        if (evt.equals("Delete")) {
            this.sql = "Execute spDeletetbl_Nanny " + UserCode + " ";
            this.message = " Record has been Deleted in the table Nanny";
        }
        if (this.sql.equals("") || this.sql == null) {
            return;
        }
        connec = new MyConnection();
        Record = connec.ExecuteSQLUpdate(sql);
        JOptionPane.showMessageDialog(null, Record + message);
    }

    public UserBL() {
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
