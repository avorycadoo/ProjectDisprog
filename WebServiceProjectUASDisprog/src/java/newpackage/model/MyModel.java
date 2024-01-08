/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author satya
 */
public abstract class MyModel {
    protected static Connection conn;
    protected Statement statement;
    protected ResultSet result;
    
    public MyModel() {
        this.conn = this._getConnection();
        this.statement = null;
        this.result = null;
    }
    
    public Connection _getConnection() {
        if(MyModel.conn == null){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
                return DriverManager.getConnection("jdbc:mysql://localhost/disprog_uas", "root", "");
            } catch (Exception ex) {
                Logger.getLogger(MyModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return MyModel.conn;
    }
    
    public abstract void insertData();
    public abstract void updateDate();
    public abstract void deleteData();
    public abstract ArrayList<Object> viewListData();

}
