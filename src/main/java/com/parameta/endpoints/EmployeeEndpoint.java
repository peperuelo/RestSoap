package com.parameta.endpoints;

import com.parameta.repository.EmployeeRepository;
import com.parameta.service.EmployeeService;
import com.parameta.xml.employees.EmployeeInformationRequest;
import com.parameta.xml.employees.EmployeeInformationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EmployeeEndpoint {
    private static final String TARGET_NAMESPACE =  "http://www.parameta.com/xml/employees";
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmployeeService service;

    @Autowired
    public EmployeeEndpoint(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    @PayloadRoot(namespace = TARGET_NAMESPACE,localPart = "getEmployeeRequest")

    public @ResponsePayload EmployeeInformationResponse getEmployeeRequest(@RequestPayload EmployeeInformationRequest request){
        EmployeeInformationResponse response = new EmployeeInformationResponse();
        response.setName(service.getEmployees(name));
        return response;
       // Employee employee = new Employee();
    }


 //   @PayloadRoot(namespace = TARGET_NAMESPACE,localPart = "getEmployeeRequest")
 //
   // public ResponseMapper getEmployee(@RequestPayload etEmployeeRequest){

  //  }

}
