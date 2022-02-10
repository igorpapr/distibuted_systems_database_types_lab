package com.databasestest.demo.model.postgres;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "educational_institution")
@Data
@ToString(exclude = "educationMapSet")
public class EducationalInstitution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "educationalInstitution")
    private Set<EducationMap> educationMapSet;

}
