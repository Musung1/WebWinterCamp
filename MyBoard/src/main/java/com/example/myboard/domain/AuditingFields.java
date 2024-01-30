package com.example.myboard.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuditingFields that = (AuditingFields) o;
        return Objects.equals(id, that.id) && Objects.equals(deleted, that.deleted) && Objects.equals(createdAt, that.createdAt) && Objects.equals(modifiedAt, that.modifiedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, deleted, createdAt, modifiedAt);
    }

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
