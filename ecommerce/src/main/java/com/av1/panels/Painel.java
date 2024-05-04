package com.av1.panels;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Classe que extende JPanel.
 * Implementa funções para acessar a janela na qual o painel está inserido e trocar o painel que está sendo exibido.
 * @see JPanel
 */
public class Painel extends JPanel {
    protected void trocarPainel(JPanel p, String bLayout){
        MainFrame j = (MainFrame) SwingUtilities.getWindowAncestor(this);
        j.remove(this);
        j.add(p, bLayout);
        j.pack();
    }
    
    protected MainFrame getFrame(){
        return (MainFrame) SwingUtilities.getWindowAncestor(this);
    }
}