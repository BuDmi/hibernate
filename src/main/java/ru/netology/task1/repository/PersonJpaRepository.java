package ru.netology.task1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.netology.task1.model.Person;
import ru.netology.task1.model.PersonKey;

import java.util.List;
import java.util.Optional;

public interface PersonJpaRepository extends JpaRepository<Person, PersonKey> {

    @Query("select P from Person p where p.cityOfLiving = :city")
    List<Person> findByCityOfLiving(@Param("city") String city);

    @Query("select p from Person p where p.age < :age order by p.age")
    List<Person> findByAgeLessThanOrderByAge(@Param("age") int age);

    @Query("select p from Person p where p.name = :name and p.surname = :surname")
    Optional<List<Person>> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}
