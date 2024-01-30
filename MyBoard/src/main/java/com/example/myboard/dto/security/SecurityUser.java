package com.example.myboard.dto.security;

import com.example.myboard.domain.TbUser;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
@Setter
public class SecurityUser implements UserDetails {
    private TbUser user;
    protected SecurityUser(){}
    public static SecurityUser of(TbUser user) {
        SecurityUser securityUser = new SecurityUser();
        securityUser.setUser(user);
        return securityUser;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authority = new ArrayList();
        authority.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole().name();
            }
        });
        return authority;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
