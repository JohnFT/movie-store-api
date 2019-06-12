package ejb;

import domain.MovieBean;
import domain.RentalBean;
import domain.StockBean;
import dto.Rent;
import utilities.SendEmail;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Stateless(name = "RentalEJB")
public class RentalEjbBean {

    private EntityManagerFactory emf = null;
    private EntityManager em = null;
    private SendEmail sendEmail;
    @Inject
    StockEjbBean bean;


    public RentalEjbBean() {
        emf = Persistence.createEntityManagerFactory("MovieStoreApiPU");
        em = emf.createEntityManager();
        sendEmail = new SendEmail();
    }

    public List<RentalBean> getAll() {

        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(MovieBean.class));
        Query q = em.createQuery(cq);
        return q.getResultList();
    }

    public RentalBean findById(Integer id) {
        return this.em.find(RentalBean.class, id);
    }


    public RentalBean add(Rent ren) {
        try {

            StockBean stock = this.bean.rent(ren.getMovie());

            if (stock == null) {
                return null;
            }

            RentalBean rental = new RentalBean();
            rental.setAccount(ren.getAccount());
            rental.setDeliveryDate(ren.getDeliveryDate());
            rental.setDays(ren.getDays());
            rental.setInitDate(ren.getInitDate());
            rental.setPrice(ren.getPrice());
            rental.setStock(stock.getId());


            em.getTransaction().begin();
            em.persist(rental);
            em.getTransaction().commit();

            sendEmail.send("jafonsecat@unincca.edu.co", "johnafonseca@gmail.com");
            return rental;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }


    public RentalBean update(RentalBean rental) {
        try {
            RentalBean ren = (RentalBean) this.em.find(RentalBean.class, rental.getId());

            if (ren == null) {
                return null;
            }
            em.getTransaction().begin();
            em.persist(rental);
            em.getTransaction().commit();
            return rental;
        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }


}
