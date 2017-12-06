package com.test.controller;

import com.test.entity.Res;
import com.test.service.ResService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ResController {
    @Resource
    private ResService rs;

    @RequestMapping("findAllRes")
    public List<Res> findAllRes(HttpSession session){
        int userid = (int)session.getAttribute("userid");
        return rs.FindAllRes(userid);
    }

    @RequestMapping("findAllResForRole")
    public List<Res> findAllResForRole(){
        return rs.findAllResForRole();
    }

    @RequestMapping("findAllRess")
    public List<Res> findAllRess(){
        return rs.findAllRess();
    }

    @RequestMapping("toaddfu")
    public String toaddfu(String text){
        System.out.print("11111"+text);
        rs.toaddfu(text);
        return "1";
    }
    @RequestMapping("toaddzi")
    public String toaddzi(int ressid ,String ziname){
        System.out.print("toaddzi" + ressid + ":"+ ziname);
        Map<String,Object> map = new HashMap<>();
        map.put("parentid",ressid);
        map.put("text",ziname);
        rs.toaddzi(map);
        return "1";
    }
    @RequestMapping("toeditname")
    public String toeditname(int ressid ,String jiedianname){
        Map<String,Object> map = new HashMap<>();
        map.put("id",ressid);
        map.put("text",jiedianname);
        rs.toeditname(map);
        return "1";
    }
    @RequestMapping("todeleteRess")
    public String todeleteRess(int ressid){
        rs.todeleteRess(ressid);
        return "1";
    }
}
