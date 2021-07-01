package jp.co.cybermissions.itspj.java.meetingroombookingapp.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer>{
  
}
