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
            return "Login successful";
        } else {
            return "Invalid username or password";
        }
    }

}
