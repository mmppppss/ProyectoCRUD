package proyectocrud.CRUD;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author mmppppss
 */
public class Create extends javax.swing.JFrame {

    public Create() {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Create.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        saveButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        logo = new javax.swing.JLabel();
        titleField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        contenidoArea = new javax.swing.JTextArea();
        authorFiled = new javax.swing.JTextField();
        categoriaList = new javax.swing.JComboBox<>();
        descripcionField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(40, 40, 40));
        jPanel1.setForeground(new java.awt.Color(251, 241, 199));
        jPanel1.setMaximumSize(new java.awt.Dimension(720, 480));
        jPanel1.setMinimumSize(new java.awt.Dimension(720, 480));
        jPanel1.setPreferredSize(new java.awt.Dimension(720, 480));

        saveButton.setBackground(new java.awt.Color(29, 32, 33));
        saveButton.setFont(new java.awt.Font("Source Code Pro", 0, 14)); // NOI18N
        saveButton.setForeground(new java.awt.Color(168, 153, 132));
        saveButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectocrud/assets/save.png"))); // NOI18N
        saveButton.setText("GUARDAR");
        saveButton.setFocusPainted(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        cancelButton.setBackground(new java.awt.Color(29, 32, 33));
        cancelButton.setFont(new java.awt.Font("Source Code Pro", 0, 14)); // NOI18N
        cancelButton.setForeground(new java.awt.Color(168, 153, 132));
        cancelButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectocrud/assets/cancel.png"))); // NOI18N
        cancelButton.setText("CANCELAR");
        cancelButton.setFocusPainted(false);
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        logo.setFont(new java.awt.Font("Source Code Pro Black", 0, 24)); // NOI18N
        logo.setForeground(new java.awt.Color(235, 219, 178));
        logo.setText("Informatica Blog Dashboard");

        titleField.setBackground(new java.awt.Color(60, 56, 54));
        titleField.setFont(new java.awt.Font("Source Code Pro", 0, 14)); // NOI18N
        titleField.setForeground(getForeground());
        titleField.setToolTipText("Titulo del Articulo");

        contenidoArea.setBackground(new java.awt.Color(60, 56, 54));
        contenidoArea.setColumns(20);
        contenidoArea.setForeground(getForeground());
        contenidoArea.setRows(5);
        contenidoArea.setDisabledTextColor(contenidoArea.getForeground());
        contenidoArea.setPreferredSize(new java.awt.Dimension(272, 100));
        jScrollPane1.setViewportView(contenidoArea);

        authorFiled.setBackground(new java.awt.Color(60, 56, 54));
        authorFiled.setFont(new java.awt.Font("Source Code Pro", 0, 14)); // NOI18N
        authorFiled.setForeground(getForeground());
        authorFiled.setToolTipText("Titulo del Articulo");

        categoriaList.setBackground(new java.awt.Color(60, 56, 54));
        categoriaList.setForeground(getForeground());
        categoriaList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Programacion", "Hacking", "Noticias", "Otros" }));
        categoriaList.setPreferredSize(new java.awt.Dimension(129, 24));

        descripcionField.setBackground(new java.awt.Color(60, 56, 54));
        descripcionField.setFont(new java.awt.Font("Source Code Pro", 0, 14)); // NOI18N
        descripcionField.setForeground(getForeground());
        descripcionField.setToolTipText("Titulo del Articulo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(titleField)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(logo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                                .addComponent(cancelButton)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(categoriaList, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(authorFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(descripcionField)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(logo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(categoriaList, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(authorFiled, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(descripcionField, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Create.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Create().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField authorFiled;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> categoriaList;
    private javax.swing.JTextArea contenidoArea;
    private javax.swing.JTextField descripcionField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logo;
    private javax.swing.JButton saveButton;
    private javax.swing.JTextField titleField;
    // End of variables declaration//GEN-END:variables
}
