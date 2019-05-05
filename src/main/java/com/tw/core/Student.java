package com.tw.core;

import java.util.HashMap;

public class Student {
    private int id;
    private String name;
    private HashMap<String,Integer> grades;

    public Student(String name, int id){
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public void setId(int id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public HashMap<String,Integer> getGrades(){
        return grades;
    }

    public void setGrades(HashMap<String,Integer> grades){
        this.grades = grades;
    }
}
