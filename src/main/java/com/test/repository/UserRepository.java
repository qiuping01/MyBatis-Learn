package com.test.repository;

import com.test.entity.User;
import com.test.util.ParameterPOJO;

import java.util.List;

public interface UserRepository {
    public int add(User user);
    public int delete(Integer id);
    public int update(User user);
    public User getById(Integer id);
    List<User> getByUsername(String username);
    public User getByAge(int age);
    public User getByUsernameAndAge(String username, int age);
    public User getByParameterPOJO(ParameterPOJO parameterPOJO);
    public int getCount();
    public Integer getCountByInteger();
    public String getUsernameById(Integer id);
}
