package com.agroapp.agroapp.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping("/v1/agroapp")
public class TermsConditionController {

    @GetMapping("/terminosycondiciones")
    public String termsAndConditions() {
        return "views/TermsConditions";
    }
}
