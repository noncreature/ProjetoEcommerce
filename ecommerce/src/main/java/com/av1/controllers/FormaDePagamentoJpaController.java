package com.av1.controllers;

import com.av1.controllers.exceptions.IllegalOrphanException;
import com.av1.controllers.exceptions.NonexistentEntityException;
import com.av1.entities.FormaDePagamento;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.av1.entities.Pedido;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Controla as transições no banco de dados referentes à classe FormaDePagamento.
 * Criado pela unidade de persistência.
 * @see FormaDePagamento
 */
public class FormaDePagamentoJpaController implements Serializable {

    public FormaDePagamentoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(FormaDePagamento formaDePagamento) {
        if (formaDePagamento.getPedidoCollection() == null) {
            formaDePagamento.setPedidoCollection(new ArrayList<Pedido>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<Pedido> attachedPedidoCollection = new ArrayList<Pedido>();
            for (Pedido pedidoCollectionPedidoToAttach : formaDePagamento.getPedidoCollection()) {
                pedidoCollectionPedidoToAttach = em.getReference(pedidoCollectionPedidoToAttach.getClass(), pedidoCollectionPedidoToAttach.getId());
                attachedPedidoCollection.add(pedidoCollectionPedidoToAttach);
            }
            formaDePagamento.setPedidoCollection(attachedPedidoCollection);
            em.persist(formaDePagamento);
            for (Pedido pedidoCollectionPedido : formaDePagamento.getPedidoCollection()) {
                FormaDePagamento oldFormaDePagamentoOfPedidoCollectionPedido = pedidoCollectionPedido.getFormaDePagamento();
                pedidoCollectionPedido.setFormaDePagamento(formaDePagamento);
                pedidoCollectionPedido = em.merge(pedidoCollectionPedido);
                if (oldFormaDePagamentoOfPedidoCollectionPedido != null) {
                    oldFormaDePagamentoOfPedidoCollectionPedido.getPedidoCollection().remove(pedidoCollectionPedido);
                    oldFormaDePagamentoOfPedidoCollectionPedido = em.merge(oldFormaDePagamentoOfPedidoCollectionPedido);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(FormaDePagamento formaDePagamento) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FormaDePagamento persistentFormaDePagamento = em.find(FormaDePagamento.class, formaDePagamento.getId());
            Collection<Pedido> pedidoCollectionOld = persistentFormaDePagamento.getPedidoCollection();
            Collection<Pedido> pedidoCollectionNew = formaDePagamento.getPedidoCollection();
            List<String> illegalOrphanMessages = null;
            for (Pedido pedidoCollectionOldPedido : pedidoCollectionOld) {
                if (!pedidoCollectionNew.contains(pedidoCollectionOldPedido)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain Pedido " + pedidoCollectionOldPedido + " since its formaDePagamento field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<Pedido> attachedPedidoCollectionNew = new ArrayList<Pedido>();
            for (Pedido pedidoCollectionNewPedidoToAttach : pedidoCollectionNew) {
                pedidoCollectionNewPedidoToAttach = em.getReference(pedidoCollectionNewPedidoToAttach.getClass(), pedidoCollectionNewPedidoToAttach.getId());
                attachedPedidoCollectionNew.add(pedidoCollectionNewPedidoToAttach);
            }
            pedidoCollectionNew = attachedPedidoCollectionNew;
            formaDePagamento.setPedidoCollection(pedidoCollectionNew);
            formaDePagamento = em.merge(formaDePagamento);
            for (Pedido pedidoCollectionNewPedido : pedidoCollectionNew) {
                if (!pedidoCollectionOld.contains(pedidoCollectionNewPedido)) {
                    FormaDePagamento oldFormaDePagamentoOfPedidoCollectionNewPedido = pedidoCollectionNewPedido.getFormaDePagamento();
                    pedidoCollectionNewPedido.setFormaDePagamento(formaDePagamento);
                    pedidoCollectionNewPedido = em.merge(pedidoCollectionNewPedido);
                    if (oldFormaDePagamentoOfPedidoCollectionNewPedido != null && !oldFormaDePagamentoOfPedidoCollectionNewPedido.equals(formaDePagamento)) {
                        oldFormaDePagamentoOfPedidoCollectionNewPedido.getPedidoCollection().remove(pedidoCollectionNewPedido);
                        oldFormaDePagamentoOfPedidoCollectionNewPedido = em.merge(oldFormaDePagamentoOfPedidoCollectionNewPedido);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = formaDePagamento.getId();
                if (findFormaDePagamento(id) == null) {
                    throw new NonexistentEntityException("The formaDePagamento with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws IllegalOrphanException, NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            FormaDePagamento formaDePagamento;
            try {
                formaDePagamento = em.getReference(FormaDePagamento.class, id);
                formaDePagamento.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The formaDePagamento with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<Pedido> pedidoCollectionOrphanCheck = formaDePagamento.getPedidoCollection();
            for (Pedido pedidoCollectionOrphanCheckPedido : pedidoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This FormaDePagamento (" + formaDePagamento + ") cannot be destroyed since the Pedido " + pedidoCollectionOrphanCheckPedido + " in its pedidoCollection field has a non-nullable formaDePagamento field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(formaDePagamento);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<FormaDePagamento> findFormaDePagamentoEntities() {
        return findFormaDePagamentoEntities(true, -1, -1);
    }

    public List<FormaDePagamento> findFormaDePagamentoEntities(int maxResults, int firstResult) {
        return findFormaDePagamentoEntities(false, maxResults, firstResult);
    }

    private List<FormaDePagamento> findFormaDePagamentoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(FormaDePagamento.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public FormaDePagamento findFormaDePagamento(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(FormaDePagamento.class, id);
        } finally {
            em.close();
        }
    }

    public int getFormaDePagamentoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<FormaDePagamento> rt = cq.from(FormaDePagamento.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}