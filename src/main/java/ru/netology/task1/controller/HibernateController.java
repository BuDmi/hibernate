package ru.netology.task1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.task1.model.Person;
import ru.netology.task1.repository.HibernateRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class HibernateController {

    private final HibernateRepository hibernateRepository;

    public HibernateController(HibernateRepository hibernateRepository) {
        this.hibernateRepository = hibernateRepository;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPerson(@RequestParam String city) {
        return hibernateRepository.getPersonsByCity(city);
    }

    @GetMapping("/persons/by-age")
    public List<Person> getPersonsByAge(@RequestParam int age) {
        return hibernateRepository.getPersonsByAge(age);
    }

    @GetMapping("/persons/by-name-and-surname")
    public Optional<List<Person>> getPersonsByNameAndSurname(@RequestParam String name, @RequestParam String surname) {
        return hibernateRepository.getPersonsByNameAndSurname(name, surname);
    }
}
