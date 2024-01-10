/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage.model;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 *
 * @author satya
 */
public class post extends MyModel {

    private int id;
    private String judul;
    private String deskripsi;
    private Timestamp created_date;
    private Timestamp updated_date;
    private int user_pembuat;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public post() {
        this.judul = null;
        this.deskripsi = null;
        this.user_pembuat = 0;
    }

    public post(int id, String judul, String deskripsi, int user_pembuat, Timestamp created_date) {
        setId(id);
        setJudul(judul);
        setDeskripsi(deskripsi);
        setUser_pembuat(user_pembuat);
        setCreated_date(created_date);
    }

    public post(String judul, String deskripsi, int user_pembuat) {
        setJudul(judul);
        setDeskripsi(deskripsi);
        setUser_pembuat(user_pembuat);
    }

    public post(int id, String judul, String deskripsi, int user_pembuat) {
        setId(id);
        setJudul(judul);
        setDeskripsi(deskripsi);
        setUser_pembuat(user_pembuat);
    }

    public post(int id, String judul, String deskripsi, int user_pembuat, Timestamp created_date, String username) {
        setId(id);
        setJudul(judul);
        setDeskripsi(deskripsi);
        setUser_pembuat(user_pembuat);
        setCreated_date(created_date);
        setUsername(username);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Timestamp getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Timestamp created_date) {
        this.created_date = created_date;
    }

    public Timestamp getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(Timestamp updated_date) {
        this.updated_date = updated_date;
    }

    public int getUser_pembuat() {
        return user_pembuat;
    }

    public void setUser_pembuat(int user_pembuat) {
        this.user_pembuat = user_pembuat;
    }

    @Override
    public void insertData() {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                        "INSERT INTO post(judul, deskripsi, user_pembuat) VALUES (?, ?, ?)");
                sql.setString(1, this.judul);
                sql.setString(2, this.deskripsi);
                sql.setInt(3, this.user_pembuat);
                sql.executeUpdate();
//                sql.close();
            }
        } catch (Exception x) {
            System.out.println(x.getMessage());
        }
    }

    @Override
    public void updateDate() {
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                        "UPDATE post SET judul = ?, deskripsi = ?, updated_date = now() WHERE user_pembuat = ? AND id = ?;");
                sql.setString(1, this.judul);
                sql.setString(2, this.deskripsi);
                sql.setInt(3, this.user_pembuat);
                sql.setInt(4, this.id);
                sql.executeUpdate();
//                sql.close();
            }
        } catch (Exception x) {
            System.out.println(x.getMessage());
        }
    }

    @Override
    public void deleteData() {
        try {
            if (!MyModel.conn.isClosed()) { //jika tidak tertutup
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement("DELETE FROM user WHERE id = ?");
                sql.setInt(1, id);

                sql.executeUpdate();
                sql.close();
            } //PreparedStatement adalah handling dari java
        } catch (Exception e) {
            System.out.println("Error di delete = " + e);
        }
    }

    @Override
    public ArrayList<Object> viewListData() {
        ArrayList<Object> collections = new ArrayList<>();
        try {
            this.statement = (Statement) MyModel.conn.createStatement();
            this.result = this.statement.executeQuery("SELECT p.*, u.username as username FROM post p inner join user u on p.user_pembuat = u.id");
            while (this.result.next()) {
                post tmpPost = new post(
                        this.result.getInt("id"),
                        this.result.getString("judul"),
                        this.result.getString("deskripsi"),
                        this.result.getInt("user_pembuat"),
                        this.result.getTimestamp("created_date"),
                        this.result.getString("username")
                );

                collections.add(tmpPost);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return collections;
    }

}
