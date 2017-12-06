package com.test.controller;

import com.test.entity.Roles;
import com.test.service.RoleService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RolesController {
    @Resource
    private RoleService rs;

    @RequestMapping("findAllRoles")
    public List<Roles> findAllRoles(){
        return rs.findAllRoles();
    }

    @RequestMapping("saveRoles")
    public String saveRole(Roles role){
        if(role.getId() != 0){
            rs.updateRoles(role);
        } else {
            rs.addRole(role);
        }

        return "1";
    }
    @RequestMapping("deleteRoles")
    public String deleteRoles(@RequestBody ArrayList<Integer> list){
        rs.deleteRoles(list);
        return "1";
    }

    @RequestMapping("fenpei")
    public String fenpei(@RequestBody ArrayList<Integer> list){
        Map<String,Object> map =new HashMap<>();
        map.put("rolesid",list.get(0));
        list.remove(0);
        map.put("ps",list);
        rs.fenpei(map);

        return "1";
    }
}
