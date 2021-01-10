package com.parameta.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Integer id;
   private String  name;
   private String  lastName;
   private String  documentType;
   private String  documentNumber;
   private Date    birthdate;
   private Date    vinculationDate;
   private String  title;
   private Double  Salary;

}
