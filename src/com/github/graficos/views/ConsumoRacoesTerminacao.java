package com.github.graficos.views;

import java.awt.CardLayout;
import java.sql.Connection;

public class ConsumoRacoesTerminacao extends javax.swing.JPanel {

    private final Connection con;

    public ConsumoRacoesTerminacao(Connection con) {
        super(new CardLayout());
        this.con = con;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.CardLayout());
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
