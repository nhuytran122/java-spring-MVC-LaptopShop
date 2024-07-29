package vn.hoidanit.laptopshop.controller.client;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import vn.hoidanit.laptopshop.domain.User;
import vn.hoidanit.laptopshop.service.UploadService;
import vn.hoidanit.laptopshop.service.UserService;

import org.springframework.stereotype.Controller;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class UserProfileController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final UploadService uploadService;

    @GetMapping("/profile")
    public String getProfilePage(Model model, HttpServletRequest request) {
        User currentUser = new User();// null
        HttpSession session = request.getSession(false);
        long id = (long) session.getAttribute("id");
        currentUser.setId(id);

        currentUser = this.userService.getUserById(id);
        model.addAttribute("user", currentUser);

        return "client/user/profile";

    }

    @PostMapping("/user/updateProfile")
    public String postUpdateUserProfile(Model model,
            @ModelAttribute("user") @Valid User hoidanit,
            BindingResult newUserbindingResult,
            @RequestParam("hoidanitFile") MultipartFile file, HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        User currentUser = this.userService.getUserById(hoidanit.getId());

        if (newUserbindingResult.hasErrors()) {
            return "client/user/profile";
        }

        if (currentUser != null) {
            if (!file.isEmpty()) {
                String img = this.uploadService.handleSaveUploadFile(file, "avatar");
                currentUser.setAvatar(img);
            }
            currentUser.setAddress(hoidanit.getAddress());
            currentUser.setFullName(hoidanit.getFullName());
            // session.setAttribute("avatar", currentUser.getAvatar());
            this.userService.handleSaveServer(currentUser, session);
        }
        return "redirect:/profile";
    }
}
