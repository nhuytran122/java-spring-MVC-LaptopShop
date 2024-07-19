package vn.hoidanit.laptopshop.controller.client;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
}
