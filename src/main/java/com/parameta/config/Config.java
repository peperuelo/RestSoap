package com.parameta.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
@EnableAutoConfiguration
@ComponentScan

public class Config extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext)
    {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/parameta/*");
    }

    @Bean(name = "EmployeeWsdl")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema EmployeesSchema)
    {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("employeePort");
        wsdl11Definition.setLocationUri("/web/soap");
        wsdl11Definition.setTargetNamespace("http://www.parameta.com/xml/employees");
        wsdl11Definition.setSchema(EmployeesSchema);
        return wsdl11Definition;
    }


    @Bean
    public XsdSchema countriesSchema()
    {
        return new SimpleXsdSchema(new ClassPathResource("schema/employeeDefinition.xsd"));
    }




}

