package com.codecool.generali.controller;

import com.codecool.generali.model.Call;
import com.codecool.generali.repository.CallRepository;
import com.codecool.generali.service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;
import java.time.ZonedDateTime;

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

    //index shows all of the previous calls in Descending order
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("calls", callService.prevCallsToString(callRepository.findAllByOrderByIdDesc()));
        return "index";
    }

    //when the "New call" button clicked, it creates a new call
    @GetMapping("/call")
    public String call(Model model, HttpSession session) {
        String newCall = callService.createNewCall(ZonedDateTime.now());
        session.setAttribute("call", newCall);
        model.addAttribute("newCall", newCall);
        return "redirect:/";
    }

}
