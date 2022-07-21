package com.github.graficos.views;

import java.awt.Color;

public class ColorSelector extends javax.swing.JPanel {

    private final OnColor onColorSelected;

    public ColorSelector(OnColor onColorSeleceted) {
        this.onColorSelected = onColorSeleceted;
        initComponents();

    }

    public interface OnColor {

        void onColorSelected(Color c);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        colorChoose = new javax.swing.JColorChooser();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(500, 350));
        setLayout(new java.awt.CardLayout());

        colorChoose.setPreferredSize(new java.awt.Dimension(250, 200));
        colorChoose.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                colorChooseMouseClicked(evt);
            }
        });
        add(colorChoose, "card2");
    }// </editor-fold>//GEN-END:initComponents

    private void colorChooseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_colorChooseMouseClicked
        onColorSelected.onColorSelected(colorChoose.getColor());
        
    }//GEN-LAST:event_colorChooseMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JColorChooser colorChoose;
    // End of variables declaration//GEN-END:variables

}
