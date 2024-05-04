package com.av1.panels;

import com.av1.entities.ItemPedido;
import com.av1.entities.Produto;
import java.math.BigDecimal;
import java.util.function.Consumer;

/**
 * O painel que exibe as informações de um dos produtos da loja.
 * @see Produto
 */
public class pn_ItemLoja extends javax.swing.JPanel {
    Produto produto;
    Consumer adicionar;
    int qtd, estoque;
    
    public pn_ItemLoja(Produto p, Consumer<ItemPedido> adicionar) {
        initComponents();
        produto = p;
        lb_nome.setText(p.getNome());
        ta_descricao.setText(p.getDescricao());
        lb_estoque.setText(p.getEstoque()+" em estoque");
        lb_valor.setText("R$ "+p.getValor());
        qtd = 1;
        estoque = produto.getEstoque();
        tf_qtd.setText(String.valueOf(qtd));
        this.adicionar = adicionar;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lb_nome = new javax.swing.JLabel();
        pn_descricao = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ta_descricao = new javax.swing.JTextArea();
        pn_info = new javax.swing.JPanel();
        lb_valor = new javax.swing.JLabel();
        lb_estoque = new javax.swing.JLabel();
        pn_botoes = new javax.swing.JPanel();
        tf_qtd = new javax.swing.JTextField();
        bt_menos = new javax.swing.JButton();
        bt_mais = new javax.swing.JButton();
        bt_adicionar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(180, 220));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                formMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                formMouseExited(evt);
            }
        });

        lb_nome.setText("<nome>");
        lb_nome.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        ta_descricao.setEditable(false);
        ta_descricao.setColumns(20);
        ta_descricao.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        ta_descricao.setLineWrap(true);
        ta_descricao.setRows(5);
        ta_descricao.setWrapStyleWord(true);
        ta_descricao.setBorder(null);
        jScrollPane1.setViewportView(ta_descricao);

        javax.swing.GroupLayout pn_descricaoLayout = new javax.swing.GroupLayout(pn_descricao);
        pn_descricao.setLayout(pn_descricaoLayout);
        pn_descricaoLayout.setHorizontalGroup(
            pn_descricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_descricaoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        pn_descricaoLayout.setVerticalGroup(
            pn_descricaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
        );

        lb_valor.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        lb_valor.setText("R$ <valor>");

        lb_estoque.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        lb_estoque.setText("<estoque> em estoque");

        javax.swing.GroupLayout pn_infoLayout = new javax.swing.GroupLayout(pn_info);
        pn_info.setLayout(pn_infoLayout);
        pn_infoLayout.setHorizontalGroup(
            pn_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_infoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pn_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_valor, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lb_estoque, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        pn_infoLayout.setVerticalGroup(
            pn_infoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_infoLayout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(lb_estoque)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_valor)
                .addGap(10, 10, 10))
        );

        pn_botoes.setEnabled(false);

        tf_qtd.setText("1");
        tf_qtd.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_qtdFocusLost(evt);
            }
        });
        tf_qtd.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tf_qtdKeyTyped(evt);
            }
        });

        bt_menos.setText("-");
        bt_menos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_menosActionPerformed(evt);
            }
        });

        bt_mais.setText("+");
        bt_mais.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_maisActionPerformed(evt);
            }
        });

        bt_adicionar.setText("Adicionar ao carrinho");
        bt_adicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_adicionarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_botoesLayout = new javax.swing.GroupLayout(pn_botoes);
        pn_botoes.setLayout(pn_botoesLayout);
        pn_botoesLayout.setHorizontalGroup(
            pn_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pn_botoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pn_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bt_adicionar, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addGroup(pn_botoesLayout.createSequentialGroup()
                        .addComponent(bt_menos)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tf_qtd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bt_mais)))
                .addContainerGap())
        );
        pn_botoesLayout.setVerticalGroup(
            pn_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_botoesLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(pn_botoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_menos)
                    .addComponent(tf_qtd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bt_mais))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(bt_adicionar)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_descricao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_botoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pn_info, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_nome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lb_nome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(pn_descricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(pn_info, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(pn_botoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseEntered
        pn_descricao.setVisible(false);
        pn_botoes.setVisible(true);
        updateUI();
    }//GEN-LAST:event_formMouseEntered

    private void formMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseExited
        if(this.contains(evt.getPoint())) return;
        pn_botoes.setVisible(false);
        pn_descricao.setVisible(true);
        updateUI();
    }//GEN-LAST:event_formMouseExited

    private void tf_qtdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_qtdKeyTyped
        if(!Character.isDigit(evt.getKeyChar())) evt.consume();
    }//GEN-LAST:event_tf_qtdKeyTyped

    private void tf_qtdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_qtdFocusLost
        int q;
        try {q = Integer.parseInt(tf_qtd.getText());}
        catch(Exception e){q=1;}
        if(q<=1)
            tf_qtd.setText("1");
        else if(q>estoque)
            tf_qtd.setText(String.valueOf(estoque));
        qtd = Integer.parseInt(tf_qtd.getText());
    }//GEN-LAST:event_tf_qtdFocusLost

    private void bt_maisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_maisActionPerformed
        if(qtd<estoque){
            qtd++;
            tf_qtd.setText(String.valueOf(qtd));
        }
    }//GEN-LAST:event_bt_maisActionPerformed

    private void bt_menosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_menosActionPerformed
        if(qtd>1){
            qtd--;
            tf_qtd.setText(String.valueOf(qtd));
        }
    }//GEN-LAST:event_bt_menosActionPerformed

    private void bt_adicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_adicionarActionPerformed
        adicionar.accept(new ItemPedido(qtd, new BigDecimal(qtd).multiply(produto.getValor()), produto));
        estoque-=qtd;
        if(estoque>0) qtd = 1;
        else{
            qtd = 0;
            tf_qtd.setEnabled(false);
            bt_adicionar.setEnabled(false);
            bt_mais.setEnabled(false);
            bt_menos.setEnabled(false);
        }
        tf_qtd.setText(String.valueOf(qtd));
    }//GEN-LAST:event_bt_adicionarActionPerformed
    
    /**
     * Adiciona à contagem de unidades restantes do produto no estoque (que não foram adicionadas ao carrinho) o valor fornecido.
     * @param q A quantidade a ser adicionada.
     * @throws ArithmeticException Caso o valor informado, ao ser somado com o valor atual, fosse ser superior à quantidade registrada no banco de dados.
     */
    public void adicionarAoEstoque(int q){
        if(estoque+q>produto.getEstoque()) throw new ArithmeticException();
        estoque+=q;
        if(!bt_adicionar.isEnabled()){
            qtd = 1;
            tf_qtd.setText("1");
            tf_qtd.setEnabled(true);
            bt_adicionar.setEnabled(true);
            bt_mais.setEnabled(true);
            bt_menos.setEnabled(true);
        }
    }
    
    /**
     * Retorna o ID do produto referente ao painel.
     * @return O ID do produto.
     */
    public int getIdProduto(){
        return produto.getId();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_adicionar;
    private javax.swing.JButton bt_mais;
    private javax.swing.JButton bt_menos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_estoque;
    private javax.swing.JLabel lb_nome;
    private javax.swing.JLabel lb_valor;
    private javax.swing.JPanel pn_botoes;
    private javax.swing.JPanel pn_descricao;
    private javax.swing.JPanel pn_info;
    private javax.swing.JTextArea ta_descricao;
    private javax.swing.JTextField tf_qtd;
    // End of variables declaration//GEN-END:variables
}
