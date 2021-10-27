package com.besmart.hw1.part1;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private int salary;

    public Employee(int id, String firstName, String lastName, int salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return firstName+" "+lastName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    //зп за год
    public int getAnnualSalary() {
        return 12*salary;
    }

    //raiseSalary возвращает значение новой зп
    public int raiseSalary(int percent) {
        return salary*(100+percent)/100;
    }

    @Override
    public String toString() {
        return "Employee[id="+id+", name="+this.getName()+", salary="+salary+"]";
    }
}
