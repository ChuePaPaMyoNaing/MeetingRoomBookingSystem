package jp.co.cybermissions.itspj.java.meetingroombookingapp.models;


import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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

  @Size(min = 8, max = 255)
  private String password;

  @OneToMany(mappedBy = "employee")
  private List<Meeting> meetings;
}
