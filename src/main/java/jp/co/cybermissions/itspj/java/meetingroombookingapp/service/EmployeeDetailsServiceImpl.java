package jp.co.cybermissions.itspj.java.meetingroombookingapp.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import jp.co.cybermissions.itspj.java.meetingroombookingapp.models.Employee;
import jp.co.cybermissions.itspj.java.meetingroombookingapp.models.EmployeeDetailsImpl;
import jp.co.cybermissions.itspj.java.meetingroombookingapp.models.EmployeeRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmployeeDetailsServiceImpl implements UserDetailsService{
  private final EmployeeRepository rep;
  @Override
  public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
    Employee employee = rep.findbyEmployeename(name);
      if (employee == null) {
        throw new UsernameNotFoundException(name + " not found.");
      } else {
        return new EmployeeDetailsImpl(employee);
      }
  }
}
