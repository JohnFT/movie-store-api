package ejb;


import domain.MovieBean;
import domain.RentalBean;
import domain.StockBean;

import javax.ejb.Stateless;
import javax.persistence.*;
import javax.persistence.criteria.CriteriaQuery;
import java.util.Arrays;
import java.util.List;

@Stateless(name = "StockEJB")
public class StockEjbBean {

    private EntityManagerFactory emf = null;
    private EntityManager em = null;

    public StockEjbBean() {
        emf = Persistence.createEntityManagerFactory("MovieStoreApiPU");
        em = emf.createEntityManager();
    }

    public List<StockBean> getAll() {

        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(MovieBean.class));
        Query q = em.createQuery(cq);
        return q.getResultList();
    }

    public StockBean findById(Integer id) {
        return this.em.find(StockBean.class, id);
    }

    public Long getCountByMovie(Integer id) {
        TypedQuery<Long> query = em.createQuery(
                "SELECT COUNT(c) FROM stock c WHERE c.movie=:movie", Long.class);
        query.setParameter("movie", id);

        return (Long) query.getSingleResult();
    }


    public StockBean add(StockBean stock) {
        try {
            em.getTransaction().begin();
            em.persist(stock);
            em.getTransaction().commit();
            return stock;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public StockBean update(StockBean stock) {
        try {
            StockBean stoc = (StockBean) this.em.find(StockBean.class, stock.getId());

            if (stoc == null) {
                return null;
            }

            em.getTransaction().begin();
            em.merge(stock);
            em.getTransaction().commit();

            return stoc;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }


    public StockBean rent(Integer movie) {
        try {
            Query query = em.createQuery("SELECT u FROM stock u where  u.movie=:movie and u.state = 1");
            query.setParameter("movie", movie);
            List<StockBean> stocs = query.getResultList();

            if (stocs == null || stocs.size() == 0) {
                return null;
            }
            StockBean stoc = stocs.get(0);
            stoc.setState(2);

            return update(stoc);

        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
}
