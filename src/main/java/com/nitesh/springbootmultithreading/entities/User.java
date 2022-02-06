package com.nitesh.springbootmultithreading.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String email;
    private String gender;
}
