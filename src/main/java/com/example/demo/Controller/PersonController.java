package com.example.demo.Controller;

import com.example.demo.Entity.Person;
import com.example.demo.Request.CreatePersonRequest;
import com.example.demo.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/register-person")
    public ResponseEntity<Person> registrarUsuario(@RequestBody CreatePersonRequest createPersonRequest){
        Person person = personService.savePerson(createPersonRequest);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }
}
