package ru.netology.task1.repository;

import org.springframework.stereotype.Repository;
import ru.netology.task1.model.Person;

import java.util.List;
import java.util.Optional;

@Repository
public class HibernateRepository {

    private final PersonJpaRepository personJpaRepository;

    public HibernateRepository(PersonJpaRepository personJpaRepository) {
        this.personJpaRepository = personJpaRepository;
    }

    public List<Person> getPersonsByCity(String city) {
        return personJpaRepository.findByCityOfLiving(city);
    }

    public List<Person> getPersonsByAge(int age) {
        return personJpaRepository.findByAgeLessThanOrderByAge(age);
    }

    public Optional<List<Person>> getPersonsByNameAndSurname(String name, String surname) {
        return personJpaRepository.findByNameAndSurname(name, surname);
    }
}
