package com.av1.panels;

import com.av1.entities.ItemPedido;
import java.math.BigDecimal;
import java.util.function.Consumer;

/**
 * Painel que exibe as informações de um dos itens adicionados no carrinho do cliente.
 */
public class pn_ItemCarrinho extends javax.swing.JPanel {
    ItemPedido item;
    Consumer remover;
    
    public pn_ItemCarrinho(ItemPedido item, Consumer<pn_ItemCarrinho> remover) {
        initComponents();
        this.item = item;
        this.remover = remover;
        pn_botoes.setVisible(false);
        updateUI();
        ta_nome.setText(item.getIdProduto().getNome());
        lb_qtd.setText("X "+item.getQuantidade());
        lb_valor.setText("R$ "+item.getValorTotal());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ta_nome = new javax.swing.JTextArea();
        pn_info = new javax.swing.JPanel();
        lb_qtd = new javax.swing.JLabel();
        lb_valor = new javax.swing.JLabel();
        pn_botoes = new javax.swing.JPanel();
        bt_remover = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(280, 70));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        ta_nome.setEditable(false);
        ta_nome.setColumns(20);
        ta_nome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        ta_nome.setLineWrap(true);
        ta_nome.setRows(5);
        ta_nome.setText("<nome>");
        ta_nome.setWrapStyleWord(true);
        jScrollPane1.setViewportView(ta_nome);

        lb_qtd.setText("<qtd>");

        lb_valor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lb_valor.setText("R$ <valor_total>");

        javax.swing.GroupLayout pn_infoLayout = new javax.swing.GroupLayout(pn_info);
        pn_info.setLayout(pn_infoLayout);
        pn_infoLayout.setHorizontalGroup(
            pn_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_qtd)
            .addComponent(lb_valor)
        );
        pn_infoLayout.setVerticalGroup(
            pn_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_infoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_qtd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_valor, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        bt_remover.setText("Remover");
        bt_remover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_removerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_botoesLayout = new javax.swing.GroupLayout(pn_botoes);
        pn_botoes.setLayout(pn_botoesLayout);
        pn_botoesLayout.setHorizontalGroup(
            pn_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bt_remover)
        );
        pn_botoesLayout.setVerticalGroup(
            pn_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_botoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(bt_remover)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_botoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pn_info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_botoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_info, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void bt_removerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_removerActionPerformed
        // TODO add your handling code here:
        remover.accept(this);
    }//GEN-LAST:event_bt_removerActionPerformed

    /**
     * Quando o mouse entra nos limites do painel, esconde as informações sobre o item e exibe o botão para removê-lo do carrinho.
     * @param evt 
     */
    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        pn_info.setVisible(false);
        pn_botoes.setVisible(true);
        updateUI();
    }//GEN-LAST:event_formMouseEntered

    /**
     * Quando o mouse sai dos limites do painel, esconde o botão e exibe as informações do item.
     * @param evt 
     */
    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        if(this.contains(evt.getPoint())) return;
        pn_botoes.setVisible(false);
        pn_info.setVisible(true);
        updateUI();
    }//GEN-LAST:event_formMouseExited

    /**
     * Retorna o objeto da classe ItemPedido representado pelo painel.
     * @return O objeto da classe ItemPedido representado pelo painel.
     */
    public ItemPedido getItem(){
        return item;
    }
    
    /**
     * Altera o a quantidade do item no carrinho para o valor fornecido.
     * @param qtd O valor a ser definido para a quantidade do item.
     */
    void setQtd(int qtd) {
        item.setQuantidade(qtd);
        lb_qtd.setText("X "+item.getQuantidade());
    }

    /**
     * Altera o valor total do item para o valor fornecido.
     * @param valor O valor a ser definido para o valor total.
     */
    public void setValorTotal(BigDecimal valor){
        item.setValorTotal(valor);
        lb_valor.setText("R$ "+valor);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_remover;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_qtd;
    private javax.swing.JLabel lb_valor;
    private javax.swing.JPanel pn_botoes;
    private javax.swing.JPanel pn_info;
    private javax.swing.JTextArea ta_nome;
    // End of variables declaration//GEN-END:variables
}
