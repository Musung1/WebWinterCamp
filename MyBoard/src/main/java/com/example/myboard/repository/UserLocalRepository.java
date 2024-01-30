package com.example.myboard.repository;

import com.example.myboard.domain.TbUser;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Repository
public class UserLocalRepository {
    private Map<String,TbUser> store = new HashMap<>();

    public String save(TbUser user) {
        store.put(user.getUsername(),user);
        return user.getUsername();
    }
    public TbUser getUser(String uid) {
        TbUser user = store.get(uid);
        return user;
    }
}
