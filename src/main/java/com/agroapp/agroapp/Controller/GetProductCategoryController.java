package com.agroapp.agroapp.Controller;


import com.agroapp.agroapp.Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/agroapp/products")
public class GetProductCategoryController {

    private final ProductService productService;

    public GetProductCategoryController(ProductService productService) {
        this.productService = productService;
    }



}
