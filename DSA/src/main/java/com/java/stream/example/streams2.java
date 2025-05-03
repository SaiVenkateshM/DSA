package com.java.stream.example;

import java.util.*;
import java.util.stream.Collectors;

public class streams2 {
    public static void main(String[] args) {
        first();
        second();
        third();
        fourth();
        fifth();
        sixth();

    }
    public static void first(){
        List<String> s = Arrays.asList("hi","my","name","is","venkatesh");
        //List<String> collect = s.stream().map(String::toUpperCase).collect(Collectors.toList());
        List<String> collect = s.parallelStream().map(String::toUpperCase).collect(Collectors.toList());
        collect.parallelStream().forEach(a -> System.out.println(a +" "+ Thread.currentThread().getName()));
        System.out.println(collect);
    }
    public static void second(){
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
        List<Integer> collect = numbers.stream().filter(s -> s % 2 == 0).collect(Collectors.toList());
        System.out.println(collect);
    }
    public static void third(){
        List<String> s = Arrays.asList("monika","mona","meena","vicky","venkatesh");
        List<String> m = s.stream().filter(a -> a.startsWith("m")).collect(Collectors.toList());
        Long m1 = s.stream().filter(a -> a.startsWith("m")).count();
        System.out.println(m +" "+ m1);
    }
    public static void fourth(){
       List<Employee> employees = Arrays.asList(new Employee("Aishu",150000),new Employee("vicky",200000), new Employee("kapil",80000), new Employee("anjali",60000));
        List<Employee> collect = employees.stream().filter(e -> e.getSalary() > 50000).sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
        System.out.println(collect);
    }
    public static void fifth(){
        List<String> s = Arrays.asList("monika","mona","meena","vicky","venkatesh");
        OptionalInt maxlength = s.stream().mapToInt(a -> a.length()).max();
        System.out.println(maxlength);
    }
    public static void sixth(){
        List<People> p = Arrays.asList(new People(59,"appa"),new People(58,"amma"),new People(34,"akka"),new People(23,"aishu"),new People(28,"vicku"));
        Map<Integer, List<People>> collect = p.stream().collect(Collectors.groupingBy(People::getAge));
        collect.forEach((k,v)-> System.out.println(k + " "+ v));
    }

}
class Employee{
    private String name;
    private Double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + " - $" + salary;
    }
}

class People{
    private String name;

    public People(int age, String name) {
        this.age = age;
        this.name = name;
    }

    private int age;

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }
}



