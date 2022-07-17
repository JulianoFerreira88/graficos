    package com.github.graficos.views;

import java.io.File;
import java.sql.Connection;
import javax.swing.JDialog;
import javax.swing.JPanel;

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
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setExtendedState(6);
        setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        setIconImages(null);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1000, 650));
        setSize(getSize());
        setType(java.awt.Window.Type.POPUP);
        getContentPane().setLayout(new java.awt.CardLayout());

        root.setBackground(new java.awt.Color(255, 255, 255));
        root.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        root.setTabPlacement(javax.swing.JTabbedPane.LEFT);
        root.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        root.setPreferredSize(new java.awt.Dimension(750, 550));
        getContentPane().add(root, "card2");

        jMenuBar1.setBackground(new java.awt.Color(0, 0, 51));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 3, 0, new java.awt.Color(153, 153, 255)));
        jMenuBar1.setForeground(new java.awt.Color(0, 0, 51));
        jMenuBar1.setAutoscrolls(true);
        jMenuBar1.setMargin(new java.awt.Insets(5, 10, 5, 10));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(141, 35));

        jMenu1.setBackground(new java.awt.Color(0, 0, 51));
        jMenu1.setBorder(null);
        jMenu1.setText("Consumo Rações Fases");

        jMenuItem1.setText("Creche");
        jMenuItem1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenuItem1MouseReleased(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem2.setText("Terminação");
        jMenuItem2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jMenuItem2MouseReleased(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem1MouseReleased
        showConsumoRacao(new ConsumoRacoesCreche(con));
    }//GEN-LAST:event_jMenuItem1MouseReleased

    private void jMenuItem2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jMenuItem2MouseReleased
        showConsumoRacao(new ConsumoRacoesTerminacao(con));
    }//GEN-LAST:event_jMenuItem2MouseReleased

    private void showConsumoRacao(JPanel panel) {
        panel.setSize(1000, 550);
        panel.setVisible(true);
        JDialog d = new JDialog(this);
        d.add(panel);
        d.setSize(this.getWidth() - 20, this.getHeight() - 10);
        d.setModal(true);
        d.setUndecorated(false);

        d.setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JTabbedPane root;
    // End of variables declaration//GEN-END:variables

}
