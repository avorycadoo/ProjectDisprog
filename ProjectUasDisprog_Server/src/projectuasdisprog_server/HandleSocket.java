/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package projectuasdisprog_server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 *
 * @author Valerin
 */
public class HandleSocket extends Thread {

    FormServer parent;
    Socket client; //menampung client
    DataOutputStream out; //untuk mengirim
    BufferedReader in; //untuk menerima

    public HandleSocket(FormServer parent, Socket client) {
        this.parent = parent;
        this.client = client;

        try {
            out = new DataOutputStream(client.getOutputStream());
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (Exception e) {
            System.out.println("Error di HandleSocket: " + e);
        }
    }

    public void SendChat(String tmp) {
        //untuk mengirimkan pesan
        try {
            out.writeBytes(tmp + "\n");
        } catch (Exception e) {
            System.out.println("Error di SendChat: " + e);
        }
    }

    public void run() {
        try {
            while (true) {
                String tmp = in.readLine(); // Read message from client
                if (tmp != null) {
                    parent.ShowChat(tmp); // Display the received message
                } else {
                    // Handle the situation when the client disconnects or sends an empty message
                    System.out.println("Client disconnected or sent an empty message");
                    break; // Exit the loop
                }
            }
        } catch (Exception e) {
            // Handle any exceptions that occur during message reading
            System.out.println("Error in HandleSocket run: " + e);
            e.printStackTrace(); // Print the stack trace for debugging
        }
    }

}
