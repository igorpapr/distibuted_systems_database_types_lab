package com.databasestest.demo.model.postgres;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "education_map")
@Getter
@Setter
@ToString(exclude = {"resume", "educationalInstitution"})
public class EducationMap {

    @EmbeddedId
    private EducationMapId educationMapId;

    @Column(name = "degree")
    private String degree;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("institutionId")
    @JoinColumn(name = "institution_id")
    private EducationalInstitution educationalInstitution;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("resumeId")
    @JoinColumn(name = "resume_id")
    private Resume resume;

}
