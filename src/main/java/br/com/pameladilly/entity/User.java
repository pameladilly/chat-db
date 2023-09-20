package br.com.pameladilly.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class User extends PanacheEntity {

    @Getter
    private String name;
    private String hash;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Channel> channels;

    public void addMessage(Message message){
        this.messages.add(message);
    }

    @JoinColumn(name = "user_id")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Message> messages;

    public User() {
        this.channels = new ArrayList<>();
        this.messages = new ArrayList<>();
    }
}
