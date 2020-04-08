package com.example.tasks.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.ZonedDateTime;

@Entity
@Data
public class Token {

    @Id
    @GeneratedValue
    private Long id;

    private String uuid;

    @ManyToOne
    private User user;

    private ZonedDateTime timestamp;

}
