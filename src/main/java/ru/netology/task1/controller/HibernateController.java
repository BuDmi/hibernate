package ru.netology.task1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.task1.model.Person;
import ru.netology.task1.repository.HibernateRepository;

import java.util.List;

@RestController
@RequestMapping("/")
public class HibernateController {

    private HibernateRepository hibernateRepository;

    public HibernateController(HibernateRepository hibernateRepository) {
        this.hibernateRepository = hibernateRepository;
    }

    @GetMapping("/persons/by-city")
    public List<Person> getPerson(@RequestParam String city) {
        return hibernateRepository.getPersonsByCity(city);
    }

    @GetMapping("init")
    public String init() {
        hibernateRepository.create();
        return "OK";
    }
}
