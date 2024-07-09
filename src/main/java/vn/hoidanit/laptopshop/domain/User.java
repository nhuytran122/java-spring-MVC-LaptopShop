package vn.hoidanit.laptopshop.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private long id;
    private String email;
    private String password;
    private String fullName;
    private String address;
    private String phone;
}
