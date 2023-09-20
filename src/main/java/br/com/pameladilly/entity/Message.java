package br.com.pameladilly.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Message extends PanacheEntity {

    private String text;
//    @Getter
//    private Long id;
//
//    public void setId(Long id) {
//        this.id = id;
//    }
}
