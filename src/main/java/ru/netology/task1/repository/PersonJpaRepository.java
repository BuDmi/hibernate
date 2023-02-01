package ru.netology.task1.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ru.netology.task1.model.Person;
import ru.netology.task1.model.PersonKey;

import java.util.List;
import java.util.Optional;

public interface PersonJpaRepository extends JpaRepository<Person, PersonKey> {
    List<Person> findByCityOfLiving(String city);

    @Query("select p from Person p where p.personKey.age < :age order by p.personKey.age")
    List<Person> findPersonWithLessThanAgeAndOrderByAge(@Param("age") int age);

    @Query("select p from Person p where p.personKey.name = :name and p.personKey.surname = :surname")
    Optional<List<Person>> findByNameAndSurname(@Param("name") String name, @Param("surname") String surname);
}
