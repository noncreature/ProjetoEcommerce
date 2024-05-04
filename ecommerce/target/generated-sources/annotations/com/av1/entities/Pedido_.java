package com.av1.entities;

import com.av1.entities.Cliente;
import com.av1.entities.FormaDePagamento;
import com.av1.entities.ItemPedido;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-04T20:10:32", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, Integer> parcelas;
    public static volatile SingularAttribute<Pedido, Date> data;
    public static volatile SingularAttribute<Pedido, Cliente> idCliente;
    public static volatile CollectionAttribute<Pedido, ItemPedido> itemPedidoCollection;
    public static volatile SingularAttribute<Pedido, BigDecimal> valorTotal;
    public static volatile SingularAttribute<Pedido, BigDecimal> valorParcelas;
    public static volatile SingularAttribute<Pedido, Integer> id;
    public static volatile SingularAttribute<Pedido, FormaDePagamento> formaDePagamento;

}