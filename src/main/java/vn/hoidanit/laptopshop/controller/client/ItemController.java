package vn.hoidanit.laptopshop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import vn.hoidanit.laptopshop.service.ProductService;

@AllArgsConstructor
@Controller
public class ItemController {

    private final ProductService productService;

    @GetMapping("/product/{id}")
    public String getProductPage(Model model, @PathVariable long id) {
        model.addAttribute("pr", this.productService.getProductByID(id));
        return "client/product/detail";
    }

    @PostMapping("/add-product-to-cart/{id}")
    public String addProductToCart(@PathVariable long id, HttpServletRequest request) {
         HttpSession session = request.getSession(false);
        
         long productId = id;
         String email = (String)session.getAttribute("email");

        this.productService.handleAddProductToCart(email, productId);
        // model.addAttribute("pr", this.productService.getProductByID(id));
        return "redirect:/";
    }
}
