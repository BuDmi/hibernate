package ru.netology.task1.repository;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import ru.netology.task1.model.Person;
import ru.netology.task1.model.PersonKey;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class HibernateRepository {
    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public void create() {
        List<Person> p = new ArrayList<>();

        p.add(new Person(new PersonKey("Ivan", "Ivanov", "3"), "1253235325", "Moscow"));
        p.add(new Person(new PersonKey("Alexey", "Petrov", "5"), "906846654", "Kazan"));
        p.add(new Person(new PersonKey("Dima", "Sovolev", "4"), "64565464566", "Minsk"));

        p.forEach(entity -> entityManager.persist(entity));
    }

    private static String read(String scriptFileName) {
        try (InputStream is = new ClassPathResource(scriptFileName).getInputStream();
             BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
            return bufferedReader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Transactional
    public List<Person> getPersonsByCity(String city) {
        String query = "SELECT p FROM Person p WHERE p.cityOfLiving = :city";
        TypedQuery<Person> typedQuery = entityManager.createQuery(query, Person.class);
        typedQuery.setParameter("city", city);
        return typedQuery.getResultList();

    }
}
