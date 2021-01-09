package com.parameta.dao;

import com.parameta.repository.EmployeeRepository;
import com.parameta.xml.employees.EmployeeInformationRequest;
import com.parameta.xml.employees.EmployeeInformationResponse;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.stereotype.Component;

@Component
public class EmployeeDAO {
    private final EmployeeRepository employeeRepository;

    public EmployeeDAO(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public EmployeeInformationResponse  saveEmployee(EmployeeInformationRequest request){
        employeeRepository.save(request);
    }

}
