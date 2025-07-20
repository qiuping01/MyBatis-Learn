package com.test.repository;

import com.test.entity.User;

import java.util.List;

public interface UserRepository {
    public User get(User user);
    public int update(User user);
}
