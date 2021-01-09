package com.parameta.repository;

import com.parameta.models.EmployeeDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeDTO, Integer> {

}
