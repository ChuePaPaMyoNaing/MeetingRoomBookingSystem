package jp.co.cybermissions.itspj.java.meetingroombookingapp.models;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class EmployeeDetailsImpl extends User{
  private final Employee employee;

  public EmployeeDetailsImpl(Employee employee) {
    super(employee.getName(), employee.getPassword(), getAuthorities(employee));
    this.employee = employee;
  }

  private static Collection<? extends GrantedAuthority> getAuthorities(Employee employee) {
    Set<GrantedAuthority> authSet = new HashSet<>();
    authSet.add(new SimpleGrantedAuthority(employee.getName()));
    return authSet;
  }

  // 取得したい項目のgetメソッドを定義
  public int getId() {
    return employee.getId();
  }

  public String getName() {
    return employee.getName();
  }
}
