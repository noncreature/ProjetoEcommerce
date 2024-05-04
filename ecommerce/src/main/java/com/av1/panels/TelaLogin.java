package com.av1.panels;

import com.av1.database.Conexao;
import com.av1.database.IncorrectPasswordException;
import com.av1.database.UserNotFoundException;
import com.av1.interfaces.Conta;
import com.av1.entities.Administrador;
import com.av1.entities.Cliente;
import javax.swing.JOptionPane;

/**
 * Permite o usuário acessar o sistema com uma conta de Administrador ou Cliente.
 * @see Administrador
 * @see Cliente
 */
public class TelaLogin extends Painel {
    
    public TelaLogin() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        pn_header = new javax.swing.JPanel();
        lb_titulo = new javax.swing.JLabel();
        pn_centro = new javax.swing.JPanel();
        lb_login = new javax.swing.JLabel();
        lb_senha = new javax.swing.JLabel();
        tf_login = new javax.swing.JTextField();
        bt_entrar = new javax.swing.JButton();
        bt_cadastrar = new javax.swing.JButton();
        pf_senha = new javax.swing.JPasswordField();
        cb_mostrar_senha = new javax.swing.JCheckBox();

        jLabel2.setText("jLabel2");

        setBackground(new java.awt.Color(59, 57, 54));

        pn_header.setBackground(new java.awt.Color(189, 42, 46));
        pn_header.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        lb_titulo.setFont(new java.awt.Font("Leelawadee UI Semilight", 2, 24)); // NOI18N
        lb_titulo.setForeground(new java.awt.Color(255, 255, 255));
        lb_titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_titulo.setText("(NOME DA LOJA)");

        javax.swing.GroupLayout pn_headerLayout = new javax.swing.GroupLayout(pn_header);
        pn_header.setLayout(pn_headerLayout);
        pn_headerLayout.setHorizontalGroup(
            pn_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lb_titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pn_headerLayout.setVerticalGroup(
            pn_headerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_headerLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(lb_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        lb_login.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        lb_login.setText("Usuário:");

        lb_senha.setFont(new java.awt.Font("Leelawadee UI", 0, 18)); // NOI18N
        lb_senha.setText("Senha:");

        tf_login.setToolTipText("");

        bt_entrar.setBackground(new java.awt.Color(204, 204, 204));
        bt_entrar.setText("Entrar");
        bt_entrar.setBorderPainted(false);
        bt_entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_entrarActionPerformed(evt);
            }
        });

        bt_cadastrar.setBackground(new java.awt.Color(204, 204, 204));
        bt_cadastrar.setText("Cadastrar-se");
        bt_cadastrar.setBorderPainted(false);
        bt_cadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        bt_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_cadastrarActionPerformed(evt);
            }
        });

        cb_mostrar_senha.setText("Mostrar senha");
        cb_mostrar_senha.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        cb_mostrar_senha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cb_mostrar_senhaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pn_centroLayout = new javax.swing.GroupLayout(pn_centro);
        pn_centro.setLayout(pn_centroLayout);
        pn_centroLayout.setHorizontalGroup(
            pn_centroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_centroLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(pn_centroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(cb_mostrar_senha)
                    .addGroup(pn_centroLayout.createSequentialGroup()
                        .addComponent(bt_cadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_entrar))
                    .addGroup(pn_centroLayout.createSequentialGroup()
                        .addGroup(pn_centroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lb_login)
                            .addComponent(lb_senha))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pn_centroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tf_login, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(pf_senha))))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        pn_centroLayout.setVerticalGroup(
            pn_centroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pn_centroLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pn_centroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lb_login)
                    .addComponent(tf_login, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pn_centroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lb_senha, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
                    .addComponent(pf_senha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cb_mostrar_senha)
                .addGap(20, 20, 20)
                .addGroup(pn_centroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_entrar)
                    .addComponent(bt_cadastrar))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_header, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(pn_centro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pn_header, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pn_centro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Troca para a tela de cadastro de clientes.
     * @param evt O evento gerado pelo clique do botão na interface gráfica.
     * @see Cliente
     */
    private void bt_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_cadastrarActionPerformed
        trocarPainel(new TelaCadastroCliente(), "Center");
    }//GEN-LAST:event_bt_cadastrarActionPerformed

    private void bt_entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_entrarActionPerformed
        try {
            Conexao conexao = new Conexao();
            Conta conta = conexao.getUsuario(tf_login.getText(), pf_senha.getText());
            if(conta instanceof Administrador){
                trocarPainel(new TelaAdmin((Administrador) conta), "Center");
            }
            if(conta instanceof Cliente){
                trocarPainel(new TelaLoja((Cliente) conta), "Center");
            }
        } catch (IncorrectPasswordException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", 0);
        } catch (UserNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", 0);
        }
    }//GEN-LAST:event_bt_entrarActionPerformed

    private void cb_mostrar_senhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cb_mostrar_senhaActionPerformed
        if(cb_mostrar_senha.isSelected()){
            pf_senha.setEchoChar((char)0);
        } else {
            pf_senha.setEchoChar('\u2022');
        }
    }//GEN-LAST:event_cb_mostrar_senhaActionPerformed
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cadastrar;
    private javax.swing.JButton bt_entrar;
    private javax.swing.JCheckBox cb_mostrar_senha;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lb_login;
    private javax.swing.JLabel lb_senha;
    private javax.swing.JLabel lb_titulo;
    private javax.swing.JPasswordField pf_senha;
    private javax.swing.JPanel pn_centro;
    private javax.swing.JPanel pn_header;
    private javax.swing.JTextField tf_login;
    // End of variables declaration//GEN-END:variables
}
