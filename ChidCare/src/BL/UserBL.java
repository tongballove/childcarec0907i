/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import DAL.MyConnection;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 *
 * @author Admin
 */
public class UserBL {

    private String sql;
    private MyConnection connec;
    private ResultSet Result;
    private int Record;
    private String message;
    private String Evt;
    private int UserCode;
    private String FullName;
    private String Account;
    private String Password;
    private String Sex;
    private String Address;
    private String Birthday;
    private String Phone;
    private String Email;
    private String StartDate;
    private String Feedback;
    private String Admin;

    public UserBL(String _Evt, int _UserCode, String _FullName, String _Account, String _Password, String _Sex, String _Address, String _Birthday, String _Phone, String _Email, String _StartDate, String _Feedback, String _Admin) {
        Evt = _Evt;
        UserCode = _UserCode;
        FullName = _FullName;
        Account = _Account;
        Password = _Password;
        Sex = _Sex;
        Address = _Address;
        Birthday = _Birthday;
        Phone = _Phone;
        Email = _Email;
        StartDate = _StartDate;
        Feedback = _Feedback;
        Admin = _Admin;
        connec = new MyConnection();
    }

    public UserBL(String _Evt, int _UserCode) {
        Evt = _Evt;
        UserCode = _UserCode;
        connec = new MyConnection();
    }

    public UserBL() {
        connec = new MyConnection();
    }

    public void setStatement() {
        if (Evt.equals("Add")) {
            this.sql = "Execute spInserttbl_Users '" + FullName + "', '" + Account + "', '" + Password + "', "
                    + Sex + ", '" + Address + "', '" + Birthday + "', '" + Phone + "', '" + Email + "', '"
                    + StartDate + "', '" + Feedback + "', " + Admin;
            this.message = " Record has been Insert in the table User succesfully!";
        } else if (Evt.equals("Edit")) {
            this.sql = "Execute spUpdatetbl_Users " + UserCode + ", '" + Address + "', '"
                    + Phone + "', '" + Email + "', '" + Feedback + "', " + Admin;
            this.message = " Record has been Update in the table User succesfully!";
        } else if (Evt.equals("Delete")) {
            this.sql = "Execute spDeletetbl_Users " + UserCode + " ";
            this.message = " Record has been Deleted in the table User succesfully!";
        } else if (this.sql.equals("") || this.sql == null) {
            return;
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

    public void ChengePassword(int userCode, String passWord) {
        this.sql = "Execute spChangePassword " + userCode + ", '" + passWord + "' ";
        Record = connec.ExecuteSQLUpdate(sql);
        message = "Chenge Password succesfully!";
        if (Record != 0) {
            JOptionPane.showMessageDialog(null, message);
        } else {
            JOptionPane.showMessageDialog(null, "Do not can change this Password of Account!");
        }
    }

    public int getRecord() {
        return Record;
    }
}
