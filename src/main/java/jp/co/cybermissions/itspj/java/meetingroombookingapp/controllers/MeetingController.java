package jp.co.cybermissions.itspj.java.meetingroombookingapp.controllers;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import jp.co.cybermissions.itspj.java.meetingroombookingapp.common.MeetingTimeValidator;
import jp.co.cybermissions.itspj.java.meetingroombookingapp.models.Meeting;
import jp.co.cybermissions.itspj.java.meetingroombookingapp.models.MeetingRepository;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/meeting")
@RequiredArgsConstructor
public class MeetingController{

  private final MeetingRepository rep;
  private final MeetingTimeValidator validator;

  @InitBinder
  public void initBinder(WebDataBinder binder) {
      binder.addValidators(validator);
  }

  @Autowired
  MessageSource msg;

  @GetMapping("")
  public String index(Model model) {
    model.addAttribute("meeting", rep.findAll());
    return "meeting/home";
  }

  @GetMapping("/booking")
  public String newBookingForm(@ModelAttribute Meeting meeting, Model model) {
    return "meeting/booking";
  }

  @PostMapping("")
  public String booking(@Validated @ModelAttribute Meeting meeting,
      BindingResult result,Model model,
      RedirectAttributes attrs) {
      if (result.hasErrors()) {
        model.addAttribute("meeting", meeting);
        return "meeting/booking";
      }

      List<Meeting> meetingDB = new ArrayList<Meeting>();
     
      meetingDB = rep.findAll();
      if(meetingDB.size() > 0 ) {
        for(Meeting meetingdb : meetingDB){
            System.out.println(meetingdb.getDate());
            System.out.println(meeting.getDate());

          if(meetingdb.getDate().compareTo(meeting.getDate()) == 0){
              
            LocalTime dbStartTime= meetingdb.getStartTime();
            LocalTime dbEndTime = meetingdb.getEndTime();
  
            LocalTime sTime = meeting.getStartTime();
            LocalTime eTime = meeting.getEndTime();
  
            int i = dbStartTime.compareTo(sTime);
            int j = dbStartTime.compareTo(eTime);
            int k = dbEndTime.compareTo(eTime);
  
            if(meetingdb.getRoomNo() == meeting.getRoomNo() || dbStartTime.equals(sTime) || i < 0 || j < 0 || j > 0 || (i > 0 && k < 0)){
              attrs.addFlashAttribute("success", "Meeting cannot take"); 
              return "meeting/booking";
            }
          }
        }
      }
      

      System.out.println("Size  is  "+meetingDB.size());

     
      rep.save(meeting);
      return "redirect:/meeting";
  }


  @GetMapping("/{id}")
  public String detail(@PathVariable int id, Model model) {
    Meeting meeting = rep.findById(id).get();
    model.addAttribute("meeting", meeting);
    return "meeting/detail";
  }

  @GetMapping("/{id}/update")
  public String updateForm(@PathVariable int id, Model model) {
    Meeting meeting = rep.findById(id).get();
    model.addAttribute("meeting", meeting);
    return "meeting/update";
  }

  @PatchMapping("/{id}")
  public String update(@PathVariable int id, @ModelAttribute Meeting meeting,
    Model model, RedirectAttributes attrs){
    meeting.setId(id);
    rep.save(meeting);
    return "redirect:/meeting";
  }

  @GetMapping("/{id}/cancel")
  public String cancelForm(@PathVariable int id, Model model) {
    Meeting meeting = rep.findById(id).get();
    model.addAttribute("meeting", meeting);
    return "meeting/cancel";
  }

  @DeleteMapping("/{id}")
  public String cancel(@PathVariable int id,Model model, RedirectAttributes attrs){
    rep.deleteById(id);
    return "redirect:/meeting";
  }
}
