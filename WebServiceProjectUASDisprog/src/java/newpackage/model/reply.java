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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    private String username;
    private int post_id;
    private String reply;
    
    public reply(){
        this.username = null;
        this.post_id = 0;
        this.reply = null;
    }
    
    public reply(String username, int post_id, String reply){
        setUsername(username);
        setPost_id(post_id);
        setReply(reply);
    }
    
    public reply(int post_id){
        setPost_id(post_id);
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
                    "SELECT u.username as username, r.post_id, r.reply FROM reply r INNER JOIN user u ON r.user_id = u.id  WHERE post_id = ?");
            sql.setInt(1, this.post_id);
            this.result = sql.executeQuery();

            while (this.result.next()) {
                reply tmpReply = new reply(
                        this.result.getString("username"),
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
