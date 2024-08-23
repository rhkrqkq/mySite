package com.example.mySite.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsersignupForm {

    @NotEmpty(message = "ID입력은 필수입니다.")
    private String username;

    @NotEmpty(message = "이메일 입력은 필수입니다.")
    @Email
    private String email;

    @NotEmpty(message = "비밀번호 입력은 필수입니다.")
    private String password1;

    @NotEmpty(message = "비밀번호 확인 입력은 필수입니다.")
    private String password2;
}
