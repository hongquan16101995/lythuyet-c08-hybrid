package com.example.firstspring.controller;

import com.example.firstspring.model.Product;
import com.example.firstspring.service.IProductService;
import com.example.firstspring.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView("/product/list");
        modelAndView.addObject("products", productService.findAll());
        modelAndView.addObject("message", "Hello1");
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createGet() {
        return new ModelAndView("/product/create");
    }

    @PostMapping
    public ModelAndView create(@RequestParam Long id,
                               @RequestParam String name,
                               @RequestParam Long price,
                               @RequestParam Long quantity) {
        ModelAndView modelAndView = new ModelAndView("/product/list");
        Product product = new Product(id, name, price, quantity);
        productService.create(product);
        modelAndView.addObject("products", productService.findAll());
        return modelAndView;
    }
}
