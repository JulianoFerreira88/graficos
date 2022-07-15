package com.github.graficos.views;

import com.github.graficos.components.BarChart;
import com.github.graficos.utils.FileToString;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.sql.Connection;
import org.jfree.data.jdbc.JDBCCategoryDataset;

public class ChartPanel extends javax.swing.JPanel {

    private File f;
    private Connection con;

    public ChartPanel(File file, Connection con) {
        super(new CardLayout());
        this.f = file;
        this.con = con;
        initComponents();
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent ce) {
                onShow();
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        setLayout(new java.awt.CardLayout());
    }// </editor-fold>//GEN-END:initComponents
    private void onShow() {
        try {
            BarChart chart = new BarChart();
            JDBCCategoryDataset data = new JDBCCategoryDataset(con, new FileToString(f).fileToString());
            chart.setData(data);
            chart.setBgChartColor(Color.darkGray);
            chart.setBgLabelColor(Color.white);
            chart.setBgSeriesColor(new Color(102, 102, 255));
            chart.setTitle(f.getName().replace(".sql", ""));
           
            this.add(chart);
            this.updateUI();
        } catch (Exception e) {
            System.err.println(e);
        }

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
