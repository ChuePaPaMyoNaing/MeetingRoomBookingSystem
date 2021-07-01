package jp.co.cybermissions.itspj.java.meetingroombookingapp.models;

import java.time.LocalTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Integer> {

  // @Query(value="select * from meeting where roomNo = :roomNo")
 Meeting findByStartTime(LocalTime startTime);
}
