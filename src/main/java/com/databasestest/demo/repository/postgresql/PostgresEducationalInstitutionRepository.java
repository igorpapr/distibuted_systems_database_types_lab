package com.databasestest.demo.repository.postgresql;

import com.databasestest.demo.model.postgres.EducationalInstitution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresEducationalInstitutionRepository extends JpaRepository<EducationalInstitution, Integer> {
}
