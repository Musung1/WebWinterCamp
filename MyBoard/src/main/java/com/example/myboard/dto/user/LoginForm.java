package com.example.myboard.dto.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class LoginForm {
    @NotNull
    @Size(min = 5,max = 10)
    private String id;
    @NotNull
    @Size(min = 5,max = 10)
    private String pw;
}
