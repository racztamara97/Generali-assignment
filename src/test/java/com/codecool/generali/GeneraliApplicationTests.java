package com.codecool.generali;

import com.codecool.generali.service.CallService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.ZonedDateTime;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class GeneraliApplicationTests {

    private DateValidator dateValidator;

    @Before
    public void init() {
        dateValidator = new DateValidator();
    }

    @Autowired
    private CallService callService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testDateIsNull() {
        assertFalse(dateValidator.isThisDateValid(null, "dd/MM/yyyy - hh:mm:ss a"));
    }

    @Test
    public void testBeforeDateFormat() {
        assertFalse(dateValidator.isThisDateValid(ZonedDateTime.now().toString(), "dd/MM/yyyy - hh:mm:ss a"));
    }

    @Test
    public void testDateFormat() {
        assertTrue(dateValidator.isThisDateValid(callService.createNewCall(ZonedDateTime.now()), "dd/MM/yyyy - hh:mm:ss a"));
    }

}

