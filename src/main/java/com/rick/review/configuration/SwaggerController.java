package com.rick.review.configuration;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerController {
    @GetMapping(value = "/docs")
    public String docs(){
        return "redirect:swagger-ui.html";
    }

    @GetMapping(value = "/")
    public String index(){
        return "redirect:swagger-ui.html";
    }
}
