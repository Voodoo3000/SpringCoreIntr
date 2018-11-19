package com.epam.jmp;

import com.epam.jmp.department.PositionList;
import com.epam.jmp.entity.Employee;
import com.epam.jmp.entity.Position;
import com.epam.jmp.service.EmployeeService;
import com.epam.jmp.staff.Staff;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        Staff staff = ctx.getBean(Staff.class);
        PositionList positionList = ctx.getBean(PositionList.class);

        EmployeeService employeeService = ctx.getBean(EmployeeService.class);
        employeeService.hireEmployee("Pavel", Position.SOFTWARE_ENGINEER, 1500);
        employeeService.hireEmployee("Andrey", Position.TESTING_ENGINEER, 2000);
        employeeService.hireEmployee("Evgeniy", Position.BUSINESS_ANALYST, 1000);
        employeeService.hireEmployee("Yuriy", Position.TESTING_ENGINEER, 850);
        employeeService.hireEmployee("Vladislav", Position.SYSTEMS_ENGINEER, 1400);
        employeeService.hireEmployee("Sergey", Position.TESTING_MANAGER, 1700);

        employeeService.fireEmployee("Yuriy");

        for (Position p : positionList.getPositions()) {
            System.out.println(p.toString());
        }

        for (Employee e : staff.getEmployees()) {
            System.out.println(e.getFirstName());
        }


    }
}
