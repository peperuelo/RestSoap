package com.parameta.endpoints;

import com.parameta.repository.EmployeeRepository;
import com.parameta.service.EmployeesService;
import com.parameta.xml.employees.EmployeeInformationRequest;
import com.parameta.xml.employees.EmployeeInformationResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.xml.datatype.DatatypeConfigurationException;

@Endpoint
@AllArgsConstructor
public class EmployeeEndpoint {
    private static final String TARGET_NAMESPACE =  "http://www.parameta.com/xml/employees";
    private final EmployeesService service;
    @PayloadRoot(namespace = TARGET_NAMESPACE,localPart = "getEmployeeRequest")

    public @ResponsePayload EmployeeInformationResponse getEmployeeRequest(@RequestPayload EmployeeInformationRequest request) throws DatatypeConfigurationException {
     return service.serve(request);
    }

}
