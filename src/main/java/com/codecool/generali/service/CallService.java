package com.codecool.generali.service;

import com.codecool.generali.model.Call;
import com.codecool.generali.repository.CallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.util.Date;

//@ConfigurationProperties
@Service
public class CallService {

  /*  @Value("${spring.jpa.properties.hibernate.jdbc.time_zone}")
    private long timezone;*/

    @Autowired
    CallRepository callRepository;

    public Call createNewCall(){
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        zonedDateTime = zonedDateTime.plusHours(1);
        Call newCall = new Call();
        newCall.setActualDate(zonedDateTime);
        callRepository.save(newCall);
        return newCall;
    }

}