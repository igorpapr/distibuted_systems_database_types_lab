package com.databasestest.demo.model.postgres;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "resume")
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "contact_info")
    private String contactInfo;

    @Column(name = "hobby")
    private String hobby;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(referencedColumnName = "id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(referencedColumnName = "id")
    private City city;

    @OneToMany(mappedBy = "resume")
    private Set<EducationMap> educationMapSet;

    @Override
    public String toString() {
        return "Resume{" +
                "id=" + id +
                ", contactInfo='" + contactInfo + '\'' +
                ", hobby='" + hobby + '\'' +
                ", user=" + user +
                ", city=" + city +
                ", educations: " +
                (educationMapSet != null
                ? educationMapSet.stream()
                        .map(education -> education.getEducationalInstitution() + " -- degree: " + education.getDegree())
                        .collect(Collectors.toList()).toString()
                : ("[]")) +
                '}';
    }
}
