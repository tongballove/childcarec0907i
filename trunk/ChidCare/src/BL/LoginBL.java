/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import DAL.MyConnection;
import java.sql.ResultSet;

/**
 *
 * @author Admin
 */
public class LoginBL {

    private String sql;
    private MyConnection connec;
    private ResultSet Result;
    private int Record;
    private String User;
    private String Pass;

    public LoginBL(String userName, String passWord) {
        User = userName;
        Pass = passWord;
    }

    public ResultSet getResult() {
        connec = new MyConnection();
        this.sql = "Execute spGetLogin '"+ User +"', '"+ Pass +"'";
        Result = connec.ExecuteSQLResult(sql);
        return Result;
    }
}
