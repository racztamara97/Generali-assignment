package com.codecool.generali.service;

import com.codecool.generali.model.Call;
import com.codecool.generali.repository.CallRepository;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

//@ConfigurationProperties
@Service
public class CallService {

  /*  @Value("${spring.jpa.properties.hibernate.jdbc.time_zone}")
    private long timezone;*/

    @Autowired
    CallRepository callRepository;

    private static final Logger logger = LogManager.getLogger(CallService.class);

    int defaultTimezone = 1;

    //this method creates a new call and returns it
    public String createNewCall() {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        zonedDateTime = zonedDateTime.plusHours(defaultTimezone);
        Call newCall = new Call();
        newCall.setActualDate(zonedDateTime);
        String formattedDate = DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm:ss a").format(zonedDateTime);
        callRepository.save(newCall);
        logger.info(formattedDate);
        return formattedDate;
    }

    //this method converts the list of previous calls to a list of strings and returns it
    public List<String> prevCallsToString(List<Call> previous) {
        List<String> prevsToString = new ArrayList<>();
        for (int i = 0; i < previous.size(); i++) {
            Call actual = previous.get(i);
            prevsToString.add(DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm:ss a").format(actual.getActualDate()));
        }
        return prevsToString;
    }

}
