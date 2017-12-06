package com.test.dao;


import com.test.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface UserDao {
    public List<User> findAllUser();
    public void saveUser(User user);
    public void deleteUser(ArrayList<Integer> list);
    public void updateUser(User user);
    public List<User> findUserAndRole();
    List<User> userPagination(Map<String, Integer> map);

    int getCount();

    User login(User user);
}
