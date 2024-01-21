package com.example.myboard.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@ToString(callSuper = true)
@Entity
public class TbBoard extends AuditingFields{
    @Setter
    @Column(nullable = false)
    private String title;
    @Setter
    @Column(nullable = false, length = 1000)
    private String content;

    @Setter
    @Column(nullable = false)
    private int views;

    public TbBoard() {

    }
    private TbBoard(String title, String content) {
        this.title = title;
        this.content = content;
        this.views = 0;
    }
    public static TbBoard of(String title, String content) {
        return new TbBoard(title, content);
    }
}
