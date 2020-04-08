package com.example.tasks.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
public class Log implements Serializable {

    public enum Type { INFO, ERROR }

    @Id
    @GeneratedValue
    private Long id;

    private String message;

    @Enumerated(EnumType.STRING)
    private Type type;


}
