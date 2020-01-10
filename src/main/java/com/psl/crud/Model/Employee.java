package com.psl.crud.Model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "emp")
public class Employee {

  @Id private int id;

  @NotBlank
  @Size(min = 3, max = 15)
  @Column(length = 15)
  private String fname;

  @NotBlank
  @Size(min = 3, max = 15)
  @Column(length = 15)
  private String lname;

  private int empno;
  private int mgrid;
  private int isdeleted;
}
