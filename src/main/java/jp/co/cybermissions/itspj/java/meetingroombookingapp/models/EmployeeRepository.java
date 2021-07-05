package jp.co.cybermissions.itspj.java.meetingroombookingapp.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
  @Query(nativeQuery = true, value = "SELECT * FROM employee WHERE name = :name")
  Employee findbyEmployeename(@Param("name") String name);
}
