package com.databasestest.demo.repository.postgresql;

import com.databasestest.demo.model.postgres.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Set;

public interface PostgresUserRepository extends JpaRepository<User, Integer> {

    @Query("select u " +
            "from User u " +
            "inner join u.resume r " +
            "inner join r.educationMapSet e " +
            "where e.educationalInstitution.id = :institutionId")
    Set<User> findUsersWhoStudiedInSameInstitution(Integer institutionId);
}
