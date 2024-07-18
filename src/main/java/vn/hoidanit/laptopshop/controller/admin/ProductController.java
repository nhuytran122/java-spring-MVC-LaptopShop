package vn.hoidanit.laptopshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import vn.hoidanit.laptopshop.domain.Product;

@Controller
public class ProductController {

    @GetMapping("/admin/product")
    public String getProduct() {
        return "admin/product/show";
    }

    @GetMapping("/admin/product/create")
    public String getCreateProductPage(Model model) {
        model.addAttribute("newProduct", new Product());
        return "admin/product/create";
    }

    @PostMapping(value = "/admin/product/create")
    public String createProductPage(Model model,
            @ModelAttribute("newProduct") Product product,
            @RequestParam("productFile") MultipartFile file) {

        // String avatar = this.uploadService.handleSaveUploadFile(file, "avatar");
        // String hashPassword = this.passwordEncoder.encode(hoidanit.getPassword());

        // hoidanit.setAvatar(avatar);
        // hoidanit.setPassword(hashPassword);
        // hoidanit.setRole(this.userService.getRoleByName(hoidanit.getRole().getName()));

        // // save
        // this.userService.handleSaveServer(hoidanit);
        return "redirect:/admin/product";
    }

}
