package jp.co.cybermissions.itspj.java.meetingroombookingapp.common;

import java.time.LocalTime;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import jp.co.cybermissions.itspj.java.meetingroombookingapp.models.Meeting;

@Component
public class MeetingTimeValidator implements Validator {
  @Override
    public boolean supports(Class<?> clazz) {
      return Meeting.class.isAssignableFrom(clazz);
    }

  @Override
  public void validate(Object target, Errors errors) {
    Meeting meeting = (Meeting) target;
    if(meeting != null) {
      LocalTime startTime = meeting.getStartTime();
      LocalTime endTime = meeting.getEndTime();
      int i = startTime.compareTo(endTime);
      if(i > 0) {
        errors.rejectValue("startTime", "MeetingTimeValidator.startTime", "StartTime is not valid");
      } else if (i == 0) {
        errors.rejectValue("startTime", "MeetingTimeValidator.startTime", "StartTime and EndTime are the same");
      } 
    }
  }
}