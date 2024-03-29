/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Chat;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Valerin
 */
public class Chat extends javax.swing.JFrame implements Runnable {

    public String usernameLogin;
    Socket clientSocket;
    Thread t;
    static String user;

    /**
     * Creates new form Chat
     */
    public Chat(String username) {
        try {
            System.out.println("Initializing Chat");
            initComponents();
            user = username;

            clientSocket = new Socket("localhost", 6000);

            if (clientSocket != null && !clientSocket.isClosed()) {
                System.out.println("Socket initialized successfully");
            } else {
                System.out.println("Socket initialization failed");
            }

            if (t == null) {
                t = new Thread(this, "client");
                t.start();
            }
        } catch (IOException ex) {
            ex.printStackTrace(); // Print the exception stack trace for debugging
            Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

//    public void listAcc() {
//        String res = viewListAccount("", "");
//        res = res.substring(1);
//        res = res.replace("]", "");
//        String[] splitRes = res.split(", ");
//
//        cmbDaftarAcc.removeAllItems(); // Clear existing items before adding new ones
//
//        for (String acc : splitRes) {
//            String[] i = acc.split("-");
//            String username = i[2];
//            cmbDaftarAcc.addItem(username);
//        }
//        cmbDaftarAcc.removeItem(user); // Assuming this is the logged-in user's username
//    }

    public void run() {
        while (true) {
            try {
                getMessage();
            } catch (IOException x) {
                Logger.getLogger(Chat.class.getName()).log(Level.SEVERE, null, x);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtHistory = new javax.swing.JTextArea();
        txtChat = new javax.swing.JTextField();
        btnReply = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Form Chat");
        jLabel1.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(280, 280, 280)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        txtHistory.setColumns(20);
        txtHistory.setRows(5);
        jScrollPane1.setViewportView(txtHistory);

        btnReply.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnReply.setText("Reply");
        btnReply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReplyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 688, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtChat, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReply)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtChat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReply))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReplyActionPerformed
        try {
            if (clientSocket != null) {
                String chatClient, chatServer;
                String chat = txtChat.getText();

                chatClient = user + ": " + chat; //ambil pesan di textField
                DataOutputStream sendToServer = new DataOutputStream(clientSocket.getOutputStream()); //menyiapkan objek berisi data server
                sendToServer.writeBytes(chatClient + "\n"); //pengiriman pesan ke server
                
            } else {
                System.out.println("clientSocket is null");
            }

        } catch (Exception e) {
            System.out.println("Error btnSend : " + e);
        }
    }//GEN-LAST:event_btnReplyActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Chat.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Chat(user).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReply;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtChat;
    private javax.swing.JTextArea txtHistory;
    // End of variables declaration//GEN-END:variables

    private void getMessage() throws IOException {
        String chatServer;
        BufferedReader chatFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        chatServer = chatFromServer.readLine(); //membaca pesan dari server

        String[] cek = chatServer.split(":");

        txtHistory.append(chatServer + "\n"); //pesan taruh di textArea

    }

    private static String viewListAccount(java.lang.String username, java.lang.String password) {
        newpackage.model.WebServiceServer_Service service = new newpackage.model.WebServiceServer_Service();
        newpackage.model.WebServiceServer port = service.getWebServiceServerPort();
        return port.viewListAccount(username, password);
    }

}
