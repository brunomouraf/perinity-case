package com.example.demo.Service;

import com.example.demo.Entity.Person;
import com.example.demo.Repository.PersonRepository;
import com.example.demo.Request.CreatePersonRequest;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person savePerson(CreatePersonRequest createPersonRequest){
        Person client = createPersonRequest.saveRequestObeject();

        return personRepository.save(client);
    }
}
