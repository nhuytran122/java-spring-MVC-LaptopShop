package vn.hoidanit.laptopshop.controller.client;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import lombok.AllArgsConstructor;
import vn.hoidanit.laptopshop.domain.dto.RegisterDTO;
import vn.hoidanit.laptopshop.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@AllArgsConstructor
@Controller
public class HomePageController {

    private final ProductService productService;

    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("products", this.productService.fetchProducts());
        return "client/homepage/show";
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerUser", new RegisterDTO());
        return "client/auth/register";
    }

    @PostMapping("/register")
    public String handleRegister(@ModelAttribute("registerUser") RegisterDTO registerDTO) {
        
        return "client/auth/register";
    }
    
}
