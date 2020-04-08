package com.example.tasks.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Authority {

    public enum Type { ROLE_ADMIN, ROLE_USER, ROLE_API }

    @Id
    @Enumerated(EnumType.STRING)
    private Type type;

    private String name; // Rol Administrador varchar(255)

    @Lob
    private String description; // lorem ipsum

}
