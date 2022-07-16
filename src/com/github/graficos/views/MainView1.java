package com.github.graficos.views;

import java.awt.Component;
import java.io.File;
import java.sql.Connection;
import javax.swing.JDialog;

public class MainView1 extends javax.swing.JFrame {

    private final Connection con;
    private final File[] files;

    public MainView1(Connection con, File[] files) {
        this.con = con;
        this.files = files;

        initComponents();
        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            ChartPanel panel = new ChartPanel(file, con);
            panel.setVisible(true);

            root.addTab(file.getName().replace(".sql", ""), panel);

        }
        root.updateUI();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        root = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 650));
        setResizable(false);
        setSize(getSize());
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new java.awt.CardLayout());

        root.setBackground(new java.awt.Color(255, 255, 255));
        root.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        root.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        root.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        root.setPreferredSize(new java.awt.Dimension(750, 550));
        getContentPane().add(root, "card2");

        jMenuBar1.setBorder(null);
        jMenuBar1.setPreferredSize(new java.awt.Dimension(141, 50));

        jMenu1.setBorder(null);
        jMenu1.setText("Consumo Rações Creche");
        jMenu1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMenu1MouseClicked(evt);
            }
        });
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed

    }//GEN-LAST:event_jMenu1ActionPerformed

    private void jMenu1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenu1MouseClicked
        showComponent(new ConsumoRacoesCreche(con));
    }//GEN-LAST:event_jMenu1MouseClicked

    private void showComponent(Component frame) {
        frame.setSize(1000, 550);
        frame.setVisible(true);
        JDialog d = new JDialog(this);
        d.add(frame);
        d.setSize(1000, 550);
        d.setModal(true);
        d.setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JTabbedPane root;
    // End of variables declaration//GEN-END:variables
}
