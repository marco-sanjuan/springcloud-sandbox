package com.marco.usersservice.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name="roles")
public class Role implements Serializable {

   private static final long serialVersionUID = -7277774505433440064L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, length = 30)
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
