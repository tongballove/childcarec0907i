package GUI.Component;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * MyConnection.class uses open/close to connect database according to JDBC type 4.
 * 
 * @author  Nguyen Duc Thang
 */
public class MyConnection {

    /**
     * Method is used to return one connection if connecting successfully.
     * 
     * @return returns one connection.
     * 
     * @exception FileNotFoundException is made if the file isn't found.
     * @exception SQLException is made when there is one error when connecting to database.
     * @exception IOException is made if acessing to stream fails.
     * @exception ClassNotFoundException 
     */
    public static Connection getConnection() {
        //creating ọne stream to read data.
        FileInputStream fis = null;
        try {
            String path = System.getProperty("user.dir")
                    + "/configServer.properties";
            try {
                //open Stream, if a path is not found, Exception will be made.
                fis = new FileInputStream(path);

                Properties prop = new Properties();
                prop.load(fis);

                String server = prop.getProperty("server");
                String port = prop.getProperty("port");
                String database = prop.getProperty("database");
                String password = prop.getProperty("password");
                String username = prop.getProperty("username");

                String url = "jdbc:sqlserver://" + server + ":" + port
                        + ";DatabaseName=" + database;

                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                Connection cn = DriverManager.getConnection(url, username, password);

                fis.close();
                return cn;
            } catch (FileNotFoundException fe) {
                JOptionPane.showMessageDialog(new JFrame(), "Please config server");
                return null;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Connect error", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Connect error", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Connect error", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    /**
     * Method is used to close open objects when connecting to database.
     * 
     * @param obj is object which will be opened when connecting.
     * 
     * @exception SQLException ngoại lệ sinh ra khi kết nối với database theo mô
     * hình JDBC type 4.
     */
    public static void close(Object obj) {
        try {
            if (obj instanceof Connection) {
                ((Connection) obj).close();
            }
            if (obj instanceof Statement) {
                ((Statement) obj).close();
            }
            if (obj instanceof PreparedStatement) {
                ((PreparedStatement) obj).close();
            }

            if (obj instanceof ResultSet) {
                ((ResultSet) obj).close();
            }
        } catch (SQLException se) {
            JOptionPane.showMessageDialog(new JFrame(), "Connect error", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }
}
