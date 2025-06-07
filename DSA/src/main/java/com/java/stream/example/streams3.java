package com.java.stream.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class streams3 {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alice", 2023),
                new Student("Bob", 2022),
                new Student("Alice", 2022),
                new Student("David", 2024),
                new Student("Bob", 2021)
        );
        List<Student> sortedStudents = students.stream()
                .sorted(Comparator
                        .comparing(Student::getStudentName)
                        .thenComparing(Student::getPassingyear))
                .collect(Collectors.toList());

        sortedStudents.forEach(System.out::println);
    }
}
class Student {
    String studentName;
    Integer passingyear;

    public Student(String studentName, Integer passingyear) {
        this.studentName = studentName;
        this.passingyear = passingyear;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public void setPassingyear(Integer passingyear) {
        this.passingyear = passingyear;
    }

    public String getStudentName() {
        return studentName;
    }

    public Integer getPassingyear() {
        return passingyear;
    }
}
