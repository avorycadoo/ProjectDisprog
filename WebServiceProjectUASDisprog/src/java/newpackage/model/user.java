/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage.model;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author satya
 */
public class user extends MyModel {

    private int id;
    private String username;
    private String password;
    private String email;
    private Timestamp created_date;

    public user() {
        this.username = null;
        this.password = null;
        this.email = null;
    }

    public user(int id, String username, String password, String email) {
        setId(id);
        setUsername(username);
        setPassword(password);
        setEmail(email);
    }

    public user(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    public Timestamp getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Timestamp created_date) {
        this.created_date = created_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<user> checkLogin() {
        ArrayList<user> collections = new ArrayList<>();
        try {
            PreparedStatement sql = MyModel.conn.prepareStatement(
                    "SELECT * FROM user WHERE username = ? AND password = ?");
            sql.setString(1, this.username);
            sql.setString(2, this.password);
            this.result = sql.executeQuery();

            while (this.result.next()) {
                user tmpUser = new user(
                        this.result.getInt("id"),
                        this.result.getString("username"),
                        this.result.getString("password"),
                        this.result.getString("email")
                );

                collections.add(tmpUser);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log or handle the exception appropriately
        }

        return collections;
    }

//    public ArrayList<user> checkLogin() {
//        ArrayList<user> collections = new ArrayList<user>();
//        try {
//            PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
//                    "SELECT * FROM user WHERE username = ? AND password = ?");
//            sql.setString(1, this.username);
//            sql.setString(2, this.password);
//            this.result = sql.executeQuery();
//            while (this.result.next()) {
//                user tmpUser = new user(
//                        this.result.getInt("id"),
//                        this.result.getString("username"),
//                        this.result.getString("password"),
//                        this.result.getString("email")
//                );
//
//                collections.add(tmpUser);
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//
//        return collections;
//    }
    @Override
    public void insertData() {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                        "INSERT INTO user(username, password, email) VALUES (?, ?, ?)");
                sql.setString(1, this.username);
                sql.setString(2, this.password);
                sql.setString(3, this.email);
                sql.executeUpdate();
//                sql.close();
            }
        } catch (Exception x) {
            System.out.println(x.getMessage());
        }
    }

    @Override
    public void updateDate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deleteData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Object> viewListData() {
        ArrayList<Object> collections = new ArrayList<>();
        try {
            PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                    "SELECT * FROM user WHERE username = ? AND password = ?");
            sql.setString(1, this.username);
            sql.setString(2, this.password);
            this.result = sql.executeQuery();
            while (this.result.next()) {
                user tmpUser = new user(
                        this.result.getInt("id"),
                        this.result.getString("username"),
                        this.result.getString("password"),
                        this.result.getString("email")
                );

                collections.add(tmpUser);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return collections;
    }
}
