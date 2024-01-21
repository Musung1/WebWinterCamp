package com.example.myboard.domain;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@ToString(callSuper = true)
@AllArgsConstructor
public class TbUser extends AuditingFields{
    @Column(nullable = false)
    @Setter
    private String uid;
    @Column(nullable = false)
    @Setter
    private String pw;
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

}
