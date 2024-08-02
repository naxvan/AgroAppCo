package com.agroapp.agroapp.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/v1/agroapp")
public class WorkUsController {
    @GetMapping("/works")
    public String workUs() {
        return "views/WorkUs";
    }
}
