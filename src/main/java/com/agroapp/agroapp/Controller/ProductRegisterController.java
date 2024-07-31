package com.agroapp.agroapp.Controller;


import com.agroapp.agroapp.Entity.Product;
import com.agroapp.agroapp.Service.CategoryProducService;
import com.agroapp.agroapp.Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/v1/agroapp")
public class ProductRegisterController {

    private final ProductService productService;


    public ProductRegisterController(ProductService productService, CategoryProducService categoryProducService) {
        this.productService = productService;
        this.categoryProducService = categoryProducService;
    }

    private final CategoryProducService categoryProducService;


    // muestro el formulario
    @GetMapping("/registroProducto")
    public String showFormProduct(Model model) {
        model.addAttribute("product", new Product());
        model.addAttribute("categories", categoryProducService.getAllCategories());
        return "views/ProductRegister";
    }

    // guardar el producto
    @PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute Product product) {
        productService.saveProduct(product);
        return "redirect:/v1/agroapp/inicio";
    }
}
