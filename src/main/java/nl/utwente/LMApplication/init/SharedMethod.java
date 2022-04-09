package nl.utwente.LMApplication.init;

import java.util.Calendar;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class SharedMethod {

    public Date addDate(Date inputDate, int numberDays){

        Calendar cal = Calendar.getInstance();
        cal.setTime(inputDate);
        cal.add(Calendar.DATE, numberDays);
        Date addedDate = cal.getTime();

        return addedDate;
    }
    
}
