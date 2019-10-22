package com.sb.macro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model, Principal principal){
        if (principal == null) {
            model.addAttribute("message", "시큐리티 메인 화면입니다.");
        } else {
            model.addAttribute("message", "메인 화면입니다.");
        }
        return "index";
    }

    @GetMapping("/info")
    public String info(Model model) {
        model.addAttribute("message", "info 화면입니다.");
        return "info.html";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        model.addAttribute("message", principal.getName() + " 회원님 안녕하세요.");
        return "dashboard";
    }

    @GetMapping("/admin")
    public String admin(Model model, Principal principal) {
        model.addAttribute("message", principal.getName() + " 관리자님 안녕하세요.");
        return "admin";
    }



}
