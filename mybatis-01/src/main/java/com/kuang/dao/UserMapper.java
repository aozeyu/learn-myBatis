package com.kuang.dao;

import java.util.List;
import java.util.Map;

import com.kuang.pojo.User;
public interface UserMapper {
    List<User> getUserLike(String value);
    List<User> getUserList();
    User  getUserById(int id);
    int addUser2(Map<String, Object> map);
    User getUserById2(Map<String, Object> map);
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(int id);
}
