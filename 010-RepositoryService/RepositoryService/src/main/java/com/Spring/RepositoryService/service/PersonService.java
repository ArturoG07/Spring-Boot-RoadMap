package com.Spring.RepositoryService.service;

import com.Spring.RepositoryService.model.Person;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Class that will contain all methods needed to manage the logic, importing them from an interface and overriding them
 */
@Service
public class PersonService implements IPersonService {

    @Override
    public void createPerson(Person per) {
        System.out.println("Person created!");
    }

    @Override
    public List<Person> getPersons() {
        throw new UnsupportedOperationException("To be created");
    }
}
