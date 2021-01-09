package com.parameta.config;

import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import javax.wsdl.Definition;

@EnableWs
@Configuration
public class SoapWebServiceConfig extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context){
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/soapWS/*");
    }
    @Bean
    public XsdSchema employeeSchema(){
        return  new SimpleXsdSchema(new ClassPathResource("employeeDefinition.xsd"));
    }

    @Bean
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema employeeSchema){
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(employeeSchema);
        definition.setLocationUri("soapWS");
        definition.setPortTypeName("EmployeeService");
        definition.setTargetNamespace("http://www.parameta.com/xml/employees");
        return definition;

    }
}
