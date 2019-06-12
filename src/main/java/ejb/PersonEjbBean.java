package ejb;

import domain.PersonBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Stateless(name = "PersonEJB")
public class PersonEjbBean {

    private EntityManagerFactory emf = null;
    private EntityManager em = null;
    public PersonEjbBean(){
        emf = Persistence.createEntityManagerFactory("MovieStoreApiPU");
        em = emf.createEntityManager();
    }
    public List<PersonBean> getAll(){
        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(PersonBean.class));
        Query q = em.createQuery(cq);
        return q.getResultList();
    }

    public PersonBean findById(Integer id){
        return this.em.find(PersonBean.class, id);
    }


    public PersonBean add(PersonBean person){

        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
            return  person;
        } catch (Exception e){
            System.out.println(e);
        }

        return null;
    }
}
