package com.example.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @GetMapping("/")
    public ModelAndView index() {
        // this function is for the home page of the website which is the expressed as just a plain slash "/"
        ModelAndView response = new ModelAndView("index");


        return response;
    }

    @GetMapping("/page-url")
    public ModelAndView anotherPage() {
        ModelAndView response = new ModelAndView("another-page");

        return response;
    }

}
