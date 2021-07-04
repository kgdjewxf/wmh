package com.demo.wmh.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("/login")
public class loginControl {
//    @RequestMapping({"/","/index"})
//    public String index(){
//        return "login";
//    }
    @GetMapping("/toLogin")
//    @ResponseBody
    public String login(HttpServletRequest httpServletRequest){
      System.out.println();
      return "hello";
    }
    @GetMapping("/hello")
    public String hello(HttpServletRequest httpServletRequest, Model model){
        model.addAttribute("hello","wmh");
        return "hello";
    }

}
