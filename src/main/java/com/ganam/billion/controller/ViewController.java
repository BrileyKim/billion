package com.ganam.billion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;

@Controller
@RequestMapping("/view")
public class ViewController {

    @GetMapping("/login")
    public String loginPage(){
        return "view/login";
    }

    @GetMapping("/dashboard")
    public String dashboardPage(Principal principal, Model model){
        model.addAttribute("loginId",principal.getName());

        return "view/dashboard";
    }

    @GetMapping("/join")
    public String joinPage(){ return "view/join";}
}

