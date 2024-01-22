package com.example.myboard.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.UUID;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class AuditingFields {

    @Id
    @Getter
    private String id;

    @Column
    @Setter
    @Getter
    protected String deleted;

    @Column(nullable = false, updatable = false)
    @CreatedDate
    @Getter
    protected LocalDateTime createdAt;

    @Column(nullable = false, updatable = false)
    @LastModifiedDate
    @Getter
    protected LocalDateTime modifiedAt;

    @PrePersist
    private void onPrePersist() {
        this.id = UUID.randomUUID().toString().replace("-","");
        this.deleted = "N";
    }




}
