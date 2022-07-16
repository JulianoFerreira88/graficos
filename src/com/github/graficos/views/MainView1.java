package com.github.graficos.views;

import java.io.File;
import java.sql.Connection;

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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1000, 550));
        setSize(getSize());
        getContentPane().setLayout(new java.awt.CardLayout());

        root.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        root.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        root.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        root.setPreferredSize(new java.awt.Dimension(750, 550));
        getContentPane().add(root, "card2");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane root;
    // End of variables declaration//GEN-END:variables
}
