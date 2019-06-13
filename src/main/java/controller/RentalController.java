package controller;


import domain.RentalBean;
import dto.Rent;
import ejb.RentalEjbBean;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/rental")
public class RentalController {

    @Inject
    RentalEjbBean bean;


    @GET()
    @Produces(MediaType.APPLICATION_JSON)
    public List<RentalBean> getAll(){
        return this.bean.getAll();
    }



    @GET()
    @Path("account/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<RentalBean> fiendByUser(@PathParam("id") Integer id ){
        return this.bean.findByUser(id);
    }

    @GET()
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public RentalBean fiendById(@PathParam("id") Integer id ){
        return this.bean.findById(id);
    }



    @POST()
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RentalBean add(Rent rental){
        return this.bean.add(rental);
    }

    @PUT()
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public RentalBean update(RentalBean rental){
        return this.bean.update(rental);
    }
}
