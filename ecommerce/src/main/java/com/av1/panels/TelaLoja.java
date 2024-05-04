package com.av1.panels;

import com.av1.database.Conexao;
import com.av1.entities.Cliente;
import com.av1.entities.ItemPedido;
import com.av1.entities.Pedido;
import com.av1.entities.Produto;
import com.av1.resources.WrapLayout;
import java.awt.Component;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 * Permite ao cliente adicionar e remover produtos em um pedido para, posteriormente, efetuar a compra.
 */
public class TelaLoja extends Painel {
    private Cliente cliente;
    private Conexao conexao;
    private Pedido pedido;
    
    public TelaLoja(Cliente cliente) {
        initComponents();
        this.cliente = cliente;
        this.pedido = new Pedido();
        this.conexao = new Conexao();
        lb_nome_cliente.setText(cliente.getNome());
        lb_cpf_cliente.setText(cliente.getCpf());
        pedido.setValorTotal(BigDecimal.ZERO);
        pedido.setItemPedidoCollection(new LinkedList<ItemPedido>());
        pn_itens.setLayout(new WrapLayout(0, 30, 15));
        pn_carrinho.setLayout(new WrapLayout(0, 6, 6));
        for (Produto produto : conexao.getProdutos()) {
            if(produto.getEstoque()<=0) continue;
            pn_ItemLoja item = new pn_ItemLoja(produto, this::adicionarAoCarrinho);
            pn_itens.add(item);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        lb_footer = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lb_img_carrinho = new javax.swing.JLabel();
        lb_txt_total = new javax.swing.JLabel();
        lb_valor_total = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pn_carrinho = new javax.swing.JPanel();
        bt_comprar = new javax.swing.JButton();
        bt_limparCarrinho = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        pn_itens = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        lb_img_logo = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        lb_img_cliente = new javax.swing.JLabel();
        lb_nome_cliente = new javax.swing.JLabel();
        lb_cpf_cliente = new javax.swing.JLabel();

        jPanel3.setBackground(new java.awt.Color(59, 57, 54));

        lb_footer.setForeground(new java.awt.Color(136, 156, 155));
        lb_footer.setText("CNPJ n.º 03.007.331/0001-41 / Av. Marechal Deodoro, nº 303, Centro. Lages/SCP - CEP 88504-350 - Global Sale inc.");

        jPanel2.setBackground(new java.awt.Color(136, 156, 155));

        lb_img_carrinho.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icone2.png"))); // NOI18N

        lb_txt_total.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_txt_total.setText("Total: R$");

        lb_valor_total.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lb_valor_total.setText("0.00");

        jScrollPane2.setPreferredSize(new java.awt.Dimension(276, 400));
        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pn_carrinho.setBackground(new java.awt.Color(178, 190, 191));

        javax.swing.GroupLayout pn_carrinhoLayout = new javax.swing.GroupLayout(pn_carrinho);
        pn_carrinho.setLayout(pn_carrinhoLayout);
        pn_carrinhoLayout.setHorizontalGroup(
            pn_carrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
        );
        pn_carrinhoLayout.setVerticalGroup(
            pn_carrinhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 487, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(pn_carrinho);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lb_txt_total)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lb_valor_total))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lb_img_carrinho)
                .addGap(134, 134, 134))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_img_carrinho)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_valor_total)
                    .addComponent(lb_txt_total))
                .addContainerGap())
        );

        bt_comprar.setBackground(new java.awt.Color(204, 204, 204));
        bt_comprar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_comprar.setText("Comprar");
        bt_comprar.setBorderPainted(false);
        bt_comprar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bt_comprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_comprarActionPerformed(evt);
            }
        });

        bt_limparCarrinho.setBackground(new java.awt.Color(204, 204, 204));
        bt_limparCarrinho.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_limparCarrinho.setText("Limpar carrinho");
        bt_limparCarrinho.setBorderPainted(false);
        bt_limparCarrinho.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bt_limparCarrinho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_limparCarrinhoActionPerformed(evt);
            }
        });

        jScrollPane1.setPreferredSize(new java.awt.Dimension(892, 402));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        pn_itens.setBackground(new java.awt.Color(178, 190, 191));

        javax.swing.GroupLayout pn_itensLayout = new javax.swing.GroupLayout(pn_itens);
        pn_itens.setLayout(pn_itensLayout);
        pn_itensLayout.setHorizontalGroup(
            pn_itensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 880, Short.MAX_VALUE)
        );
        pn_itensLayout.setVerticalGroup(
            pn_itensLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 647, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(pn_itens);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 890, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(bt_comprar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(bt_limparCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(lb_footer)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bt_limparCarrinho, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bt_comprar, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lb_footer)
                .addContainerGap())
        );

        jPanel1.setBackground(new java.awt.Color(189, 42, 46));
        jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lb_img_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icone.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(403, 403, 403)
                .addComponent(lb_img_logo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lb_img_logo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(178, 190, 191));

        lb_img_cliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icone1.png"))); // NOI18N

        lb_nome_cliente.setText("(nome cliente)");

        lb_cpf_cliente.setText("(cpf)");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lb_img_cliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lb_nome_cliente)
                    .addComponent(lb_cpf_cliente))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lb_img_cliente))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(lb_nome_cliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lb_cpf_cliente)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Caso haja um ou mais itens no carrinho, prossegue para a finalização do pedio, trocando a tela para uma nova TelaPagamento.
     * @param evt Evento gerado pelo clique do botão na interface gráfica.
     * @see TelaPagamento
     */
    private void bt_comprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_comprarActionPerformed
        if(pedido.getItemPedidoCollection().isEmpty()){
            JOptionPane.showMessageDialog(null, "Adicione produtos ao carrinho para poder finalizar sua compra.", "Aviso", 2);
            return;
        }
        trocarPainel(new TelaPagamento(cliente, pedido), "Center");
    }//GEN-LAST:event_bt_comprarActionPerformed

    /**
     * Remove todos os itens do carrinho, assim como as respectivas representações gráficas.
     * @param evt Evento gerado pelo clique do botão na interface gráfica.
     */
    private void bt_limparCarrinhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_limparCarrinhoActionPerformed
        for (Component c : pn_carrinho.getComponents()) {
            if(c instanceof pn_ItemCarrinho item)
                removerDoCarrinho(item);
        }
        /* <editor-fold defaultstate="collapsed" desc="Implementação antiga"> 
        if(JOptionPane.showConfirmDialog(null, "Tem certeza de que deseja esvaziar o carrinho?", "Confirmar ação", 0) != 0) return;
        pedido.setValorTotal(BigDecimal.ZERO);
        lb_valor_total.setText("0.00");
        for(pn_ItemLoja iL : itensLoja){
            for (ItemPedido iP : pedido.getItemPedidoCollection()) {
                if (iL.getProductID() == iP.getIdProduto().getId()) {
                    iL.adicionarAoEstoque(iP.getQuantidade());
                    pedido.getItemPedidoCollection().remove(iP);
                    break;
                }
            }
        }
        pn_carrinho.removeAll();
        pn_carrinho.revalidate();
        pn_carrinho.repaint();
        pn_carrinho.updateUI();
        itensCarrinho.clear();
        pedido.getItemPedidoCollection().clear();
        */// </editor-fold>
    }//GEN-LAST:event_bt_limparCarrinhoActionPerformed
    
    /**
     * Adiciona um item no carrinho e mostra uma representação do item na interface gráfica.
     * @param itemPedido Item a ser adicionado.
     * @throws RuntimeException 
     */
    public void adicionarAoCarrinho(ItemPedido itemPedido) throws RuntimeException{
        itemPedido.setIdPedido(pedido);
        pedido.setValorTotal(pedido.getValorTotal().add(itemPedido.getValorTotal()));
        lb_valor_total.setText(pedido.getValorTotal().toString());
        Collection<ItemPedido> carrinho = pedido.getItemPedidoCollection();
        for (ItemPedido item : carrinho) {
            if(item.getIdProduto()== itemPedido.getIdProduto()){
                item.setQuantidade(item.getQuantidade()+itemPedido.getQuantidade());
                item.setValorTotal(itemPedido.getValorTotal().add(item.getValorTotal()));
                for(Component c : pn_carrinho.getComponents()){
                    if (c instanceof pn_ItemCarrinho painel) {
                        if (painel.getItem().getIdProduto().getId() == item.getIdProduto().getId()) {
                            painel.setQtd(item.getQuantidade());
                            painel.setValorTotal(item.getValorTotal());
                            return;
                        }
                    }
                }
                throw new RuntimeException("O produto está cadastrado no pedido, mas não se encontra na UI do carrinho.");
            }
        }
        carrinho.add(itemPedido);
        //pn_carrinho.add(new pn_ItemCarrinho(itemPedido, this::removerDoCarrinho));
        atualizarCarrinho();
        /*<editor-fold defaultstate="collapsed" desc="Implementação antiga"> 
        pedido.setValorTotal(pedido.getValorTotal().add(item.getValorTotal()));
        lb_valor_total.setText(pedido.getValorTotal().toString());
        for (ItemPedido i : pedido.getItemPedidoCollection()) {
            if(item.getIdProduto().getId() ==i.getIdProduto().getId()){
                int qtd = item.getQuantidade() + i.getQuantidade();
                i.setQuantidade(qtd);
                i.setValorTotal(item.getValorTotal().add(i.getValorTotal()));
                for (Component c : pn_carrinho.getComponents()) {
                    if (c instanceof pn_ItemCarrinho iC) {
                        if(item.getIdProduto().getId() == iC.getItem().getIdProduto().getId()){
                        iC.setQtd(i.getQuantidade());
                        iC.setValorTotal(i.getValorTotal());
                        break;
                        }
                    }
                }
                return;
            }
        }
        pedido.getItemPedidoCollection().add(item);
        pn_ItemCarrinho iC = new pn_ItemCarrinho(item, this::removerDoCarrinho);
        pn_carrinho.add(iC);
        */// </editor-fold>
    }
    
    /**
     * Remove um item do carrinho, assim como sua representação na interface gráfica.
     * @param painel Painel do item a ser removido na interface gráfica.
     * @throws RuntimeException 
     */
    public void removerDoCarrinho(pn_ItemCarrinho painel) throws RuntimeException{
        pedido.setValorTotal(pedido.getValorTotal().subtract(painel.getItem().getValorTotal()));
        lb_valor_total.setText(pedido.getValorTotal().toString());
//        pn_carrinho.remove(painel);
//        pn_carrinho.revalidate();
//        pn_carrinho.repaint();
//        pn_carrinho.updateUI();
        Produto p = painel.getItem().getIdProduto();
        Collection<ItemPedido> carrinho = pedido.getItemPedidoCollection();
        for (ItemPedido item : carrinho) {
            if(item.getIdProduto().getId() == p.getId()){
                carrinho.removeIf(i -> i.getIdProduto().getId() == p.getId());
                atualizarCarrinho();
                for(Component c : pn_itens.getComponents()){
                    if(c instanceof pn_ItemLoja itemLoja){
                        if(itemLoja.getIdProduto() == p.getId()){
                            itemLoja.adicionarAoEstoque(painel.getItem().getQuantidade());
                            return;
                        }
                    }
                }
                throw new RuntimeException("O produto está cadastrado no pedido, mas não se encontra presente na UI da loja.");
            }
        }
        throw new RuntimeException("O produto é mostrado na UI do carrinho, mas não se encontra cadastrado no pedido.");
        /*<editor-fold defaultstate="collapsed" desc="Implementação antiga"> 
        pedido.setValorTotal(pedido.getValorTotal().subtract(item.getItem().getValorTotal()));
        lb_valor_total.setText(pedido.getValorTotal().toString());
        for(Component c : pn_itens.getComponents()){
            if(c instanceof pn_ItemLoja iL)
            if(iL.getProductID() == item.getItem().getIdProduto().getId()){
                iL.adicionarAoEstoque(item.getItem().getQuantidade());
                break;
            }
        }
        for(ItemPedido iP : pedido.getItemPedidoCollection()){
            if(iP.getIdProduto().getId() == item.getItem().getIdProduto().getId()){
                pedido.getItemPedidoCollection().remove(iP);
                break;
            }
        }
        pn_carrinho.remove(item);
        pn_carrinho.revalidate();
        pn_carrinho.repaint();
        pn_carrinho.updateUI();
        */// </editor-fold>
    }
    
    /**
     * Remove todos os painéis de itens no carrinho da interface gráfica e depois adiciona um novo para cada registro de item do carrinho.
     */
    public void atualizarCarrinho(){
        pn_carrinho.removeAll();
        for (ItemPedido pedido : pedido.getItemPedidoCollection()) {
            pn_carrinho.add(new pn_ItemCarrinho(pedido, this::removerDoCarrinho));
        }
        pn_carrinho.revalidate();
        pn_carrinho.repaint();
        pn_carrinho.updateUI();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_comprar;
    private javax.swing.JButton bt_limparCarrinho;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lb_cpf_cliente;
    private javax.swing.JLabel lb_footer;
    private javax.swing.JLabel lb_img_carrinho;
    private javax.swing.JLabel lb_img_cliente;
    private javax.swing.JLabel lb_img_logo;
    private javax.swing.JLabel lb_nome_cliente;
    private javax.swing.JLabel lb_txt_total;
    private javax.swing.JLabel lb_valor_total;
    private javax.swing.JPanel pn_carrinho;
    private javax.swing.JPanel pn_itens;
    // End of variables declaration//GEN-END:variables
}
