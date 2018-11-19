package com.epam.jmp.entity;

public class Employee {
    private String firstName;
    private Position position;
    private Salary salary;
    private Integer yearsOfWorkExperience;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }

    public Integer getYearsOfWorkExperience() {
        return yearsOfWorkExperience;
    }

    public void setYearsOfWorkExperience(Integer yearsOfWorkExperience) {
        this.yearsOfWorkExperience = yearsOfWorkExperience;
    }
}
