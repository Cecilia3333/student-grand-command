package com.tw.controller;

import com.tw.command.Input;
import com.tw.core.Report;
import com.tw.core.Student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

public class App {
    private List<Student> students = new ArrayList<>();
    private Report report;

    public void start() throws IOException {
        boolean flag = true;
        while(flag){
            List<String> inputs = new Input().input();

            switch (inputs.get(0)){
                case "1":
                    addStudents(inputs.get(1));
                    break;
                case "2":
                    printReport(inputs.get(1));
                    break;
                case "3":
                    flag = false;
                    break;
            }
        }
    }

    private void addStudents(String str){
        String[] inputs = str.split(",");
        Student stu = new Student(inputs[0],parseInt(inputs[1]));
        HashMap<String, Integer> grades = new HashMap<String, Integer>();

        for (int i = 2; i < inputs.length; i++) {
            String[] grade = inputs[i].split(":");
            grades.put(grade[0],parseInt(grade[1]));
        }
        stu.setGrades(grades);
        students.add(stu);
        System.out.printf("学生%s的成绩被添加\n",stu.getName());
    }

    private void printReport(String str){
        List<Student> printStudents = new ArrayList<Student>();

        List<Integer> inputs = Arrays.stream(str.split(","))
                                .map(id->parseInt(id)).collect(Collectors.toList());

        for (Integer i:inputs
             ) {
            for (int j = 0; j < students.size(); j++) {
                if(i == students.get(j).getId()){
                    printStudents.add(students.get(j));
                    break;
                }
            }
        }
        System.out.println(new Report(printStudents).getReport());
    }


}
