/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package newpackage.model;

import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author satya
 */
@WebService(serviceName = "WebServiceServer")
public class WebServiceServer {

    user user;
    reply reply;
    post p;
    ArrayList<Object> listofuser;

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        user = new user(username, password);
        ArrayList<user> userList = user.checkLogin(); // Assuming checkLogin() returns an ArrayList<user>

        // Check if the userList contains any users
        if (!userList.isEmpty()) {
            String stringUser = "";
            for(Object obj: userList){
                if(obj instanceof user){

                    user r = ((user) obj);
    //                reply newr = new reply(r.getUser_id(), r.getPost_id(), r.getReply());
    //                listReply.add(newr);
                    stringUser = r.getId()+ "-" + r.getUsername()+ "-" + r.getEmail();

                }
            }
            return stringUser;
        } else {
            return null;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "registrasi")
    public void registrasi(@WebParam(name = "username") String username, @WebParam(name = "password") String password, @WebParam(name = "email") String email) {
        //TODO write your implementation code here:
        user = new user(username, password, email);
        user.insertData();
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "viewListAccount")
    public String viewListAccount(@WebParam(name = "username") String username, @WebParam(name = "password") String password) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getChat")
    public ArrayList<String> getChat(@WebParam(name = "idPost") int idPost) {
        //TODO write your implementation code here:
        reply = new reply(idPost);
        ArrayList<Object> list = reply.viewListData();
        ArrayList<String> listReply = new ArrayList<>();
        
        
        for(Object obj: list){
            if(obj instanceof reply){
                
                reply r = ((reply) obj);
//                reply newr = new reply(r.getUser_id(), r.getPost_id(), r.getReply());
//                listReply.add(newr);
                listReply.add(r.getUsername() + "-" + r.getPost_id() + "-" + r.getReply());
                
            }
        }
        return listReply;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addReply")
    public Boolean addReply(@WebParam(name = "user_id") int user_id, @WebParam(name = "post_id") int post_id, @WebParam(name = "reply") String reply) {
        //TODO write your implementation code here:
        this.reply = new reply(user_id, post_id, reply);
        this.reply.insertData();
        return true;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addPost")
    public Boolean addPost(@WebParam(name = "judul") String judul, @WebParam(name = "deskripsi") String deskripsi, @WebParam(name = "user_pembuat") int user_pembuat) {
        //TODO write your implementation code here:
        p = new post(judul, deskripsi, user_pembuat);
        p.insertData();
        return true;
    }

    

    

}
