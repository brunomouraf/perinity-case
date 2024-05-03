package com.example.demo.Service;

import com.example.demo.Entity.Person;
import com.example.demo.Entity.Task;
import com.example.demo.Repository.PersonRepository;
import com.example.demo.Repository.TaskRepository;
import com.example.demo.Request.PersonRequest;
import com.example.demo.Response.ListPerson;
import com.example.demo.Response.ListSpentHours;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private PersonRepository personRepository;
    private TaskRepository taskRepository;

    public PersonService(TaskRepository taskRepository, PersonRepository personRepository) {
        this.taskRepository = taskRepository;
        this.personRepository = personRepository;
    }
    public Person savePerson(PersonRequest personRequest){
        try{
            Person person = personRequest.saveRequestObeject();
            return personRepository.save(person);

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

    public void deletePerson(int id){
        try{
            personRepository.delete(personRepository.findById(id));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<ListPerson> listPeople(){
        try{
            List<Person> list = new ArrayList<>();
            List<ListPerson> listPerson = new ArrayList<>();
            list = personRepository.findAll();
            int count = 0;

            for(int i = 0; i < list.size(); i++){

                List<Task> listTaskPerson = new ArrayList<>(taskRepository.findByPersonId(list.get(i).getId()));

                for(int j = 0; j < listTaskPerson.size(); j++){
                    count = count + listTaskPerson.get(j).getDeadline();
                }

                ListPerson person = new ListPerson();
                person.setName(list.get(i).getName());
                person.setDepartment(list.get(i).getDepartment().getDescription());
                person.setTotalHours(count);
                count = 0;
                listPerson.add(person);
            }
            return listPerson;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<ListSpentHours> listPeopleSpentHours(){
        try{
            List<Person> list = new ArrayList<>();
            List<ListSpentHours> listPerson = new ArrayList<>();
            list = personRepository.findAll();
            int count = 0;

            for(int i = 0; i < list.size(); i++){

                List<Task> listTaskPerson = new ArrayList<>(taskRepository.findByPersonId(list.get(i).getId()));

                for(int j = 0; j < listTaskPerson.size(); j++){
                    count = count + listTaskPerson.get(j).getDeadline();
                }

                int media;

                if(listTaskPerson.size() == 0){
                    media = 0;
                }else media = count / listTaskPerson.size();

                ListSpentHours person = new ListSpentHours();
                person.setName(list.get(i).getName());
                person.setAverageHours(media);
                count = 0;
                listPerson.add(person);
            }
            return listPerson;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
