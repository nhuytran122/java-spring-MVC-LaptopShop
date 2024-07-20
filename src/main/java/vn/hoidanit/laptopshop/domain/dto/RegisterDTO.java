package vn.hoidanit.laptopshop.domain.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import vn.hoidanit.laptopshop.service.validator.RegisterChecked;

@Getter
@Setter
@RegisterChecked
public class RegisterDTO {

    @Size(min = 3, message = "Full name phải có tối thiểu 3 ký tự")
    private String firstName;

    private String lastName;

    @Email(message = "Email không hợp lệ", regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String email;

    @Size(min = 3, message = "Password phải có tối thiểu 3 ký tự")
    private String password;
    private String confirmPassword;
}
