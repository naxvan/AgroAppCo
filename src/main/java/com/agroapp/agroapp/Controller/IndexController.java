package com.agroapp.agroapp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/")
public class IndexController {
    
    @GetMapping("")
    public String redirect(){
        return "redirect:/v1/agroapp/inicio";
    }

    @GetMapping("v1")
    public String redirectFromV1(){
        return "redirect:/v1/agroapp/inicio";
    }

    @GetMapping("v1/agroapp")
    public String redirectFromApp(){
        return "redirect:/v1/agroapp/inicio";
    }
    
}
