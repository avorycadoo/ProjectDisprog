/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package newpackage.model;

import java.sql.PreparedStatement;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class reply extends MyModel{
    private int user_id;
    private int post_id;
    private String reply;
    
    public reply(){
        this.user_id = 0;
        this.post_id = 0;
        this.reply = null;
    }
    
    public reply(int user_id, int post_id, String reply){
        setUser_id(user_id);
        setPost_id(post_id);
        setReply(reply);
    }

    /**
     * @return the user_id
     */
    public int getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the post_id
     */
    public int getPost_id() {
        return post_id;
    }

    /**
     * @param post_id the post_id to set
     */
    public void setPost_id(int post_id) {
        this.post_id = post_id;
    }

    /**
     * @return the reply
     */
    public String getReply() {
        return reply;
    }

    /**
     * @param reply the reply to set
     */
    public void setReply(String reply) {
        this.reply = reply;
    }

    @Override
    public void insertData() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
            PreparedStatement sql = MyModel.conn.prepareStatement(
                    "SELECT * FROM reply WHERE post_id = ?");
            sql.setInt(1, this.post_id);
            this.result = sql.executeQuery();

            while (this.result.next()) {
                reply tmpReply = new reply(
                        this.result.getInt("user_id"),
                        this.result.getInt("post_id"),
                        this.result.getString("reply")
                );

                collections.add(tmpReply);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Log or handle the exception appropriately
        }

        return collections;
    }
    
}
