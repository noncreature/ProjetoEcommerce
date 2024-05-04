package com.av1.controllers;

import com.av1.controllers.exceptions.IllegalOrphanException;
import com.av1.controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.av1.entities.Cliente;
import com.av1.entities.FormaDePagamento;
import com.av1.entities.ItemPedido;
import com.av1.entities.Pedido;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Controla as transições no banco de dados referentes à classe Pedido.
 * Criado pela unidade de persistência.
 * @see Pedido
 */
public class PedidoJpaController implements Serializable {

    public PedidoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pedido pedido) {
        if (pedido.getItemPedidoCollection() == null) {
            pedido.setItemPedidoCollection(new ArrayList<ItemPedido>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cliente idCliente = pedido.getIdCliente();
            if (idCliente != null) {
                idCliente = em.getReference(idCliente.getClass(), idCliente.getId());
                pedido.setIdCliente(idCliente);
            }
            FormaDePagamento formaDePagamento = pedido.getFormaDePagamento();
            if (formaDePagamento != null) {
                formaDePagamento = em.getReference(formaDePagamento.getClass(), formaDePagamento.getId());
                pedido.setFormaDePagamento(formaDePagamento);
            }
            /*
            Collection<ItemPedido> attachedItemPedidoCollection = new ArrayList<ItemPedido>();
            for (ItemPedido itemPedidoCollectionItemPedidoToAttach : pedido.getItemPedidoCollection()) {
                itemPedidoCollectionItemPedidoToAttach = em.getReference(itemPedidoCollectionItemPedidoToAttach.getClass(), itemPedidoCollectionItemPedidoToAttach.getId());
                attachedItemPedidoCollection.add(itemPedidoCollectionItemPedidoToAttach);
            }
            pedido.setItemPedidoCollection(attachedItemPedidoCollection);
            */
            em.persist(pedido);
            if (idCliente != null) {
                idCliente.getPedidoCollection().add(pedido);
                idCliente = em.merge(idCliente);
            }
            if (formaDePagamento != null) {
                formaDePagamento.getPedidoCollection().add(pedido);
                formaDePagamento = em.merge(formaDePagamento);
            }
            /*
            for (ItemPedido itemPedidoCollectionItemPedido : pedido.getItemPedidoCollection()) {
                Pedido oldIdPedidoOfItemPedidoCollectionItemPedido = itemPedidoCollectionItemPedido.getIdPedido();
                itemPedidoCollectionItemPedido.setIdPedido(pedido);
                itemPedidoCollectionItemPedido = em.merge(itemPedidoCollectionItemPedido);
                if (oldIdPedidoOfItemPedidoCollectionItemPedido != null) {
                    oldIdPedidoOfItemPedidoCollectionItemPedido.getItemPedidoCollection().remove(itemPedidoCollectionItemPedido);
                    oldIdPedidoOfItemPedidoCollectionItemPedido = em.merge(oldIdPedidoOfItemPedidoCollectionItemPedido);
                }
            }
            */
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pedido pedido) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedido persistentPedido = em.find(Pedido.class, pedido.getId());
            Cliente idClienteOld = persistentPedido.getIdCliente();
            Cliente idClienteNew = pedido.getIdCliente();
            FormaDePagamento formaDePagamentoOld = persistentPedido.getFormaDePagamento();
            FormaDePagamento formaDePagamentoNew = pedido.getFormaDePagamento();
            Collection<ItemPedido> itemPedidoCollectionOld = persistentPedido.getItemPedidoCollection();
            Collection<ItemPedido> itemPedidoCollectionNew = pedido.getItemPedidoCollection();
            List<String> illegalOrphanMessages = null;
            for (ItemPedido itemPedidoCollectionOldItemPedido : itemPedidoCollectionOld) {
                if (!itemPedidoCollectionNew.contains(itemPedidoCollectionOldItemPedido)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ItemPedido " + itemPedidoCollectionOldItemPedido + " since its idPedido field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            if (idClienteNew != null) {
                idClienteNew = em.getReference(idClienteNew.getClass(), idClienteNew.getId());
                pedido.setIdCliente(idClienteNew);
            }
            if (formaDePagamentoNew != null) {
                formaDePagamentoNew = em.getReference(formaDePagamentoNew.getClass(), formaDePagamentoNew.getId());
                pedido.setFormaDePagamento(formaDePagamentoNew);
            }
            Collection<ItemPedido> attachedItemPedidoCollectionNew = new ArrayList<ItemPedido>();
            for (ItemPedido itemPedidoCollectionNewItemPedidoToAttach : itemPedidoCollectionNew) {
                itemPedidoCollectionNewItemPedidoToAttach = em.getReference(itemPedidoCollectionNewItemPedidoToAttach.getClass(), itemPedidoCollectionNewItemPedidoToAttach.getId());
                attachedItemPedidoCollectionNew.add(itemPedidoCollectionNewItemPedidoToAttach);
            }
            itemPedidoCollectionNew = attachedItemPedidoCollectionNew;
            pedido.setItemPedidoCollection(itemPedidoCollectionNew);
            pedido = em.merge(pedido);
            if (idClienteOld != null && !idClienteOld.equals(idClienteNew)) {
                idClienteOld.getPedidoCollection().remove(pedido);
                idClienteOld = em.merge(idClienteOld);
            }
            if (idClienteNew != null && !idClienteNew.equals(idClienteOld)) {
                idClienteNew.getPedidoCollection().add(pedido);
                idClienteNew = em.merge(idClienteNew);
            }
            if (formaDePagamentoOld != null && !formaDePagamentoOld.equals(formaDePagamentoNew)) {
                formaDePagamentoOld.getPedidoCollection().remove(pedido);
                formaDePagamentoOld = em.merge(formaDePagamentoOld);
            }
            if (formaDePagamentoNew != null && !formaDePagamentoNew.equals(formaDePagamentoOld)) {
                formaDePagamentoNew.getPedidoCollection().add(pedido);
                formaDePagamentoNew = em.merge(formaDePagamentoNew);
            }
            for (ItemPedido itemPedidoCollectionNewItemPedido : itemPedidoCollectionNew) {
                if (!itemPedidoCollectionOld.contains(itemPedidoCollectionNewItemPedido)) {
                    Pedido oldIdPedidoOfItemPedidoCollectionNewItemPedido = itemPedidoCollectionNewItemPedido.getIdPedido();
                    itemPedidoCollectionNewItemPedido.setIdPedido(pedido);
                    itemPedidoCollectionNewItemPedido = em.merge(itemPedidoCollectionNewItemPedido);
                    if (oldIdPedidoOfItemPedidoCollectionNewItemPedido != null && !oldIdPedidoOfItemPedidoCollectionNewItemPedido.equals(pedido)) {
                        oldIdPedidoOfItemPedidoCollectionNewItemPedido.getItemPedidoCollection().remove(itemPedidoCollectionNewItemPedido);
                        oldIdPedidoOfItemPedidoCollectionNewItemPedido = em.merge(oldIdPedidoOfItemPedidoCollectionNewItemPedido);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pedido.getId();
                if (findPedido(id) == null) {
                    throw new NonexistentEntityException("The pedido with id " + id + " no longer exists.");
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
            Pedido pedido;
            try {
                pedido = em.getReference(Pedido.class, id);
                pedido.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pedido with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<ItemPedido> itemPedidoCollectionOrphanCheck = pedido.getItemPedidoCollection();
            for (ItemPedido itemPedidoCollectionOrphanCheckItemPedido : itemPedidoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Pedido (" + pedido + ") cannot be destroyed since the ItemPedido " + itemPedidoCollectionOrphanCheckItemPedido + " in its itemPedidoCollection field has a non-nullable idPedido field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Cliente idCliente = pedido.getIdCliente();
            if (idCliente != null) {
                idCliente.getPedidoCollection().remove(pedido);
                idCliente = em.merge(idCliente);
            }
            FormaDePagamento formaDePagamento = pedido.getFormaDePagamento();
            if (formaDePagamento != null) {
                formaDePagamento.getPedidoCollection().remove(pedido);
                formaDePagamento = em.merge(formaDePagamento);
            }
            em.remove(pedido);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pedido> findPedidoEntities() {
        return findPedidoEntities(true, -1, -1);
    }

    public List<Pedido> findPedidoEntities(int maxResults, int firstResult) {
        return findPedidoEntities(false, maxResults, firstResult);
    }

    private List<Pedido> findPedidoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pedido.class));
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

    public Pedido findPedido(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Pedido.class, id);
        } finally {
            em.close();
        }
    }

    public int getPedidoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pedido> rt = cq.from(Pedido.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}