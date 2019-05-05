package com.tw.CoreTest;/*
 * This Java source file was generated by the Gradle 'init' task.
 */

import com.tw.core.Report;
import com.tw.core.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReportTest {
    @Test
    public void should_give_distinct_class_name() {
        List<Student> students = new ArrayList<>();
        for (int i = 1; i < 3; i++) {
            Student student = mock(Student.class);
            when(student.getId()).thenReturn(i);
            when(student.getName()).thenReturn("stu"+i);
            when(student.getGrades()).thenReturn(new HashMap<String, Integer>() {
                {
                    put("语文", 80);
                    put("数学", 70);
                }
            });
            students.add(student);
        }

        Report report = new Report(students);
        String expected = "成绩单\n" +
                "姓名/数学/语文/平均分/总分\n" +
                "========================\n" +
                "stu1/70/80/75.0/150\n" +
                "stu2/70/80/75.0/150\n" +
                "========================\n" +
                "全班总分平均数：150.0\n" +
                "全班总分中位数：150.0";
        assertEquals(expected,report.getReport());
    }

}