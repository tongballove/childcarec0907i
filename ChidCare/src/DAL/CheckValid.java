/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;


/**
 *
 * @author to kim dai
 */
public class CheckValid {

    private static ResultSet rs;
    private static MyConnection connec;
    /*public static boolean isExitsValue(String tableName, String Field, String Value){
        try{
            String sql = "select * form "+ tableName +" where "+ Field +" = '"+ Value +"' And Status = 1";
            Connec con = new Connec();
            rs = con.ExecuteSQLResult(sql);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return (Connec.CountRow(rs)==0)? false:true;
    }*/

    public static ResultSet isExitsSql(String sSql){
        connec = new MyConnection();
        rs = connec.ExecuteSQLResult(sSql);
        //return (Connec.CountRow(rs)==0)? false:true;
        return rs;
    }
    public static boolean isempy(String values){
        if(values.trim().length() == 0 ){
            return false;
        }
        else{
            return true;
        }
    }
    public static boolean  CheckNumber(String value){
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(value);
        if(!m.find()){
            return false;
        }
        else{
            return true;
        }
    }
    public static  boolean  checkDate(String values){
         Pattern p = Pattern.compile("^\\d+[/]\\d+[/]\\d{4}$");
        Matcher m = p.matcher(values);
        if(!m.find()){
            return false;
        }
        else {
            return true;
        }
    }

}
