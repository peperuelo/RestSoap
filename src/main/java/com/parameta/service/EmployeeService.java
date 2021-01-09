package com.parameta.service;

import com.parameta.Employee;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmployeeService {

    private static final Map<String, Employee> employees = new HashMap<>();

    @PostConstruct
    public void  Initialize(){
        Employee pepe = new Employee(1);
        pepe.setName("Andres");
        pepe.setLastName("Rios");
        pepe.setDocumentType("CC");
        pepe.setDocumentNumber("1019130654");
        pepe.setSalary(300);

        employees.put();

    }
    public  Employee getEmployees(String name){
        return  employees.get(name);
    }

}
