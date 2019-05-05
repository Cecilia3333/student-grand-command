package com.tw.CoreTest;

import com.tw.core.Student;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class StudentTest {
    @Test
    public void should_get_name() throws Exception {
        Student student = new Student("Tom",1);
        assertEquals("Tom",student.getName());
    }
    @Test
    public void should_get_id() throws Exception {
        Student student = new Student("Tom",1);
        assertEquals(1,student.getId());
    }

    @Test
    public void should_get_grades() throws Exception {
        HashMap<String, Integer> grades = new HashMap<String, Integer>() {
            {
                put("语文", 80);
                put("数学", 70);
            }
        };
        Student student = new Student("Tom",1);
        student.setGrades(grades);
        assertEquals(grades,student.getGrades());
    }
}
