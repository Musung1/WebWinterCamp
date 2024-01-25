package com.example.myboard.dto.user;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@NotNull
@Getter
@Setter
public class SignupForm {
    @NotNull
    private String name;
    @NotNull
    @Size(min = 5,max = 10)
    private String id;
    @NotNull
    @Size(min = 5,max = 10)
    private String pw;
}
