package ejb;


import domain.AccountBean;
import domain.MovieBean;
import domain.RentalBean;
import dto.Credentials;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Stateless(name = "AccountEJB" )
public class AccountEjbBean {

    private EntityManagerFactory emf = null;
    private EntityManager em = null;
    public AccountEjbBean(){
        emf = Persistence.createEntityManagerFactory("MovieStoreApiPU");
        em = emf.createEntityManager();
    }

    public List<AccountBean> getAll(){

        CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(AccountBean.class));
        Query q = em.createQuery(cq);
        return q.getResultList();
    }

    public AccountBean logIn(Credentials cre){
        AccountBean account = null;
        String sql = "SELECT u FROM account u WHERE u.username=:username AND u.password=:password";
        Query query = em.createQuery(sql);
        query.setParameter("username", cre.user);
        query.setParameter("password", cre.pass);
        try{
            account = (AccountBean) query.getSingleResult();
        }catch (Exception e){
            System.out.println(e);
        }

        return account;
    }

    public AccountBean findById(Integer id){
        return this.em.find(AccountBean.class, id);
    }


    public AccountBean add(AccountBean account){
        try {
            em.getTransaction().begin();
            em.persist(account);
            em.getTransaction().commit();
            return  account;
        } catch (Exception e){
            System.out.println(e);
        }

        return null;
    }
}


