package com.av1.entities;

import com.av1.entities.Pedido;
import com.av1.entities.Produto;
import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-04T20:10:32", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(ItemPedido.class)
public class ItemPedido_ { 

    public static volatile SingularAttribute<ItemPedido, Produto> idProduto;
    public static volatile SingularAttribute<ItemPedido, BigDecimal> valorTotal;
    public static volatile SingularAttribute<ItemPedido, Integer> id;
    public static volatile SingularAttribute<ItemPedido, Pedido> idPedido;
    public static volatile SingularAttribute<ItemPedido, Integer> quantidade;

}