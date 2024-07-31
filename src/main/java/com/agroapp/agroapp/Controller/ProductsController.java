package com.agroapp.agroapp.Controller;


import com.agroapp.agroapp.Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1")
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/agroapp/products")
    public String products(Model model) {
        model.addAttribute("tittle", "Productos | Frutas verduras y Mucho mas!");
        model.addAttribute("products", productService.getAllProducts());
        return "views/products";
    }

}
