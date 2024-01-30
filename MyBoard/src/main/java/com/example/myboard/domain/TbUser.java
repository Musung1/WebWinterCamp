package com.example.myboard.domain;

import com.example.myboard.dto.security.SecurityRole;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.*;

@Getter
@ToString(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class TbUser extends AuditingFields{
    @Column(nullable = false)
    @Setter
    private String username;
    @Column(nullable = false)
    @Setter
    private String password;
    @Column(nullable = false)
    @Setter
    private String nickName;
    @Column(nullable = false)
    @Setter
    private String name;
    @Column(nullable = false)
    @Setter
    private String phone;
    @Column(nullable = false)
    @Setter
    private String pic;
    @Column(nullable = false)
    @Setter
    private String content;
    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private SecurityRole role;

}
