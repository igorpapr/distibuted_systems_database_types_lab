package com.databasestest.demo.model.postgres;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "\"user\"")
@Data
@ToString(exclude = "resume")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @OneToOne(mappedBy = "user", fetch = FetchType.LAZY)
    private Resume resume;

}
