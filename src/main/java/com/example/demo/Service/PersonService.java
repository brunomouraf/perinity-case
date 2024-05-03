package com.example.demo.Service;

import com.example.demo.Entity.Person;
import com.example.demo.Repository.PersonRepository;
import com.example.demo.Request.PersonRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person savePerson(PersonRequest personRequest){
        try{
            Person client = personRequest.saveRequestObeject();
            return personRepository.save(client);

        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Person updatePerson(PersonRequest personRequest) {

        try {
            Person person = personRepository.findById(personRequest.getId());
            person.setName(personRequest.getName());
            person.setDepartment(personRequest.getDepartment());
            return personRepository.save(person);

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
