package com.example.myboard.service.userService;

import com.example.myboard.domain.TbUser;
import com.example.myboard.dto.user.LoginForm;
import com.example.myboard.dto.user.SignupForm;
import com.example.myboard.repository.UserLocalRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl1 implements UserService{
    private final UserLocalRepository repository= new UserLocalRepository();
    @Override
    public Boolean login(LoginForm loginForm) {
        TbUser tbUser = repository.getUser(loginForm.getId());
        return tbUser.getPassword().equals(loginForm.getPw());
    }

    @Override
    public Boolean signup(SignupForm signupForm) {
        TbUser tbUser = TbUser.of(signupForm.getId(), signupForm.getPw());
        repository.save(tbUser);
        return true;
    }
}
