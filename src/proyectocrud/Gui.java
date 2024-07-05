package proyectocrud;

import DB.APIDB;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import proyectocrud.CRUD.*;

public class Gui extends javax.swing.JFrame {
    APIDB api;
    public Gui(APIDB databaseAPI) {
        this.api=databaseAPI;
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Gui.class.getName()).log(Level.SEVERE, null, ex);
        }

        initComponents();
        setResizable(false);
        logged();
        stats();
    }
    private void logged(){
        boolean admin = (boolean) api.getUser()[1];
        addButton.setVisible(admin);
        
    }
    private void stats(){
        String[] stat = api.stats();
        viewStat.setText(stat[0]);
        commentStat.setText(stat[1]);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        logo = new javax.swing.JLabel();
        statsPanel = new javax.swing.JPanel();
        viewStat = new javax.swing.JLabel();
        commentStat = new javax.swing.JLabel();
        logo1 = new javax.swing.JLabel();
        msgPanel = new javax.swing.JPanel();
        topPanel = new javax.swing.JPanel();
        loginButton = new javax.swing.JButton();
        addButton = new javax.swing.JButton();
        listButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(28, 28, 28));
        setMaximumSize(getPreferredSize());
        setMinimumSize(getPreferredSize());
        setSize(getPreferredSize());

        mainPanel.setBackground(new java.awt.Color(40, 40, 40));
        mainPanel.setMaximumSize(new java.awt.Dimension(720, 480));
        mainPanel.setMinimumSize(new java.awt.Dimension(720, 480));
        mainPanel.setPreferredSize(new java.awt.Dimension(720, 480));
        mainPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logo.setFont(new java.awt.Font("Source Code Pro Black", 0, 24)); // NOI18N
        logo.setForeground(new java.awt.Color(235, 219, 178));
        logo.setText("Informatica Blog");
        mainPanel.add(logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        statsPanel.setBackground(new java.awt.Color(60, 56, 54));
        statsPanel.setForeground(new java.awt.Color(29, 32, 33));
        statsPanel.setPreferredSize(new java.awt.Dimension(680, 130));

        viewStat.setFont(new java.awt.Font("Source Code Pro Black", 0, 24)); // NOI18N
        viewStat.setForeground(new java.awt.Color(235, 219, 178));
        viewStat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectocrud/assets/view.png"))); // NOI18N
        viewStat.setText("NNN");

        commentStat.setFont(new java.awt.Font("Source Code Pro Black", 0, 24)); // NOI18N
        commentStat.setForeground(new java.awt.Color(235, 219, 178));
        commentStat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectocrud/assets/comment.png"))); // NOI18N
        commentStat.setText("NNN");

        logo1.setFont(new java.awt.Font("Source Code Pro Black", 0, 24)); // NOI18N
        logo1.setForeground(new java.awt.Color(235, 219, 178));
        logo1.setText("Estadisticas");

        javax.swing.GroupLayout statsPanelLayout = new javax.swing.GroupLayout(statsPanel);
        statsPanel.setLayout(statsPanelLayout);
        statsPanelLayout.setHorizontalGroup(
            statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statsPanelLayout.createSequentialGroup()
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(statsPanelLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(viewStat, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(commentStat, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(statsPanelLayout.createSequentialGroup()
                        .addGap(256, 256, 256)
                        .addComponent(logo1)))
                .addContainerGap(256, Short.MAX_VALUE))
        );
        statsPanelLayout.setVerticalGroup(
            statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(statsPanelLayout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(logo1)
                .addGap(18, 18, 18)
                .addGroup(statsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(commentStat)
                    .addComponent(viewStat))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        mainPanel.add(statsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 71, -1, -1));

        msgPanel.setBackground(new java.awt.Color(60, 56, 54));
        msgPanel.setForeground(new java.awt.Color(29, 32, 33));
        msgPanel.setPreferredSize(new java.awt.Dimension(330, 240));

        javax.swing.GroupLayout msgPanelLayout = new javax.swing.GroupLayout(msgPanel);
        msgPanel.setLayout(msgPanelLayout);
        msgPanelLayout.setHorizontalGroup(
            msgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        msgPanelLayout.setVerticalGroup(
            msgPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        mainPanel.add(msgPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 221, -1, -1));
        msgPanel.getAccessibleContext().setAccessibleName("");

        topPanel.setBackground(new java.awt.Color(60, 56, 54));
        topPanel.setForeground(new java.awt.Color(29, 32, 33));
        topPanel.setPreferredSize(new java.awt.Dimension(330, 240));

        javax.swing.GroupLayout topPanelLayout = new javax.swing.GroupLayout(topPanel);
        topPanel.setLayout(topPanelLayout);
        topPanelLayout.setHorizontalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        topPanelLayout.setVerticalGroup(
            topPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        mainPanel.add(topPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 221, -1, -1));

        loginButton.setBackground(new java.awt.Color(29, 32, 33));
        loginButton.setFont(new java.awt.Font("Source Code Pro", 0, 14)); // NOI18N
        loginButton.setForeground(new java.awt.Color(168, 153, 132));
        loginButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectocrud/assets/icon_user.png"))); // NOI18N
        loginButton.setText("Login");
        loginButton.setFocusPainted(false);
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });
        mainPanel.add(loginButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, -1, 30));

        addButton.setBackground(new java.awt.Color(29, 32, 33));
        addButton.setFont(new java.awt.Font("Source Code Pro", 0, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(168, 153, 132));
        addButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectocrud/assets/create.png"))); // NOI18N
        addButton.setText("CREATE NEW");
        addButton.setFocusPainted(false);
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });
        mainPanel.add(addButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, -1, 30));

        listButton.setBackground(new java.awt.Color(29, 32, 33));
        listButton.setFont(new java.awt.Font("Source Code Pro", 0, 14)); // NOI18N
        listButton.setForeground(new java.awt.Color(168, 153, 132));
        listButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectocrud/assets/list.png"))); // NOI18N
        listButton.setText("ARTICULOS");
        listButton.setFocusPainted(false);
        listButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listButtonActionPerformed(evt);
            }
        });
        mainPanel.add(listButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, -1, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        this.dispose();
        new Login(api, this, rootPaneCheckingEnabled).setVisible(true);
    }//GEN-LAST:event_loginButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        Create c = new Create(api);
        c.setVisible(true);
    }//GEN-LAST:event_addButtonActionPerformed

    private void listButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listButtonActionPerformed
        ReadList r = new ReadList(api);
        r.setVisible(true);
    }//GEN-LAST:event_listButtonActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Createold and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Gui(new APIDB()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JLabel commentStat;
    private javax.swing.JButton listButton;
    private javax.swing.JButton loginButton;
    private javax.swing.JLabel logo;
    private javax.swing.JLabel logo1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JPanel msgPanel;
    private javax.swing.JPanel statsPanel;
    private javax.swing.JPanel topPanel;
    private javax.swing.JLabel viewStat;
    // End of variables declaration//GEN-END:variables
}
