package com.epam.jmp.config;

import com.epam.jmp.service.EmployeeService;
import com.epam.jmp.service.SalaryService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.epam.jmp")
public class AppConfig {
    @Bean
    public EmployeeService employeeService() {
        return new EmployeeService();
    }
    @Bean
    public SalaryService salaryService() {
        return new SalaryService();
    }
}
