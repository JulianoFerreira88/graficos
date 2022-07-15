package com.github.graficos.views;

import com.github.graficos.utils.FileToString;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import org.jfree.data.jdbc.JDBCCategoryDataset;

public class MainView extends javax.swing.JFrame {

    private final Connection con;
    private final File[] files;
    private long time;
    private int count = 0;

    public MainView(Connection con, File[] files) {
        this.con = con;
        this.files = files;
        initComponents();

    }

    public void execute(long time) {
        this.time = time;
        Timer t = new Timer("tarefa");
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                if (count == files.length) {
                    count = 0;
                }
                try {
                    System.out.println("Contagem: " + count);
                    FileToString f = new FileToString(files[count]);
                    System.out.println("Query: " + f.fileToString());
                    JDBCCategoryDataset data = new JDBCCategoryDataset(con, f.fileToString());
                    String name = files[count].getName();
                    name = name.replaceAll(".sql", "");
                    barChart1.setChartTitle(name);
                    barChart1.setData(data);

                    count++;
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        }, 0, time);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        try {
            barChart1 = new com.github.graficos.components.BarChart();
        } catch (java.sql.SQLException e1) {
            e1.printStackTrace();
        }

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Gráficos");
        setPreferredSize(new java.awt.Dimension(750, 575));

        barChart1.setBgLabelColor(java.awt.Color.white);
        barChart1.setBgSeriesColor(new java.awt.Color(102, 102, 255));
        barChart1.setDomainAxisColor(java.awt.Color.white);
        barChart1.setDomainAxisVisible(true);
        barChart1.setSeriesPaint(java.awt.Color.white);
        barChart1.setSeriesVisible(true);
        barChart1.setShowTitle(true);
        barChart1.setTitleColor(java.awt.Color.white);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barChart1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(barChart1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 361, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.graficos.components.BarChart barChart1;
    // End of variables declaration//GEN-END:variables
}
