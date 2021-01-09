package com.parameta.mapper;

import com.parameta.models.EmployeeDTO;
import com.parameta.xml.employees.EmployeeInformationRequest;
import org.springframework.stereotype.Component;

@Component
public class RequestToDtoMapper implements Mapper<EmployeeInformationRequest, EmployeeDTO>{

    @Override
    public EmployeeDTO map(EmployeeInformationRequest entry) {
        return EmployeeDTO
                .builder()
                .name(entry.getName())
                .lastName(entry.getLastName())
                .birthdate(entry.getBirthdate().toGregorianCalendar().getTime())
                .documentNumber(entry.getDocumentNumber())
                .documentType(entry.getDocumentType())
                .title(entry.getTitle())
                .Salary(entry.getSalary().doubleValue())
                .vinculationDate(entry.getVinculationDate().toGregorianCalendar().getTime())
                .build();
    }
}
