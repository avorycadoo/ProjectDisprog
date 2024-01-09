/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectuasdisprog_server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author Valerin
 */
public class HandleSocket extends Thread{

    Socket client;
    DataOutputStream out;
    BufferedReader in;
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
