package ejb;


import domain.MovieBean;
import service.MovieBeanJpaController;
import javax.ejb.Stateless;
import javax.persistence.*;
import java.util.List;

@Stateless(name = "MoviesEJB" )
public class MoviesEjbBean {

    MovieBeanJpaController beanController;
    public MoviesEjbBean() {
        beanController = new MovieBeanJpaController(Persistence.createEntityManagerFactory("MovieStoreApiPU"));
    }

    public List<MovieBean> getAll(){
        return  this.beanController.findMovieBeanEntities();
    }


    public MovieBean findById(Integer id){
        return  this.beanController.findMovieBean(id);
    }

    public MovieBean add(MovieBean movie){ return  this.beanController.create(movie); }
}
