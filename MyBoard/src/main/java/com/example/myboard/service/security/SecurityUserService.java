package com.example.myboard.service.security;

import com.example.myboard.domain.TbUser;
import com.example.myboard.dto.security.SecurityUser;
import com.example.myboard.repository.TbUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class SecurityUserService implements UserDetailsService {
    private final TbUserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        TbUser user = repository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException("유저 없음"));
        return SecurityUser.of(user);
    }
}
