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
    
    @Override
    public int hashCode() {
        int result = 17;

        result = 31*result + id;
        result = 31*result + salary;
        result = 31*result + firstName.hashCode();
        result = 31*result + lastName.hashCode();

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (obj == null || this.getClass() != obj.getClass()) return false;

        Employee employee = (Employee) obj;

        return this.firstName.equals(employee.getFirstName())
                && this.lastName.equals(employee.getLastName())
                && this.id==employee.getId() && this.salary==employee.getSalary();
    }
}
