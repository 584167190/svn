package com.test.service;

import com.test.dao.UserDao;
import com.test.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Resource
    private UserDao ud;

    public int getCount(){
        return ud.getCount();
    };

    public List<User> findAllUser(){
        return ud.findAllUser();
    }
    public void saveUser(User user){
        ud.saveUser(user);
    }
    public void deleteUser(ArrayList<Integer> list){

        ud.deleteUser(list);
    }
    public void updateUser(User user){
        ud.updateUser(user);
    }
    public List<User> findUserAndRole(){
        return ud.findUserAndRole();
    }

    public List<User> userPagination(Map<String, Integer> map) {
        return ud.userPagination(map);
    }

    public User login(User user) {
       return ud.login(user);
    }
}
