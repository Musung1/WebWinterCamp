package com.example.myboard.service.userService;

import com.example.myboard.domain.TbUser;
import com.example.myboard.dto.user.LoginForm;
import com.example.myboard.dto.user.SignupForm;
import com.example.myboard.repository.TbUserRepository;
import com.example.myboard.repository.UserLocalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl1 implements UserService{
    private final BCryptPasswordEncoder passwordEncoder;
    private final TbUserRepository repository;
    @Override
    public Boolean login(LoginForm loginForm) {
        TbUser tbUser = repository.findByUsername(loginForm.getUsername()).get();
        return tbUser.getPassword().equals(loginForm.getPassword());
    }

    @Override
    public Boolean signup(SignupForm signupForm) {
        String password = passwordEncoder.encode(signupForm.getPassword());
        TbUser tbUser = TbUser.of(signupForm.getUsername(),password);
        repository.save(tbUser);
        return true;
    }
}
