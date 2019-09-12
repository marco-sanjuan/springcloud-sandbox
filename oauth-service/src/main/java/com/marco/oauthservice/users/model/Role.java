package com.marco.oauthservice.users.model;

import java.io.Serializable;

public class Role implements Serializable {

   private static final long serialVersionUID = -7277774505433440064L;

    private Long id;

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
