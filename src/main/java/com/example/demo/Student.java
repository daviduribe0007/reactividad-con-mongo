package com.example.demo;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "students")
public class Student {

    private String id;
    private String name;
    private List<Integer> scores;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public void setScores(List<Integer> scores) {
        this.scores = scores;
    }
}
