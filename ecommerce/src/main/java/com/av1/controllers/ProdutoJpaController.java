package com.av1.controllers;

import com.av1.controllers.exceptions.IllegalOrphanException;
import com.av1.controllers.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.av1.entities.ItemPedido;
import com.av1.entities.Produto;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * Controla as transições no banco de dados referentes à classe Produto.
 * Criado pela unidade de persistência.
 * @see Produto
 */
public class ProdutoJpaController implements Serializable {

    public ProdutoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produto produto) {
        if (produto.getItemPedidoCollection() == null) {
            produto.setItemPedidoCollection(new ArrayList<ItemPedido>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Collection<ItemPedido> attachedItemPedidoCollection = new ArrayList<ItemPedido>();
            for (ItemPedido itemPedidoCollectionItemPedidoToAttach : produto.getItemPedidoCollection()) {
                itemPedidoCollectionItemPedidoToAttach = em.getReference(itemPedidoCollectionItemPedidoToAttach.getClass(), itemPedidoCollectionItemPedidoToAttach.getId());
                attachedItemPedidoCollection.add(itemPedidoCollectionItemPedidoToAttach);
            }
            produto.setItemPedidoCollection(attachedItemPedidoCollection);
            em.persist(produto);
            for (ItemPedido itemPedidoCollectionItemPedido : produto.getItemPedidoCollection()) {
                Produto oldIdProdutoOfItemPedidoCollectionItemPedido = itemPedidoCollectionItemPedido.getIdProduto();
                itemPedidoCollectionItemPedido.setIdProduto(produto);
                itemPedidoCollectionItemPedido = em.merge(itemPedidoCollectionItemPedido);
                if (oldIdProdutoOfItemPedidoCollectionItemPedido != null) {
                    oldIdProdutoOfItemPedidoCollectionItemPedido.getItemPedidoCollection().remove(itemPedidoCollectionItemPedido);
                    oldIdProdutoOfItemPedidoCollectionItemPedido = em.merge(oldIdProdutoOfItemPedidoCollectionItemPedido);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Produto produto) throws IllegalOrphanException, NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Produto persistentProduto = em.find(Produto.class, produto.getId());
            Collection<ItemPedido> itemPedidoCollectionOld = persistentProduto.getItemPedidoCollection();
            Collection<ItemPedido> itemPedidoCollectionNew = produto.getItemPedidoCollection();
            List<String> illegalOrphanMessages = null;
            for (ItemPedido itemPedidoCollectionOldItemPedido : itemPedidoCollectionOld) {
                if (!itemPedidoCollectionNew.contains(itemPedidoCollectionOldItemPedido)) {
                    if (illegalOrphanMessages == null) {
                        illegalOrphanMessages = new ArrayList<String>();
                    }
                    illegalOrphanMessages.add("You must retain ItemPedido " + itemPedidoCollectionOldItemPedido + " since its idProduto field is not nullable.");
                }
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            Collection<ItemPedido> attachedItemPedidoCollectionNew = new ArrayList<ItemPedido>();
            for (ItemPedido itemPedidoCollectionNewItemPedidoToAttach : itemPedidoCollectionNew) {
                itemPedidoCollectionNewItemPedidoToAttach = em.getReference(itemPedidoCollectionNewItemPedidoToAttach.getClass(), itemPedidoCollectionNewItemPedidoToAttach.getId());
                attachedItemPedidoCollectionNew.add(itemPedidoCollectionNewItemPedidoToAttach);
            }
            itemPedidoCollectionNew = attachedItemPedidoCollectionNew;
            produto.setItemPedidoCollection(itemPedidoCollectionNew);
            produto = em.merge(produto);
            for (ItemPedido itemPedidoCollectionNewItemPedido : itemPedidoCollectionNew) {
                if (!itemPedidoCollectionOld.contains(itemPedidoCollectionNewItemPedido)) {
                    Produto oldIdProdutoOfItemPedidoCollectionNewItemPedido = itemPedidoCollectionNewItemPedido.getIdProduto();
                    itemPedidoCollectionNewItemPedido.setIdProduto(produto);
                    itemPedidoCollectionNewItemPedido = em.merge(itemPedidoCollectionNewItemPedido);
                    if (oldIdProdutoOfItemPedidoCollectionNewItemPedido != null && !oldIdProdutoOfItemPedidoCollectionNewItemPedido.equals(produto)) {
                        oldIdProdutoOfItemPedidoCollectionNewItemPedido.getItemPedidoCollection().remove(itemPedidoCollectionNewItemPedido);
                        oldIdProdutoOfItemPedidoCollectionNewItemPedido = em.merge(oldIdProdutoOfItemPedidoCollectionNewItemPedido);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = produto.getId();
                if (findProduto(id) == null) {
                    throw new NonexistentEntityException("The produto with id " + id + " no longer exists.");
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
            Produto produto;
            try {
                produto = em.getReference(Produto.class, id);
                produto.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produto with id " + id + " no longer exists.", enfe);
            }
            List<String> illegalOrphanMessages = null;
            Collection<ItemPedido> itemPedidoCollectionOrphanCheck = produto.getItemPedidoCollection();
            for (ItemPedido itemPedidoCollectionOrphanCheckItemPedido : itemPedidoCollectionOrphanCheck) {
                if (illegalOrphanMessages == null) {
                    illegalOrphanMessages = new ArrayList<String>();
                }
                illegalOrphanMessages.add("This Produto (" + produto + ") cannot be destroyed since the ItemPedido " + itemPedidoCollectionOrphanCheckItemPedido + " in its itemPedidoCollection field has a non-nullable idProduto field.");
            }
            if (illegalOrphanMessages != null) {
                throw new IllegalOrphanException(illegalOrphanMessages);
            }
            em.remove(produto);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Produto> findProdutoEntities() {
        return findProdutoEntities(true, -1, -1);
    }

    public List<Produto> findProdutoEntities(int maxResults, int firstResult) {
        return findProdutoEntities(false, maxResults, firstResult);
    }

    private List<Produto> findProdutoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produto.class));
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

    public Produto findProduto(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produto.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produto> rt = cq.from(Produto.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
}