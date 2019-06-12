/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.MovieBean;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import service.exceptions.NonexistentEntityException;

/**
 *
 * @author John
 */
public class MovieBeanJpaController implements Serializable {

    public MovieBeanJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public MovieBean create(MovieBean movieBean) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(movieBean);
            em.getTransaction().commit();
            return  movieBean;
        } catch (Exception e){
        System.out.println(e);
        }finally {
            if (em != null) {
                em.close();
            }
        }
        return null;
    }

    public void edit(MovieBean movieBean) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            movieBean = em.merge(movieBean);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = movieBean.getId();
                if (findMovieBean(id) == null) {
                    throw new NonexistentEntityException("The movieBean with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            MovieBean movieBean;
            try {
                movieBean = em.getReference(MovieBean.class, id);
                movieBean.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The movieBean with id " + id + " no longer exists.", enfe);
            }
            em.remove(movieBean);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<MovieBean> findMovieBeanEntities() {
        return findMovieBeanEntities(true, -1, -1);
    }

    public List<MovieBean> findMovieBeanEntities(int maxResults, int firstResult) {
        return findMovieBeanEntities(false, maxResults, firstResult);
    }

    private List<MovieBean> findMovieBeanEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(MovieBean.class));
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

    public MovieBean findMovieBean(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(MovieBean.class, id);
        } finally {
            em.close();
        }
    }

    public int getMovieBeanCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<MovieBean> rt = cq.from(MovieBean.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
