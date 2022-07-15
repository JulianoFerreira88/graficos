package com.github.graficos.views;

import com.github.graficos.utils.FileToString;
import java.io.File;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Timer;
import java.util.TimerTask;
import org.jfree.chart.ChartMouseEvent;
import org.jfree.chart.ChartMouseListener;
import org.jfree.data.jdbc.JDBCCategoryDataset;

public class MainView extends javax.swing.JFrame implements ChartMouseListener {

    private final Connection con;
    private final File[] files;
    private long time;
    private boolean enable = true;
    private int count = 0;
    private Timer t;

    public MainView(Connection con, File[] files) {
        this.con = con;
        this.files = files;
        initComponents();
        barChart1.addListener(this);
    }

    public void execute(long time) {
        this.time = time;
        t = new Timer("tarefa");
        t.schedule(new TimerTask() {
            @Override
            public void run() {
                if (count == files.length) {
                    count = 0;
                }
                if (enable) {
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
            }
        }, 0, this.time);
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
        getContentPane().add(barChart1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    private void setChangeState() {
        enable = !enable;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.graficos.components.BarChart barChart1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void chartMouseClicked(ChartMouseEvent event) {
        setChangeState();
    }

    @Override
    public void chartMouseMoved(ChartMouseEvent event) {

    }

}
