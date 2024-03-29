/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Timeline;

import BuatPost.BuatPost;
import Chat.Chat;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import newpackage.model.post;
import DetailPost.DetailPost;
import UbahPost.UbahPost;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import DashboardProfil.FormDashboardProfil;

/**
 *
 * @author Valerin
 */
public class FormTimeline extends javax.swing.JFrame {

    post p;

    /**
     * Creates new form FormTimeline
     */
    public FormTimeline(String id) {

        initComponents();

        ids = id.split("-");
        idu = ids[0];
        username = ids[1];
        refresh();

    }

    static String idu;
    static String username;
    String[] ids;
    int idPost = 0;

//    private void Timeline() {
//        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
//        setTitle("Timeline");
//        // Inisialisasi komponen utama
//        JPanel panelPosts = new JPanel();
//        panelPosts.setLayout(new BoxLayout(panelPosts, BoxLayout.Y_AXIS));
//        // Ambil data postingan dari database
//        ArrayList<String> daftarPostingan = ambilDataPostinganDariDatabase();
//        // Tampilkan data postingan dalam JLabel di dalam JPanel
//        for (String postingan : daftarPostingan) {
//            JLabel labelPostingan = new JLabel(postingan);
//            panelPosts.add(labelPostingan);
//        }
//        // Masukkan panelPosts ke dalam JScrollPane
//        JScrollPane scrollPane = new JScrollPane(panelPosts);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        // Tambahkan JScrollPane ke dalam JFrame
//        getContentPane().add(scrollPane);
//        pack();
//    }
    public void refresh() {
        DefaultTableModel model = (DefaultTableModel) tablePost.getModel();
        model.setRowCount(0);
        String[] rowData = new String[7];
        List<String> listPost = viewListPost();
        int listLike = 0;

//        String komen = "";
        for (String obj : listPost) {
            String[] arr = obj.split("///");
            rowData[0] = arr[0];
            rowData[1] = arr[5]; //int           
            rowData[2] = arr[2];
            rowData[3] = arr[3];
            rowData[4] = arr[4];
            rowData[5] = likePost(Integer.parseInt(arr[0]));
            rowData[6]= replyPost(Integer.parseInt(arr[0]));

            model.addRow(rowData);
        }
//        txtKomenArea.setText(komen);
    }

    // Metode untuk mengambil data postingan dari database (contoh sederhana)
//    private ArrayList<String> ambilDataPostinganDariDatabase() {
//        ArrayList<String> daftarPostingan = new ArrayList<>();
//        // Anda perlu menyesuaikan ini dengan koneksi dan query ke database yang Anda gunakan
//        try {
//
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/nama_database", "username", "password");
//            Statement stmt = conn.createStatement();
//            ResultSet rs = stmt.executeQuery("SELECT isi_postingan FROM tabel_postingan");
//            while (rs.next()) {
//                String isiPostingan = rs.getString("isi_postingan");
//                daftarPostingan.add(isiPostingan);
//            }
//
//            conn.close();
//        } catch (Exception e) {
//            Logger.getLogger(FormTimeline.class.getName()).log(Level.SEVERE, null, e);
//        }
//        return daftarPostingan;
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        btnCreate = new javax.swing.JButton();
        btnLike = new javax.swing.JButton();
        btnDetail = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePost = new javax.swing.JTable();
        btnRefresh = new javax.swing.JButton();
        btnChat = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Form Timeline");
        jLabel7.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(248, 248, 248))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        btnCreate.setText("Create Post");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnLike.setText("Like");
        btnLike.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLikeActionPerformed(evt);
            }
        });

        btnDetail.setText("Detail");
        btnDetail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetailActionPerformed(evt);
            }
        });

        tablePost.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Creator", "Judul", "Deskripsi", "Created Date", "Jumlah Like", "Jumlah Reply"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablePost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablePostMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablePost);

        btnRefresh.setText("Refresh Post");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnChat.setText("Chat");
        btnChat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChatActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update Post");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnChat)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnUpdate)
                        .addGap(12, 12, 12)
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCreate))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 584, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnLike, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDetail, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreate)
                            .addComponent(btnRefresh)
                            .addComponent(btnChat)
                            .addComponent(btnUpdate)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(btnLike)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnDetail)))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        // TODO add your handling code here:

        BuatPost create = new BuatPost(idu);
        create.setVisible(true);
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnLikeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLikeActionPerformed
        // TODO add your handling code here:

        if (idPost == 0) {
            JOptionPane.showMessageDialog(this, "Select post first.");
        } else {
            addLike(Integer.parseInt(idu), idPost);
            JOptionPane.showMessageDialog(this, "Hell yea.");
        }
    }//GEN-LAST:event_btnLikeActionPerformed

    private void btnDetailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetailActionPerformed
        // TODO add your handling code here:
        DetailPost detailPost = new DetailPost(idPost, Integer.parseInt(idu));
        detailPost.setVisible(true);
    }//GEN-LAST:event_btnDetailActionPerformed

    private void tablePostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablePostMouseClicked
        // TODO add your handling code here:
        JTable target = (JTable) evt.getSource();

        int col = target.getSelectedColumn();
        int row = target.getSelectedRow();
        idPost = Integer.parseInt(target.getValueAt(row, 0).toString());

        if (col == 1) {
//            int row2 = target.getSelectedRow();
//            idu = target.getValueAt(col, 0).toString();
            FormDashboardProfil fdp = new FormDashboardProfil(target.getValueAt(row, 1).toString());
            fdp.setVisible(true);
        }
//        
    }//GEN-LAST:event_tablePostMouseClicked

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        // TODO add your handling code here:
        refresh();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnChatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChatActionPerformed
        Chat formChat = new Chat(username);
        formChat.setVisible(true);
    }//GEN-LAST:event_btnChatActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        UbahPost formUbah = new UbahPost(idPost, Integer.parseInt(idu));
        formUbah.setVisible(true);
    }//GEN-LAST:event_btnUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(FormTimeline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTimeline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTimeline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTimeline.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTimeline(idu).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChat;
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnDetail;
    private javax.swing.JButton btnLike;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablePost;
    // End of variables declaration//GEN-END:variables

    private static java.util.List<java.lang.String> viewListPost() {
        newpackage.model.WebServiceServer_Service service = new newpackage.model.WebServiceServer_Service();
        newpackage.model.WebServiceServer port = service.getWebServiceServerPort();
        return port.viewListPost();
    }

    private static Boolean addLike(int userId, int postId) {
        newpackage.model.WebServiceServer_Service service = new newpackage.model.WebServiceServer_Service();
        newpackage.model.WebServiceServer port = service.getWebServiceServerPort();
        return port.addLike(userId, postId);
    }

    private static String likePost(int postId) {
        newpackage.model.WebServiceServer_Service service = new newpackage.model.WebServiceServer_Service();
        newpackage.model.WebServiceServer port = service.getWebServiceServerPort();
        return port.likePost(postId);
    }

    private static String replyPost(int postId) {
        newpackage.model.WebServiceServer_Service service = new newpackage.model.WebServiceServer_Service();
        newpackage.model.WebServiceServer port = service.getWebServiceServerPort();
        return port.replyPost(postId);
    }

}
