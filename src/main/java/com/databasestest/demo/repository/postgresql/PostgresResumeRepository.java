package com.databasestest.demo.repository.postgresql;

import com.databasestest.demo.model.postgres.City;
import com.databasestest.demo.model.postgres.Resume;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface PostgresResumeRepository extends JpaRepository<Resume, Integer> {

    @Query("select r " +
            "from Resume r " +
            "join r.user u " +
            "where u.id = :userId")
    Set<Resume> findAllByCustomSqlQuery(Integer userId);

    @Query("select r.hobby " +
            "from Resume r "
    )
    List<String> findAllHobbies();

    @Query("select c " +
            "from Resume r " +
            "inner join r.city c"
    )
    Set<City> findAllCitiesInResumes();

    @Query("select r.hobby " +
            "from Resume r " +
            "where r.city.id = :cityId")
    List<String> findHobbiesByCity(int cityId);
}
