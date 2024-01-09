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
public class chat extends MyModel{
    private int id;
    private String username;
    private String password;
    private String chat;
    private Timestamp created_date;
    private int user_id;
    
    public chat(){
        this.chat = null;
        this.user_id = 0;
    }
    
    public chat(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public chat(String chat, Timestamp created_date, int user_id){
        setChat(chat);
        setCreated_date(created_date);
        setUser_id(user_id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public Timestamp getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Timestamp created_date) {
        this.created_date = created_date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    @Override
    public void insertData() {
        try{
            if(!MyModel.conn.isClosed()){
                PreparedStatement sql = (PreparedStatement) MyModel.conn.prepareStatement(
                "INSERT INTO chat(chat, user_id) VALUES (?, ?)");
                sql.setString(1, this.chat);
                sql.setInt(2, this.user_id);
                sql.executeUpdate();
                sql.close();
            }
        } catch (Exception x){
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
            this.result = this.statement.executeQuery("SELECT * FROM chat");
            while(this.result.next()){
                chat tmpChat = new chat(
                        this.result.getString("chat"),
                        this.result.getTimestamp("created_date"),
                        this.result.getInt("user_id")
                );
                
                collections.add(tmpChat);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        return collections;
    }
    
}
