package com.example.demo.service;

import com.example.demo.model.Person;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class PersonService {

    private Map<String, Person> persons = new HashMap<>();

    public Person getById(String id) {
        return persons.get(id);
    }

    public Map<String, Person> getAll() {
        return Collections.unmodifiableMap(persons);
    }

    public Person create(Person data) {
        String id = UUID.randomUUID().toString();

        Person person = new Person();
        person.setId(id);
        person.setFirstName(data.getFirstName());
        person.setLastName(data.getLastName());

        persons.put(id, person);

        return person;
    }

    public Person update(String id, Person data) {
        Person person = getById(id);

        person.setFirstName(data.getFirstName());
        person.setLastName(data.getFirstName());

        persons.put(id, person);
        return person;
    }

    public void delete(String id) {
        persons.remove(id);
    }


}
