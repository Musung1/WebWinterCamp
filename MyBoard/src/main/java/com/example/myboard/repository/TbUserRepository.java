package com.example.myboard.repository;

import com.example.myboard.domain.TbUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TbUserRepository extends JpaRepository<TbUser,String> {

    Optional<TbUser> findByUsername(String username);
}
