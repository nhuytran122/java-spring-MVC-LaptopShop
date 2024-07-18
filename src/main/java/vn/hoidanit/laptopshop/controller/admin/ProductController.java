package vn.hoidanit.laptopshop.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.domain.Product;
import vn.hoidanit.laptopshop.service.ProductService;
import vn.hoidanit.laptopshop.service.UploadService;

@AllArgsConstructor
@Controller
@Getter
@Setter
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

    @GetMapping("/admin/product/{id}")
    public String getProductDetailsPage(Model model, @PathVariable long id) {
        model.addAttribute("pr", this.productService.getProductByID(id));
        return "admin/product/detail";
    }

    @GetMapping("/admin/product/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        model.addAttribute("pr", this.productService.getProductByID(id));
        return "admin/product/update";
    }

    @PostMapping("/admin/product/update")
    public String postUpdateUser(Model model,
            @ModelAttribute("pr") @Valid Product prd,
            BindingResult newProductbindingResult,
            @RequestParam("productFile") MultipartFile file) {
        
        if (newProductbindingResult.hasErrors()) {
            return "/admin/product/update";
        }
        Product currentPr = this.productService.getProductByID(prd.getId());

        if (currentPr != null) {
            //tránh trường hợp user không upload file -> giữ nguyên file cũ
            if(!file.isEmpty()){
                String img = this.uploadService.handleSaveUploadFile(file, "product");
                currentPr.setImage(img);
            }
            currentPr.setName(prd.getName());
            currentPr.setPrice(prd.getPrice());
            currentPr.setDetailDesc(prd.getDetailDesc());
            currentPr.setShortDesc(prd.getShortDesc());
            currentPr.setQuantity(prd.getQuantity());
            currentPr.setFactory(prd.getFactory());
            currentPr.setTarget(prd.getTarget());

            this.productService.createProduct(currentPr);
        }
        return "redirect:/admin/product";
    }

    @GetMapping("/admin/product/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable long id) {
        model.addAttribute("newProduct", new Product());
        model.addAttribute("id", id);
        return "admin/product/delete";
    }

    @PostMapping("/admin/product/delete")
    public String postDeleteProduct(Model model, @ModelAttribute("newProduct") Product prd) {
        this.productService.deleteById(prd.getId());
        return "redirect:/admin/product";
    }
}
