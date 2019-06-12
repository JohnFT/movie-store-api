package controller;

import domain.PersonBean;
import ejb.PersonEjbBean;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/person")
public class PersonController {

    @Inject
    PersonEjbBean bean;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonBean> getAll() {
        return this.bean.getAll();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PersonBean add(PersonBean person) {
        return this.bean.add(person);
    }
}
