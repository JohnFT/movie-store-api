package controller;


import domain.AccountBean;
import dto.Credentials;
import ejb.AccountEjbBean;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/account")
public class AccountController {

    @Inject
    AccountEjbBean bean;


    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AccountBean logIn(Credentials cre) {
        return bean.logIn(cre);
    }


    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<AccountBean> getAll() {
        return bean.getAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AccountBean add(AccountBean actio) {
        return bean.add(actio);
    }

    @GET
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AccountBean add(@PathParam("id") Integer id) {
        return bean.findById(id);
    }
}
