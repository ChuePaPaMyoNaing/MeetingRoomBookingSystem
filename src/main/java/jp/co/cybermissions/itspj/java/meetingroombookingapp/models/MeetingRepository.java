package jp.co.cybermissions.itspj.java.meetingroombookingapp.models;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends JpaRepository<Meeting, Integer> {
  @Query(nativeQuery = true, value = "SELECT * from Meeting order by date desc")
  List<Meeting> findByDateOrderByDesc();
}
