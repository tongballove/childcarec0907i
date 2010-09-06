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
public class ClassBL {

    private String sql;
    private MyConnection connec;
    private ResultSet Result;
    private int Record;
    private String message;
    private String Evt;
    private int ClassCode;
    private String ClassName;
    private int AgeGroup;
    private String Note;

    public ClassBL(String _Evt, int _ClassCode, String _ClassName, int _AgeGroup, String _Note) {
        Evt = _Evt;
        ClassCode = _ClassCode;
        ClassName = _ClassName;
        AgeGroup = _AgeGroup;
        Note = _Note;
        connec = new MyConnection();
    }

    public ClassBL(String _Evt, int _ClassCode) {
        Evt = _Evt;
        ClassCode = _ClassCode;
        connec = new MyConnection();
    }

    public ClassBL() {
        connec = new MyConnection();
    }

    public void setStatement() {
        if (Evt.equals("Add")) {
            this.sql = "Execute spInserttbl_Class '"+ ClassName +"', "+ AgeGroup +", '"+ Note +"' ";
            this.message = " Record has been Insert in the table Class succesfully!";
        } else if (Evt.equals("Edit")) {
            this.sql = "Execute spUpdatetbl_Class "+ ClassCode +", '"+ ClassName +"', "+ AgeGroup +", '"+ Note +"' ";
            this.message = " Record has been Update in the table Class succesfully!";
        } else if (Evt.equals("Delete")) {
            this.sql = "Execute spDeletetbl_Class " + ClassCode + " ";
            this.message = " Record has been Deleted in the table Class succesfully!";
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
}
