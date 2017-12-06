package com.test.controller;

import com.test.entity.User;
import com.test.service.UserService;
import com.test.utiil.SecurityUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

    @Resource
    private UserService us;

    @RequestMapping("findAllUser")
    public List<User> findAllUser(){

        return us.findAllUser();
    }
    @RequestMapping("saveUser")
    public String saveUser(User user){
        int id = user.getId();
        if(id!=0){

            us.updateUser(user);
        } else {
            String mPwd = SecurityUtil.encrypt(user.getPwd());
            user.setPwd(mPwd);
            us.saveUser(user);
        }
        return "1";
    }
    @RequestMapping("deleteUser")
    public String deleteUser(@RequestBody ArrayList<Integer> data){
        us.deleteUser(data);
        return "1";
    }

    @RequestMapping("findUserAndRole")
    public List<User> findUserAndRole(){
        return us.findUserAndRole();
    }

    @RequestMapping("userPagination")
    public List<User> userPagination(int page, int size){
        System.out.println(page);
        int start = (page - 1) * size;
        Map<String,Integer> map = new HashMap<>();
        map.put("start",start);
        map.put("size",size);
        return us.userPagination(map);
    }
    @RequestMapping("getCount")
    public int getCount(){
        return us.getCount();
    }

    @RequestMapping("login")
    public String login(User user, HttpSession session){
        user.setPwd(SecurityUtil.encrypt(user.getPwd()));
        User u = us.login(user);
        if(u != null){
            session.setAttribute("userid",u.getId());
            return "1";
        } else {
            return "0";
        }

    }

}









































