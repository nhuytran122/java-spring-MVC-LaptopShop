package vn.hoidanit.laptopshop.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.service.ProductService;
import vn.hoidanit.laptopshop.service.UploadService;

@AllArgsConstructor
@Controller
public class ProductController {

    private final ProductService productService;
    private final UploadService uploadService;

    @GetMapping("/admin/product")
    public String getProduct(Model model) {
        model.addAttribute("products", this.productService.fetchProducts());
        return "admin/product/show";
    }

    @GetMapping("/admin/product/create")
    public String getCreateProductPage(Model model) {
        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }

    @PostMapping(value = "/admin/product/create")
    public String createProductPage(Model model,
            @ModelAttribute("newProduct") @Valid Product pr,
            BindingResult newProductbindingResult,
            @RequestParam("productFile") MultipartFile file) {

        // List<FieldError> errors = newProductbindingResult.getFieldErrors();
        // for (FieldError error : errors) {
        // System.out.println(">>>>>>" + error.getField() + " - " +
        // error.getDefaultMessage());
        // }

        if (newProductbindingResult.hasErrors()) {
            return "/admin/product/create";
        }
        String image = this.uploadService.handleSaveUploadFile(file, "product");
        pr.setImage(image);

        // save
        this.productService.createProduct(pr);
        return "redirect:/admin/product";
    }

}
