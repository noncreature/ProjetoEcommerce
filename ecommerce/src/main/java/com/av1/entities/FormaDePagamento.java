package com.av1.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Armazena os dados de uma das possíveis forma de pagamento e estabelece funções para operar seus dados.
 * Representa um registro da tabela 'forma_de_pagamento' no banco de dados.
 * Classe criada pela unidade de persistência.
 */
@Entity
@Table(name = "forma_de_pagamento")
@NamedQueries({
    @NamedQuery(name = "FormaDePagamento.findAll", query = "SELECT f FROM FormaDePagamento f"),
    @NamedQuery(name = "FormaDePagamento.findById", query = "SELECT f FROM FormaDePagamento f WHERE f.id = :id"),
    @NamedQuery(name = "FormaDePagamento.findByNome", query = "SELECT f FROM FormaDePagamento f WHERE f.nome = :nome"),
    @NamedQuery(name = "FormaDePagamento.findByPermiteParcelamento", query = "SELECT f FROM FormaDePagamento f WHERE f.permiteParcelamento = :permiteParcelamento")})
public class FormaDePagamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "permite_parcelamento")
    private boolean permiteParcelamento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formaDePagamento")
    private Collection<Pedido> pedidoCollection;

    public FormaDePagamento() {
    }

    public FormaDePagamento(Integer id) {
        this.id = id;
    }

    public FormaDePagamento(Integer id, String nome, boolean permiteParcelamento) {
        this.id = id;
        this.nome = nome;
        this.permiteParcelamento = permiteParcelamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getPermiteParcelamento() {
        return permiteParcelamento;
    }

    public void setPermiteParcelamento(boolean permiteParcelamento) {
        this.permiteParcelamento = permiteParcelamento;
    }

    public Collection<Pedido> getPedidoCollection() {
        return pedidoCollection;
    }

    public void setPedidoCollection(Collection<Pedido> pedidoCollection) {
        this.pedidoCollection = pedidoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormaDePagamento)) {
            return false;
        }
        FormaDePagamento other = (FormaDePagamento) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.av1.entities.FormaDePagamento[ id=" + id + " ]";
    }
    //Atributos
    

    //Métodos
    
}