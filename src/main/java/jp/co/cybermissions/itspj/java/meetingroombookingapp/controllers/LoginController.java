package jp.co.cybermissions.itspj.java.meetingroombookingapp.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class LoginController {

  @GetMapping("/login")
  public String index() {
    return "auth/login";
  }

  @GetMapping({ "/password", "/password/{pass}" })
  @ResponseBody
  public String password(@RequestParam(defaultValue = "12345") String pass) {
    BCryptPasswordEncoder enc = new BCryptPasswordEncoder();
    return enc.encode(pass);
  }
}