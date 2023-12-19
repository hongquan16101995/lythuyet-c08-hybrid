package com.example.firstspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
// annotation định danh đường dẫn cho lớp controller tương ứng
// giúp FrontController nhận biết request đang mong muốn gọi đến controller nào
@RequestMapping(value = "/api/products")
public class ProductController {

    @GetMapping(value = "/home")
    public String home() {
        return "product/create-get";
    }

    @GetMapping(value = "/{id}")
    // @PathVariables dùng để lấy giá trị biến trên đường dẫn nếu có
    // biến được đăng ký với controller thông qua URI có định dạng: {tên}
    // path sẽ đón qua tên của biến
    public ModelAndView home1(@PathVariable("id") Long test) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("id", test);
        return modelAndView;
    }

    @GetMapping(value = "")
    // @RequestParam dùng đế đón dữ liệu trong body của request
    // dữ liệu này thường được gửi từ form HTML, tồn tại dưới dạng key-value
    // đón dữ liệu thông qua key, trùng tên là có thể lấy được
    public ModelAndView home2(@RequestParam("gender") String a,
                              @RequestParam Integer age) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("id", 10000);
        modelAndView.addObject("gender", a);
        modelAndView.addObject("age", age);
        return modelAndView;
    }

    @PostMapping
    public ModelAndView creat(@RequestParam String name) {
        ModelAndView modelAndView = new ModelAndView("product/create-post");
        modelAndView.addObject("name", name);
        return modelAndView;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ModelAndView creat1(@RequestParam String name) {
        ModelAndView modelAndView = new ModelAndView("product/create-post");
        modelAndView.addObject("name1", name);
        return modelAndView;
    }
}
