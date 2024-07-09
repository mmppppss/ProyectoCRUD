package proyectocrud.CRUD;

import java.awt.FlowLayout;
import javax.swing.*;
import DB.APIDB;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author mmppppss
 */
public class ReadList extends javax.swing.JFrame {

    /**
     * Creates new form Read
     */
    APIDB api;
    public ReadList(APIDB databaseAPI) {
        this.setResizable(false);
        api = databaseAPI;
        initComponents();
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Create.class.getName()).log(Level.SEVERE, null, ex);
        }
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        BoxLayout a  = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
        mainPanel.setLayout(a);
        addButton.setVisible((boolean)api.getUser()[1]);
        makelist();
        setLocationRelativeTo(null);
    }
    private void makelist(){
        var list = api.getArts();
        for (String[] tupla : list) {
            if(tupla[0]!=null){
                addArticlePanel(tupla[0], tupla[1], tupla[5], tupla[6]);
            }
           
        }
    }
    private void addArticlePanel(String id, String title, String views, String cat) {
        System.out.println("add "+title);
        JPanel articlePanel = new JPanel();
        articlePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        articlePanel.setSize(655, 46);
        articlePanel.setPreferredSize(articlePanel.getSize());
        articlePanel.setMinimumSize(articlePanel.getSize());
        articlePanel.setMaximumSize(articlePanel.getSize());
        articlePanel.setBackground(new java.awt.Color(80, 73, 69));
        if(title.length()>30)
            title=title.substring(0, 30);
        JLabel titleLabel = new JLabel(title+" | ");
        titleLabel.setSize(100, 40);
        titleLabel.setForeground(new java.awt.Color(235, 219, 178));
        articlePanel.add(titleLabel);
        articlePanel.add(new JLabel(cat.replaceAll(" ", "")+" | "));
        JLabel view = new JLabel(views+" | ");
        view.setForeground(new java.awt.Color(235, 219, 178));
        //view.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectocrud/assets/view.png")));
        view.setSize(1000, HEIGHT);
        articlePanel.add(view);
        JButton viewButton = new JButton("VER");
        JButton editButton = new JButton("EDITAR");
        JButton deleteButton = new JButton("BORRAR");

        viewButton.setBackground(new java.awt.Color(29, 32, 33));
        viewButton.setFont(new java.awt.Font("Source Code Pro", 0, 14)); // NOI18N
        viewButton.setForeground(new java.awt.Color(168, 153, 132));
        viewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectocrud/assets/view.png"))); // NOI18N
        viewButton.setFocusPainted(false);
        viewButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            new Read(api, id).setVisible(true);
            this.dispose();
        });
        editButton.setBackground(new java.awt.Color(29, 32, 33));//1D2021
        editButton.setFont(new java.awt.Font("Source Code Pro", 0, 14)); // NOI18N
        editButton.setForeground(new java.awt.Color(168, 153, 132));
        editButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectocrud/assets/edit.png"))); // NOI18N
        editButton.setText("EDITAR");
        editButton.setFocusPainted(false);
        editButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            Create edit = new Create(api);
            edit.edit(id);
            edit.setVisible(true);
            this.dispose();
        });
        deleteButton.setBackground(new java.awt.Color(29, 32, 33));
        deleteButton.setFont(new java.awt.Font("Source Code Pro", 0, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(168, 153, 132));
        deleteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectocrud/assets/delete.png"))); // NOI18N
        deleteButton.setText("BORRAR");
        deleteButton.setFocusPainted(false);
        deleteButton.addActionListener((java.awt.event.ActionEvent evt) -> {
            new Delete( api,id ,this, rootPaneCheckingEnabled).setVisible(true);
            System.out.println("delete");
            this.dispose();
            new ReadList(api).setVisible(true);
        });
        boolean admin = (boolean) api.getUser()[1];
        if(admin){
            articlePanel.add(editButton);
            articlePanel.add(deleteButton);
        }
        articlePanel.add(viewButton);
        mainPanel.add(articlePanel);
        mainPanel.add(Box.createVerticalStrut(15)); // Adding vertical space between panels
        mainPanel.revalidate();
        mainPanel.repaint();
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
        logo = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        scrollPanel = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(40, 40, 40));
        jPanel1.setForeground(new java.awt.Color(251, 241, 199));
        jPanel1.setMaximumSize(new java.awt.Dimension(720, 480));
        jPanel1.setMinimumSize(new java.awt.Dimension(720, 480));
        jPanel1.setPreferredSize(new java.awt.Dimension(720, 480));

        logo.setFont(new java.awt.Font("Source Code Pro Black", 0, 24)); // NOI18N
        logo.setForeground(new java.awt.Color(235, 219, 178));
        logo.setText("Informatica Blog Dashboard");

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

        scrollPanel.setBackground(new java.awt.Color(60, 56, 54));
        scrollPanel.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPanel.setPreferredSize(new java.awt.Dimension(680, 640));

        mainPanel.setBackground(new java.awt.Color(60, 56, 54));
        mainPanel.setMaximumSize(new java.awt.Dimension(670, 1970));
        mainPanel.setMinimumSize(new java.awt.Dimension(670, 50));
        mainPanel.setPreferredSize(new java.awt.Dimension(670, 1970));
        scrollPanel.setViewportView(mainPanel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(scrollPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(logo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(addButton)))
                .addGap(20, 20, 20))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logo)
                    .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrollPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 480, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        Create c = new Create(api);
        c.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_addButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ReadList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReadList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReadList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReadList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReadList(new APIDB()).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel logo;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane scrollPanel;
    // End of variables declaration//GEN-END:variables
}