package com.Spring.RepositoryService.service;

import com.Spring.RepositoryService.model.Person;

import java.util.List;

/**
 * Interface that will provide all methods used by the PersonService class
 */
public interface IPersonService {
    public void createPerson (Person per);
    public List<Person> getPersons();
}

