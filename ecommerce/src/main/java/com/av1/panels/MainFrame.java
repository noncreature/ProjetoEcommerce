package com.av1.panels;

import java.awt.BorderLayout;

/**
 * A janela que é aberta durante a execução do programa e recebe os painéis que serão mostrados ao usuário.
 * @see javax.swing.JFrame
 * @see javax.swing.JPanel
 */
public class MainFrame extends javax.swing.JFrame {

    public MainFrame() {
        initComponents();        
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Função chamada ao executar o programa.
     * @param args Não é necessário nenhum argumento.
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame j = new MainFrame();                
                j.add(new TelaLogin(), BorderLayout.CENTER);
                j.pack();
                j.setVisible(true);                               
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}