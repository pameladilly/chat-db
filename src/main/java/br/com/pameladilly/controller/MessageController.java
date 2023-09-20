package br.com.pameladilly.controller;

import br.com.pameladilly.entity.Message;
import br.com.pameladilly.entity.User;
import br.com.pameladilly.repository.MessageRepository;
import br.com.pameladilly.repository.UserRepository;
import io.quarkus.runtime.annotations.CommandLineArguments;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.Optional;

@Path("/api/message")
@Transactional
public class MessageController {

    @Inject
    MessageRepository repository;

    @Inject
    UserRepository userRepository;

    @POST
    @Path("/save")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_JSON)
    public Message save(@FormParam("text") String text, @FormParam("idUser") Long idUser){
        Message message = new Message();
        message.setText(text);

        repository.persistAndFlush(message);
        User user = Optional.ofNullable(userRepository.findById(idUser))
                .orElseThrow( () -> new BadRequestException("User not found!"));

        user.addMessage(message);
        userRepository.persistAndFlush(user);

        return message;

    }
}
