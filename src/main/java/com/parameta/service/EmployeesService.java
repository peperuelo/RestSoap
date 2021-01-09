package com.parameta.service;

import com.parameta.mapper.Mapper;
import com.parameta.models.EmployeeDTO;
import com.parameta.xml.employees.EmployeeInformationRequest;
import com.parameta.xml.employees.EmployeeInformationResponse;
import lombok.AllArgsConstructor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import javax.xml.datatype.DatatypeConfigurationException;

@Service
@AllArgsConstructor
public class EmployeesService {

    private final Mapper<EmployeeInformationRequest, EmployeeDTO> requestToDtoMapper;
    private final Mapper<EmployeeDTO,EmployeeInformationResponse> dtoToResponseMapper;
    private final CrudRepository<EmployeeDTO, Integer> employeeRepository;

    public EmployeeInformationResponse serve(EmployeeInformationRequest request) throws DatatypeConfigurationException {
        return dtoToResponseMapper.map(employeeRepository.save(requestToDtoMapper.map(request)));
    }
}
