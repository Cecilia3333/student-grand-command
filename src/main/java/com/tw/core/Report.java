package com.tw.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Report {
    private List<Student> students;

    public Report(List<Student> students) {
        this.students = students;
    }

    public String getReport() {
        String title = getClasses().stream().reduce("姓名", (x, y) -> x + "/" + y) + "/平均分/总分\n";
        return "成绩单\n" + title + getStudentGrade();
    }

    private List<String> getClasses() {
        List<String> result = new ArrayList<>();
        for (Student stu : students
        ) {
            stu.getGrades().keySet().stream().forEach(result::add);
        }
        return result.stream().distinct().collect(Collectors.toList());
    }

    private String getStudentGrade() {
        String result = "========================\n";
        List<Integer> sumList = new ArrayList<>();

        for (Student stu : students
        ) {
            result += stu.getName()
                    + "/" + stu.getGrades().values().stream().map(i -> i.toString()).reduce((x, y) -> x + "/" + y).get()
                    + "/" + getAvg(stu)
                    + "/" + getSum(stu) + "\n";
            sumList.add(getSum(stu));
        }
        result += "========================\n"
                + "全班总分平均数：" + sumList.stream().mapToDouble((i) -> i).summaryStatistics().getAverage()
                + "\n全班总分中位数：" + getMedian(sumList);
        return result;
    }

    private int getSum(Student stu) {
        return stu.getGrades().values().stream().reduce(Integer::sum).get();
    }

    private double getAvg(Student stu) {
        return stu.getGrades().values().stream().mapToDouble((i) -> i).summaryStatistics().getAverage();
    }

    private double getMedian(List<Integer> arrayList) {
        List<Integer> resultList = arrayList.stream().filter(num -> isEven(num)).sorted().collect(Collectors.toList());

        int index = resultList.size() / 2;

        if (isEven(resultList.size())) {
            return ((double) (resultList.get(index) + resultList.get(index - 1))) / 2;
        } else {
            return resultList.get(index);
        }

    }

    private boolean isEven(int number) {
        if (number % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

}
