package com.example.demo.Controller;

import com.example.demo.Entity.Person;
import com.example.demo.Request.PersonRequest;
import com.example.demo.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/register-person")
    public ResponseEntity<Person> registerPerson(@RequestBody PersonRequest personRequest){
        Person person = personService.savePerson(personRequest);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @PutMapping("/update-person")
    public ResponseEntity<Person> updatePerson(@RequestBody PersonRequest personRequest){
        Person person = personService.updatePerson(personRequest);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @DeleteMapping("/delete-person/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable int id){
        personService.deletePerson(id);
        return ResponseEntity.ok("Deletado com sucesso.");
    }

}
