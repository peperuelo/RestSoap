package com.parameta.repository;

import com.parameta.xml.employees.EmployeeInformationRequest;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeInformationRequest, Integer> {



}
