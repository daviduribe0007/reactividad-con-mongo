package com.example.demo.controllers;

import com.example.demo.entities.Student;
import com.example.demo.repository.StudentReactiveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.spring5.context.webflux.ReactiveDataDriverContextVariable;
import reactor.core.publisher.Flux;

import java.time.Duration;

@Controller
public class StudentListController {

    @Autowired
    private StudentReactiveRepository repository;

    @GetMapping("/list-students")
    public String listStudents(Model model){
        Flux<Student> flux = repository.findAll();
        model.addAttribute("students", flux);
        return "students";
    }

    @GetMapping("/list-students-reactive")
    public String listUsersReactive(Model model)
    {
        Flux<Student> userFlux = repository.findAll().delayElements(Duration.ofSeconds(1));
        model.addAttribute("students", new ReactiveDataDriverContextVariable(userFlux, 1));
        return "students";
    }

    @GetMapping("/list-students-reactive2")
    public String listUsersReactive2(Model model)
    {
        Flux<Student> userFlux = repository.findAll().delayElements(Duration.ofSeconds(1));
        model.addAttribute("students", new ReactiveDataDriverContextVariable(userFlux, 50));
        return "students";
    }
}