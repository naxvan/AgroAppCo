package com.agroapp.agroapp.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
public class ProductsController {

    @GetMapping("/agroapp/products")
    public String products(Model model) {
        model.addAttribute("tittle", "Productos | Frutas verduras y Mucho mas!");
        return "views/products";
    }

}
