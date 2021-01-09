package com.parameta.models;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Getter
@Builder
@Entity
@NoArgsConstructor
public class EmployeeDTO {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private Integer id;
   @Column(name = "nombre")
   private String name;
   @Column(name = "apellido")
   private String lastName;
   @Column(name = "tipo_documento")
   private String documentType;
   @Column(name = "numero_documento")
   private String documentNumber;
   @Column(name = "fecha_nacimiento")
   private Date birthdate;
   @Column(name = "fecha_vinculacion")
   private Date vinculationDate;
   @Column(name = "cargo")
   private String title;
   @Column(name = "salario")
   private Double Salary;

}
