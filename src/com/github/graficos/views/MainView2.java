package com.github.graficos.views;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class MainView2 extends javax.swing.JFrame {

    private final Connection con;
    private final File[] files;
    private final List<JMenuItem> itens;

    public MainView2(Connection con, File[] files) {
        this.con = con;
        this.files = files;
        this.itens = new ArrayList<>();
        initComponents();

        postInit();

    }

    private void postInit() {

        for (int i = 0; i < files.length; i++) {
            File file = files[i];
            if (file.isDirectory()) {
                JMenu jmenu = new JMenu(file.getName());
                jmenu.setMargin(new Insets(10, 10, 10, 10));
                jmenu.setBorderPainted(true);
                jmenu.updateUI();

                menu.add(jmenu);
                File[] listFiles = file.listFiles();
                for (int j = 0; j < listFiles.length; j++) {
                    File f = listFiles[j];

                    JMenuItem menuIem = new JMenuItem(f.getName().replace(".sql", ""));

                    menuIem.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            ChartPanel p = new ChartPanel(f, con);
                            p.setVisible(true);
                            p.onShow();
                            root.removeAll();
                            root.add(p);
                            p.updateUI();
                        }
                    });
                    menuIem.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseReleased(MouseEvent me) {

                            ChartPanel p = new ChartPanel(f, con);
                            p.setVisible(true);
                            p.onShow();
                            root.removeAll();
                            root.add(p);
                            p.updateUI();
                        }

                    }
                    );
                    jmenu.add(menuIem);
                    itens.add(menuIem);

                }
                jmenu.updateUI();
                menu.updateUI();

            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        root = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        menu = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1000, 650));
        getContentPane().setLayout(new java.awt.CardLayout());

        root.setBackground(new java.awt.Color(255, 255, 255));
        root.setLayout(new java.awt.CardLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Selecione Um Item de Menu");
        root.add(jLabel1, "card2");

        getContentPane().add(root, "card2");

        menu.setBorder(javax.swing.BorderFactory.createMatteBorder(5, 0, 5, 0, new java.awt.Color(153, 153, 255)));
        menu.setPreferredSize(new java.awt.Dimension(0, 50));
        setJMenuBar(menu);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar menu;
    private javax.swing.JPanel root;
    // End of variables declaration//GEN-END:variables

}
