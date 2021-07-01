package jp.co.cybermissions.itspj.java.meetingroombookingapp.models;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name="room")
public class Room {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY) 
  private int id;
  
  @Column(name="roomNo")
  private int roomNo;

  @OneToMany(mappedBy = "room")
  private List<Meeting> meetings;
}
