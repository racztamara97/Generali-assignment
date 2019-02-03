package com.codecool.generali.controller;

import com.codecool.generali.model.Call;
import com.codecool.generali.service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpSession;

@org.springframework.stereotype.Controller
@Scope("session")
public class Controller {

    @Autowired
    private CallService callService;

    @ModelAttribute("call")
    public Call createCall() {
        return new Call();
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    //when the "New call" button clicked, it creates a new call
    @GetMapping("/call")
    public String call(Model model, HttpSession session) {
        String newCall = callService.createNewCall();
        session.setAttribute("call", newCall);
        model.addAttribute("newCall", newCall);
        return "index";
    }

    //when the "Previous calls" button clicked, it shows all previous calls
    @GetMapping("/previous")
    public String prevCalls(Model model) {
        model.addAttribute("calls", callService.prevCallsToString());
        return "previousCalls";
    }


}
