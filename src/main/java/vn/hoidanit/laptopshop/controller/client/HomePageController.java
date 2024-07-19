package vn.hoidanit.laptopshop.controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.service.ProductService;

@AllArgsConstructor
@Controller
public class HomePageController {

    private final ProductService productService;

    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("products", this.productService.fetchProducts());
        return "client/homepage/show";
    }
    
}
