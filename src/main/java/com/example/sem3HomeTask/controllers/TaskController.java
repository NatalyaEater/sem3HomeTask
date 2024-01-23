package com.example.sem3HomeTask.controllers;
import com.example.sem3HomeTask.domain.User;

import com.example.sem3HomeTask.services.DataProcessingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private DataProcessingService service;

    @GetMapping
    public List<String> getAllTasks()
    {
        List<String> tasks = new ArrayList<>();
        tasks.add("sort");
        tasks.add("filter");
        tasks.add("calc");
        return  tasks;
    }

    @GetMapping("/sort")//localhost:8080/tasks/sort
    public List<User> sortUsersByAge()
    {
        return service.sortUsersByAge(service.getRepository().getUsers());
    }

    /**
    * Чтобы вернуть ответ из обработчика, мы просто возвращаем объект, который
    * должен быть включен в тело ответа, используем  класс `ResponseEntity`
    * @PathVariable
    * Определение имени переменной path шаблона-
     * если имя переменной path отличается, мы указаыем его в аргументе аннотации @PathVariable:
     */
    @GetMapping("/filter/{age}")
    public ResponseEntity<List<User>> filterUsersByAge(@PathVariable("age") int age) {
        List<User> filteredUsers = service.filterUsersByAge(age);
        return ResponseEntity.ok(filteredUsers);
    }

    @GetMapping("/calc")
    public ResponseEntity<Double> calculateAverageAge() {
        double avgAge = service.calculateAverageAge(service.getRepository().getUsers());
        return ResponseEntity.ok(avgAge);
    }
}
