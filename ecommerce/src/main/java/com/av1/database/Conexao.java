package com.av1.database;

import com.av1.controllers.*;
import com.av1.controllers.exceptions.IllegalOrphanException;
import com.av1.controllers.exceptions.NonexistentEntityException;
import com.av1.entities.*;
import com.av1.interfaces.Conta;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Gerencia a conexão com o banco de dados e realiza consultas e inserções de dados;
 */
public class Conexao {
    EntityManagerFactory emf;
    
    public Conexao(){
        emf = Persistence.createEntityManagerFactory("SistemaPU");
    }
    /**
     * Retorna a entidade Administrador ou Cliente do banco de dados, referente ao usuário com o login e a senha fornecidos.
     * @param login O valor da coluna login do usuário.
     * @param senha O valor da coluna senha do usuário.
     * @return conta A conta a ser buscada. Pode ser da classe Administrador ou Cliente.
     * @throws IncorrectPasswordException caso a senha fornecida esteja incorreta.
     * @throws UserNotFoundException caso o login fornecido não corresponda a nenhum usuário do banco de dados.
     * @see Administrador
     * @see Cliente
     */
    public Conta getUsuario(String login, String senha) throws IncorrectPasswordException, UserNotFoundException{
        UsuarioJpaController userControl = new UsuarioJpaController(emf);
        List<Usuario> users = userControl.findUsuarioEntities();
        for (Usuario user : users) {
            if(user.getLogin().equals(login)){
                if(user.getSenha().equals(senha)){
                    if(user.getIsAdmin()){
                        AdministradorJpaController adminController = new AdministradorJpaController(emf);
                        List<Administrador> admins = adminController.findAdministradorEntities();
                        for (Administrador admin : admins) {
                            if(admin.getIdUsuario().equals(user)) return admin;
                        }
                    }
                    ClienteJpaController clienteController = new ClienteJpaController(emf);
                    List<Cliente> clientes = clienteController.findClienteEntities();
                    for (Cliente cliente : clientes) {
                        if(cliente.getIdUsuario().equals(user)) return cliente;
                    }
                }
                throw new IncorrectPasswordException();
            }
        }
        throw new UserNotFoundException();
    }
    
    /**
     * Cria um objeto da classe cliente e o salva no banco de dados.
     * @param login O valor da coluna 'login'.
     * @param senha O valor da coluna 'senha'.
     * @param nome O valor da coluna 'nome'.
     * @param cpf O valor da coluna 'cpf'.
     * @param telefone O valor da coluna 'telefone'.
     * @param email O valor da coluna 'email'.
     * @throws IllegalOrphanException 
     * @see Cliente
     * @see ClienteJpaController
     * @see Usuario
     * @see UsuarioJpaController
     */
    public void criarCliente(String login, String senha, String nome, String cpf, String telefone, String email) throws IllegalOrphanException{
        UsuarioJpaController uControl = new UsuarioJpaController(emf);
        Usuario user = new Usuario(1, login, false, senha);
        uControl.create(user);
        ClienteJpaController cControl = new ClienteJpaController(emf);
        Cliente cliente = new Cliente(1, cpf, nome, telefone, email, user);
        cControl.create(cliente);
    }
    /**
     * Busca um produto no banco de dados com o ID fornecido e retorna um objeto que o representa.
     * @param id ID do produto a ser buscado.
     * @return Objeto com os dados do produto encontrado.
     * @see Produto
     */
    public Produto getProduto(Integer id){
        ProdutoJpaController pControl = new ProdutoJpaController(emf);
        return pControl.findProduto(id);
    }

    /**
     * Retorna todos os registros da tabela 'produto' no banco de dados.
     * @return Lista com todos os produtos cadastrados no banco de dados.
     * @see Produto
     * @see List
     */
    public List<Produto> getProdutos() {
        ProdutoJpaController pControl = new ProdutoJpaController(emf);
        return pControl.findProdutoEntities();
    }
    
    /**
     * Salva as informações do produto no banco de dados.
     * @param p O produto a ser registrado.
     * @return O ID definido para o produto.
     * @see Produto
     */
    public int criarProduto(Produto p){
        ProdutoJpaController pControl = new ProdutoJpaController(emf);
        pControl.create(p);
        return p.getId();
    }
    
    /**
     * Salva as alterações feitas em um objeto do tipo 'Produto' na sua respectiva tabela no banco de dados.
     * @param p O produto a ser alterado.
     * @return O ID do produto que foi modificado.
     * @throws NonexistentEntityException Caso o objeto não possua um registro no banco de dados.
     * @throws Exception 
     * @see Produto
     */
    public int editarProduto(Produto p) throws NonexistentEntityException, Exception{
        ProdutoJpaController pControl = new ProdutoJpaController(emf);
        pControl.edit(p);
        return p.getId();
    }

    /**
     * Exclui o registro do produto no banco de dados.
     * @param id O ID do produto a ser excluído.
     * @throws IllegalOrphanException
     * @throws NonexistentEntityException Caso não haja no banco de dados um produto com o ID informado.
     */
    public void removerProduto(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        ProdutoJpaController pControl = new ProdutoJpaController(emf);
        pControl.destroy(id);
    }

    /**
     * Retorna uma lista com todas as formas de pagamento salvas no banco de dados.
     * @return Uma lista com todas as formas de pagamento salvas no banco de dados.
     * @see FormaDePagamento
     * @see List
     */
    public List<FormaDePagamento> getFormasDePagamento() {
        FormaDePagamentoJpaController fPgtoControl = new FormaDePagamentoJpaController(emf);
        return fPgtoControl.findFormaDePagamentoEntities();
    }

    /**
     * Função ainda a ser desenvolvida. Deve salvar no banco de dados as informações de um objeto da classe 'Pedido'.
     * @param pedido O Pedido a ser salvo.
     */
    public void criarPedido(Pedido pedido) {
        PedidoJpaController pController = new PedidoJpaController(emf);
        pController.create(pedido);
    }
}