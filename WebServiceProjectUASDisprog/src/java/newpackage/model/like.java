/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage.model;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author ABED
 */
public class like extends MyModel {

    private int user_id;
    private int post_id;

    public like(int user_id, int post_id) {
        setUser_id(user_id);
        setPost_id(post_id);
    }

    public like(int user_id) {
        setUser_id(user_id);
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getPost_id() {
        return post_id;
    }

    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    @Override
    public void insertData() {
        try {
            ArrayList<Object> listLike = viewListData();
            int help = 0;
            for (Object obj : listLike) {
                if (obj instanceof like) {
                    like likes = ((like) obj);
                    if (likes.getUser_id() == this.user_id && likes.getPost_id() == this.post_id) {
                        help = 1;
                    }
                }
            }

            if (help == 0) {
                if (!MyModel.conn.isClosed()) {
                    PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                            "INSERT INTO `like`(user_id, post_id) VALUES (?, ?)");
                    sql.setInt(1, this.user_id);
                    sql.setInt(2, this.post_id);
                    sql.executeUpdate();
                    //                sql.close();
                }
            } else {
                System.out.println("eror hehehehee");
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
            this.statement = (Statement) MyModel.conn.createStatement();
            this.result = this.statement.executeQuery("SELECT * FROM like");
            while (this.result.next()) {
                like tmpLike = new like(
                        this.result.getInt("user_id"),
                        this.result.getInt("post_id")
                );

                collections.add(tmpLike);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return collections;
    }

    public int likePost() {
        int jumlah = 0;
        try {
            if (!MyModel.conn.isClosed()) {
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                        "SELECT COUNT(user_id) as jumlah FROM `like` where post_id = ?");
                sql.setInt(1, this.post_id);
                this.result = sql.executeQuery();
                while (this.result.next()) {
                
                jumlah =  this.result.getInt("jumlah");
//                sql.close();
                }
            }
        } catch (Exception x) {
            System.out.println(x.getMessage());
        }
        return jumlah;
    }

}
