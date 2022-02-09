/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menú;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author pedro
 */
public class Instrucciones extends javax.swing.JFrame implements ActionListener {
    
    I_Panel1 panel1 = new I_Panel1();
    I_Panel2 panel2 = new I_Panel2();

    public Instrucciones() {
        initComponents();
        
        jPanel1.add(panel1);
        
        panel1.setVisible(true);
        panel2.setVisible(false);
        
        deshabilitarbotones();
        
        Banterior.addActionListener(this);
        Bsiguiente.addActionListener(this);
        
        
    }
    
    private void deshabilitarbotones(){
        if(panel1.isVisible()){
            Banterior.setEnabled(false);
            Bsiguiente.setEnabled(true);
        }
        
        else if(panel2.isVisible()){
            Banterior.setEnabled(true);
            Bsiguiente.setEnabled(false);
    }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        Banterior = new javax.swing.JButton();
        Bsiguiente = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(611, 511));
        jPanel1.setLayout(new java.awt.BorderLayout());

        Banterior.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Banterior.setText("Anterior");
        jPanel2.add(Banterior);

        Bsiguiente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        Bsiguiente.setText("Siguiente");
        jPanel2.add(Bsiguiente);

        jPanel1.add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jButton3.setText("Regresar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3);

        jPanel1.add(jPanel3, java.awt.BorderLayout.PAGE_START);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Menú M3= new Menú();
        dispose();
        M3.setVisible(true);        
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Instrucciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Instrucciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Instrucciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Instrucciones.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Instrucciones().setVisible(true);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    Object evt = e.getSource();
    if(evt.equals(Banterior)){
        panel2.setVisible(false);
        panel1.setVisible(true);
        
        jPanel1.add(panel1);
        jPanel1.validate();
        deshabilitarbotones();
    }
    else if(evt.equals(Bsiguiente)){
        panel1.setVisible(false);
        panel2.setVisible(true);
        
        jPanel1.add(panel2);
        jPanel1.validate();
        deshabilitarbotones();        
    }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Banterior;
    private javax.swing.JButton Bsiguiente;
    private javax.swing.JButton jButton3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables

       
}




