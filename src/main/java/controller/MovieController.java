package controller;

import domain.MovieBean;
import ejb.MoviesEjbBean;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

@Path("/movie")
public class MovieController {

    @Inject
    private MoviesEjbBean moviesEJB;


    @GET
    @Produces("application/json")
    public  List<MovieBean> getAll(){

        return this.moviesEJB.getAll();
    }

    @GET
    @Path("all")
    @Produces("application/json")
    public  List<MovieBean> getAll(@QueryParam("ids") String ids){

        return this.moviesEJB.getByIds(ids);
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public MovieBean add(MovieBean movie){

        return this.moviesEJB.add(movie);
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public MovieBean findById(@PathParam("id") Integer id){

        return this.moviesEJB.findById(id);
    }


}