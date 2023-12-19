package com.example.firstspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

// đánh dấu đây là 1 controller
// cho phép FrontController nhận biết và
// điều hướng request tương ứng đến controller này
@Controller
public class HomeController {

    // đánh dấu tài nguyên này được truy cập bởi request method GET
    // thuộc tính value chỉ định địa chỉ truy cập đến tài nguyên này
    @GetMapping(value = "/home")
    public String home(Model model) {
        model.addAttribute("name", "CodeGym");
        return "index";
    }

    @GetMapping(value = "/demo")
    public ModelAndView home1() {
        ModelAndView modelAndView = new ModelAndView("index1");
        modelAndView.addObject("name", "VN");
        return modelAndView;
    }
}
