package com.agroapp.agroapp.Controller;

import com.agroapp.agroapp.Entity.Product;
import com.agroapp.agroapp.Service.CategoryProducService;
import com.agroapp.agroapp.Service.ProductService;
import com.agroapp.agroapp.Service.SupplierService;
import com.agroapp.agroapp.Service.UserEntityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1/agroapp")
public class DashBoardController {

    private final UserEntityService userEntityService;
    private final ProductService productService;
    private final SupplierService supplierService;
    private final CategoryProducService categoryProducService;

    public DashBoardController(UserEntityService userEntityService, ProductService productService, SupplierService supplierService, CategoryProducService categoryProducService) {
        this.userEntityService = userEntityService;
        this.productService = productService;
        this.supplierService = supplierService;
        this.categoryProducService = categoryProducService;
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("products", productService.getProductBysupplierId(1L));
        model.addAttribute("supplier", supplierService.findById(1L));
        return "views/dashboard";
    }

    @PostMapping("/dashboard")
    public String dashboardPost() {
        return "views/dashboard";
    }


    @GetMapping("/dashboard/edit/{id}")
    public String dashboardDeleteGet(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        model.addAttribute("categories", categoryProducService.getAllCategories());
        return "views/EditProduct";
    }

    @PostMapping("/dashboard/edit/{id}")
    public String dashboardUpdate(@PathVariable Long id, Model model ,@ModelAttribute Product product) {
        model.addAttribute("product", productService.getProductById(id));
        product.setId(id);
        product.setSupplier(supplierService.findById(1L));
        productService.saveProduct(product);
        return "redirect:/v1/agroapp/dashboard";
    }

    @PostMapping("/dashboard/delete/{id}")
    public String dashboardDelete(@PathVariable Long id) {
        productService.deleteProductbyId(id);
        return "redirect:/v1/agroapp/dashboard";
    }
}
