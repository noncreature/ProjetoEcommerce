package com.av1.entities;

import com.av1.entities.Pedido;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-04T20:10:32", comments="EclipseLink-2.7.10.v20211216-rNA")
@StaticMetamodel(FormaDePagamento.class)
public class FormaDePagamento_ { 

    public static volatile SingularAttribute<FormaDePagamento, String> nome;
    public static volatile SingularAttribute<FormaDePagamento, Integer> id;
    public static volatile CollectionAttribute<FormaDePagamento, Pedido> pedidoCollection;
    public static volatile SingularAttribute<FormaDePagamento, Boolean> permiteParcelamento;

}