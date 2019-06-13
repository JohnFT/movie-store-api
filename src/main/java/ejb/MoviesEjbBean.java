package ejb;


import domain.MovieBean;
import domain.StockBean;
import service.MovieBeanJpaController;

import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Stateless(name = "MoviesEJB")
public class MoviesEjbBean {

    MovieBeanJpaController beanController;
    private EntityManagerFactory emf = null;
    private EntityManager em = null;

    public MoviesEjbBean() {
        beanController = new MovieBeanJpaController(Persistence.createEntityManagerFactory("MovieStoreApiPU"));

        emf = Persistence.createEntityManagerFactory("MovieStoreApiPU");
        em = emf.createEntityManager();
    }

    public List<MovieBean> getAll() {
        return this.beanController.findMovieBeanEntities();
    }


    public List<MovieBean> getByIds(String ids) {

        List<StockBean> stocks = new ArrayList<>();
        List<MovieBean> movies = new ArrayList<>();
        Query query = this.em.createQuery("SELECT s FROM stock s WHERE s.id IN (" + ids + ")");

        try {
            stocks = (List<StockBean>) query.getResultList();

            String movs = null;

            for (StockBean stock : stocks) {
                movs = stock.getMovie() + " ,";
            }
            movs = movs.substring(0, movs.length() - 1);

            query = this.em.createQuery("SELECT s FROM movie s WHERE s.id IN(" + movs + ")");


            movies = (List<MovieBean>) query.getResultList();

        } catch (Exception e) {
            System.out.println(e);
        }

        return movies;
    }

    public MovieBean findById(Integer id) {
        return this.beanController.findMovieBean(id);
    }

    public MovieBean add(MovieBean movie) {
        return this.beanController.create(movie);
    }
}
