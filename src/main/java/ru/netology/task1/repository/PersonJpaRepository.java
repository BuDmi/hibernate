package ru.netology.task1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.task1.model.Person;
import ru.netology.task1.model.PersonKey;

import java.util.List;
import java.util.Optional;

public interface PersonJpaRepository extends JpaRepository<Person, PersonKey> {

    List<Person> findByCityOfLiving(String city);

    List<Person> findByAgeLessThanOrderByAge(int age);

    Optional<List<Person>> findByNameAndSurname(String name, String surname);
}
