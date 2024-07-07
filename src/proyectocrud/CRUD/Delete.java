/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package proyectocrud.CRUD;

import DB.APIDB;

/**
 *
 * @author mmppppss
 */
public class Delete extends javax.swing.JDialog {

    /**
     * Creates new form del
     */
    String id;
    APIDB api;
    public Delete(APIDB databaseAPI, String idART, java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        api=databaseAPI;
        id=idART;
        initComponents();
        String title=api.read(idART)[1];
        if(title.length()>30)
            title=title.substring(0, 30);
        artTitle.setText(title);
        this.setAlwaysOnTop(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cancelButton = new javax.swing.JButton();
        deleteConfirmButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        artTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setAlwaysOnTop(true);
        setBackground(new java.awt.Color(40, 40, 40));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        cancelButton.setBackground(new java.awt.Color(29, 32, 33));
        cancelButton.setFont(new java.awt.Font("Source Code Pro", 0, 18)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(168, 153, 132));
        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectocrud/assets/cancel.png"))); // NOI18N
        cancelButton.setText("CANCELAR");
        cancelButton.setFocusPainted(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        deleteConfirmButton.setBackground(new java.awt.Color(29, 32, 33));
        deleteConfirmButton.setFont(new java.awt.Font("Source Code Pro", 0, 18)); // NOI18N
        deleteConfirmButton.setForeground(new java.awt.Color(251, 73, 52));
        deleteConfirmButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectocrud/assets/delete.png"))); // NOI18N
        deleteConfirmButton.setText("BORRAR");
        deleteConfirmButton.setFocusPainted(false);
        deleteConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteConfirmButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Source Code Pro Black", 0, 18)); // NOI18N
        jLabel1.setText("Confirme el borrado del articulo");

        artTitle.setFont(new java.awt.Font("Source Code Pro", 0, 14)); // NOI18N
        artTitle.setForeground(new java.awt.Color(235, 219, 178));
        artTitle.setText("artNAME");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(cancelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(deleteConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(171, 171, 171)
                        .addComponent(artTitle)))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(artTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteConfirmButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void deleteConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteConfirmButtonActionPerformed
        api.delete(id);
        this.dispose();
    }//GEN-LAST:event_deleteConfirmButtonActionPerformed

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
            java.util.logging.Logger.getLogger(Delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Delete.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Delete dialog = new Delete( null, null, new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel artTitle;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton deleteConfirmButton;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
