package com.example.myboard.domain;

import com.example.myboard.dto.security.SecurityRole;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@ToString(callSuper = true)
@Entity
public class TbUser extends AuditingFields{
    @Column(nullable = false)
    @Setter
    private String username;
    @Column(nullable = false)
    @Setter
    private String password;
    @Column
    @Setter
    private String nickName;
    @Column
    @Setter
    private String name;
    @Column
    @Setter
    private String phone;
    @Column
    @Setter
    private String pic;
    @Column
    @Setter
    private String content;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    @Setter
    private SecurityRole role;

    protected TbUser(){}
    public static TbUser of(String username, String password) {
        TbUser user = new TbUser();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(SecurityRole.USER);
        return user;
    }


}
