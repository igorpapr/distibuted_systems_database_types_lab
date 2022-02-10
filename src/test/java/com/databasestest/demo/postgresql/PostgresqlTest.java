package com.databasestest.demo.postgresql;

import com.databasestest.demo.model.postgres.City;
import com.databasestest.demo.model.postgres.Resume;
import com.databasestest.demo.model.postgres.User;
import com.databasestest.demo.repository.postgresql.PostgresEducationalInstitutionRepository;
import com.databasestest.demo.repository.postgresql.PostgresResumeRepository;
import com.databasestest.demo.repository.postgresql.PostgresUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@SpringBootTest
@Transactional
@TestPropertySource("classpath:postgres-application.properties")
public class PostgresqlTest {

    @Autowired
    private PostgresResumeRepository resumeRepository;
    @Autowired
    private PostgresUserRepository userRepository;
    @Autowired
    private PostgresEducationalInstitutionRepository postgresEducationalInstitutionRepository;

    @Test
    void testGetResumes() {
        Set<Resume> resumes = resumeRepository.findAllByCustomSqlQuery(1);
        resumes.forEach(resume -> System.out.println(resume.toString()));
    }

    @Test
    void testGetAllHobbies() {
        List<String> hobbies = resumeRepository.findAllHobbies();
        System.out.println("Found hobbies: ");
        hobbies.forEach(System.out::println);
    }

    @Test
    void testGetAllCities() {
        Set<City> cities = resumeRepository.findAllCitiesInResumes();
        System.out.println("Found cities in resumes: ");
        System.out.println(cities);
    }

    @Test
    void testFindHobbiesOfThoseWhoLiveInCity() {
        List<String> foundHobbies = resumeRepository.findHobbiesByCity(1);
        System.out.println("Found hobbies in Kyiv: ");
        foundHobbies.forEach(System.out::println);
    }

    @Test
        /*забрати всіх здобувачів, що працювали в одному закладі (заклад ми не вказуємо)
        * у цій моделі цього досягнути важко - не вказувати заклад, лише пробувати розташувати їх по черзі,
        * у даному випадку все-ж-таки вкажемо заклад
        * */
    void testFindUsersWhoStudiedInTheSameUniversity() {
        Set<User> users = userRepository.findUsersWhoStudiedInSameInstitution(1);
        System.out.println("Found users: ");
        System.out.println(users);
    }
}
