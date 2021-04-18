package io.zipcoder.crudapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository repository;

    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public Iterable<Person> index() {
        return repository.findAll();
    }

    public Person show(Long id) {
        return repository.findOne(id);
    }

    public Person create(Person person) {
        return repository.save(person);
    }

    public Person update(Long id, Person newPersonData) {
        Person ogPerson = repository.findOne(id);
        ogPerson.setFirstName(newPersonData.getFirstName());
        ogPerson.setLastName(newPersonData.getLastName());
        return repository.save(ogPerson);
    }

    public Boolean delete(Long id) {
        repository.delete(id);
        return true;
    }
}
