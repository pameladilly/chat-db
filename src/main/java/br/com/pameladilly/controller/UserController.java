package br.com.pameladilly.controller;

import br.com.pameladilly.entity.User;
import br.com.pameladilly.repository.UserRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;

import java.util.List;

@Path("/api/user")
@Transactional
public class UserController {

    @Inject
    UserRepository repository;

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public User save(@FormParam("name") String name) {

        User user = new User();
        user.setName(name);


        repository.persist(user);
        return user;
    }

    @GET
    @Path("/list")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> list(){
        return repository.listAll();
    }

    @GET
    @Path("/list/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public User list(@PathParam("id") Long id){
        return repository.findById(id);
    }
}
