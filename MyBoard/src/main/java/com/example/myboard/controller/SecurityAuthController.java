package com.example.myboard.controller;

import com.example.myboard.anotaion.Login;
import com.example.myboard.dto.user.LoginForm;
import com.example.myboard.dto.user.SignupForm;
import com.example.myboard.service.userService.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class SecurityAuthController {
    private final UserService userService;
    @CrossOrigin
    @PostMapping("/signup")
    public ResponseEntity<String> signup(@RequestBody SignupForm signupForm) {
        userService.signup(signupForm);
        log.info("sinup");
        return ResponseEntity.ok("OK");
    }
    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<String> login(Authentication authentication, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        session.setAttribute("authSession",authentication.getPrincipal());
        return ResponseEntity.ok("OK");
    }
    @CrossOrigin
    @GetMapping("/loginTest")
    public ResponseEntity<String> loginTest(@Login String uid, HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        String id = session.getId();
        log.info("uid = [{}]",uid);
        return ResponseEntity.ok(id);
    }
}
