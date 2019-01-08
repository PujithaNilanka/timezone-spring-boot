package com.pujitha.timezone.timezone;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;

@RestController
public class TimezoneController {

    @RequestMapping("/")
    public String root() {
        return "All set to go!";
    }

    @RequestMapping("/info")
    public String info() {
        return"All set to go! \n Available endpoints \n /listTimeZones \n /getCurrentTime={TimeZoneID}";
    }

    @RequestMapping(value="/getCurrentTime", method = RequestMethod.GET)
    public String getTimezone(@RequestParam("TimeZone") String timeZone){

        Calendar dateTime = Calendar.getInstance();
        Calendar convertedDateTime = new GregorianCalendar(TimeZone.getTimeZone(timeZone));

        convertedDateTime.setTimeInMillis(dateTime.getTimeInMillis());

        return "Converted time : " + convertedDateTime.get(Calendar.HOUR) + ":" + convertedDateTime.get(Calendar.MINUTE) + ":" + convertedDateTime.get(Calendar.SECOND) + " " + convertedDateTime.getTimeZone().getDisplayName();

    }

    @RequestMapping("/listTimeZones")
    public String listTimezones(){

        return Arrays.toString(TimeZone.getAvailableIDs());

    }
}
