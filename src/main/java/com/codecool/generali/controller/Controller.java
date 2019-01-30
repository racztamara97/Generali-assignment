package com.codecool.generali.controller;

import com.codecool.generali.model.Call;
import com.codecool.generali.repository.CallRepository;
import com.codecool.generali.service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@org.springframework.stereotype.Controller
@Scope("session")
public class Controller {

    @Autowired
    private CallService callService;

    @Autowired
    private CallRepository callRepository;

    @ModelAttribute("call")
    public Call createCall() {
        return new Call();
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }
    
    @GetMapping("/call")
    public String call(Model model, HttpSession session){
        String newCall = callService.createNewCall();
        session.setAttribute("call", newCall);
        model.addAttribute("newCall", newCall);
        return "index";
    }


}
