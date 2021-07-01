package jp.co.cybermissions.itspj.java.meetingroombookingapp.models;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="employee")
public class Employee {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private int id;

  @NotBlank
  @Column(name="name")
  private String name;

  @OneToMany(mappedBy = "employee")
  private List<Meeting> meetings;
}