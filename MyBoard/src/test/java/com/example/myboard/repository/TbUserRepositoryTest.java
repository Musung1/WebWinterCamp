package com.example.myboard.repository;

import com.example.myboard.domain.TbUser;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class TbUserRepositoryTest {
    @Autowired
    private TbUserRepository tbUserRepository;


    @Test
    public void TbUserTest() {
        TbUser user = TbUser.of("musung","123");
        TbUser savedUser = tbUserRepository.save(user);
        Assertions.assertThat(savedUser).isNotNull();
        Optional<TbUser> findUser = tbUserRepository.findByUsername("musung");
        Assertions.assertThat(user).isEqualTo(findUser.get());
    }

}