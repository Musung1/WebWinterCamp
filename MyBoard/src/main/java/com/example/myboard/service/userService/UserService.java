package com.example.myboard.service.userService;

import com.example.myboard.dto.user.LoginForm;
import com.example.myboard.dto.user.SignupForm;

public interface UserService {
    public Boolean login(LoginForm loginForm);
    public Boolean signup(SignupForm signupForm);
}
