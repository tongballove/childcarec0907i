/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author to kim dai
 */
public class ResultSetComboboxModel {
    private ResultSet rs;
    String sql;
    String[] model;
    int total;
    private MyConnection con;
    public String[] ComboboxModel(String colName, String tabName){
        int j = 0;
        try {
            con = new MyConnection();
            sql = "Select "+ colName +" from "+ tabName +" where Status = 1";
            rs = con.ExecuteSQLResult(sql);
            rs.last();
            while(rs.previous()){
                j++;
            }
            total = j + 1;

            model = new String[total];
            for(int i = 0; i < total; i++){
                rs.next();
                model[i] = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultSetComboboxModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
}
