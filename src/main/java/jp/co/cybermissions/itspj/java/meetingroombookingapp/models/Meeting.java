package jp.co.cybermissions.itspj.java.meetingroombookingapp.models;


import java.time.LocalTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="meeting")
public class Meeting {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private int id;

  @NotNull
  @Size(max=300)
  @Column(name="summary")
  private String summary;

  @NotNull
  @Column(name="attendance")
  private int attendance;

  @NotNull(message = "Date cannot not be null")
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Column(name="date", nullable = true)
  private Date date;

  @NotNull
  @Column(name="startTime")
  private LocalTime startTime;

  @NotNull
  @Column(name="endTime")
  private LocalTime endTime;
  
  @NotEmpty
  @Column(name="employeeName", nullable = true)
  @Size(max=50)
  private String employeeName;

  @NotNull
  @Column(name="roomNo")
  private int roomNo;

  @ManyToOne
  @JoinColumn(name="employee_id")
  private Employee employee;

  @ManyToOne
  @JoinColumn(name="room_id")
  private Room room;

}
