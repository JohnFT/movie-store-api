package controller;

import domain.StockBean;
import ejb.StockEjbBean;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("stock")
public class StockController {

    @Inject
    StockEjbBean bean;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<StockBean> getAll() {
        return this.bean.getAll();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public StockBean getAll(@PathParam("id") Integer id) {
        return this.bean.findById(id);
    }


    @GET
    @Path("/count/movies/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Long getCountByMovie(@PathParam("id") Integer id) {
        return this.bean.getCountByMovie(id);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public StockBean add(StockBean stock) {
        return this.bean.add(stock);
    }





}
