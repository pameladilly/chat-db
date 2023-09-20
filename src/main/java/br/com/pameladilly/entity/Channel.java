package br.com.pameladilly.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Channel extends PanacheEntity {

    @ManyToMany(mappedBy = "channels", fetch = FetchType.EAGER)
    @JsonBackReference
    private List<User> users;
    private String hash;

    public Channel() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user){
        this.users.add(user);
    }
}
