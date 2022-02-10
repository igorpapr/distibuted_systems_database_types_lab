package com.databasestest.demo.model.postgres;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class EducationMapId implements Serializable {

    @Column(name = "institution_id")
    private Integer institutionId;

    @Column(name = "resume_id")
    private Integer resumeId;

}
