/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author sistemas
 */

public class MySQLHelper {
    Connection cn;
    
    public MySQLHelper(){
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cn =  DriverManager.getConnection("jdbc:mysql://172.16.0.90:3306/dbicrperusa","root","ease1701");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    public ResultSet ExecuteDataSet(String SqlQuery){
        try {
            PreparedStatement cmd = cn.prepareStatement(SqlQuery);
            ResultSet dt = cmd.executeQuery();
            return dt;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            return null;
        }
    }
}
