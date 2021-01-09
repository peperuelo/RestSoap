package com.parameta.mapper;

import com.parameta.models.EmployeeDTO;
import com.parameta.xml.employees.EmployeeInformationResponse;
import org.springframework.stereotype.Component;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;
import java.util.Date;
import java.util.GregorianCalendar;

@Component
public class DtoToResponseMapper implements Mapper<EmployeeDTO, EmployeeInformationResponse>{


    @Override
    public EmployeeInformationResponse map(EmployeeDTO entry) throws DatatypeConfigurationException {
        EmployeeInformationResponse response = new EmployeeInformationResponse();
        response.setId(BigInteger.valueOf(entry.getId()));
        response.setName(entry.getName());
        response.setLastName(entry.getLastName());
        response.setBirthdate(mapDate(entry.getBirthdate()));
        response.setDocumentNumber(entry.getDocumentNumber());
        response.setSalary(BigInteger.valueOf(Double.doubleToLongBits(entry.getSalary())));
        response.setDocumentType(entry.getDocumentType());
        response.setTitle(entry.getTitle());
        response.setVinculationDate(mapDate(entry.getVinculationDate()));
        return response;

    }

    private XMLGregorianCalendar mapDate(Date date) throws DatatypeConfigurationException {
        GregorianCalendar c = new GregorianCalendar();
        c.setTime(date);
        return DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
    }




}
