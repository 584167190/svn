package com.test.service;

import com.test.dao.RolesDao;
import com.test.entity.Roles;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RoleService {

    @Resource
    private RolesDao rolesDao;

    public List<Roles> findAllRoles(){
        return rolesDao.findAllRoles();
    }

    public void addRole(Roles role){
        rolesDao.saveRole(role);
    }

    public void deleteRoles(ArrayList<Integer> list){
        rolesDao.deleteRoles(list);
    }

    public void updateRoles(Roles role){
        rolesDao.updateRole(role);
    }

    @Transactional
    public void fenpei(Map<String, Object> map) {
        rolesDao.deleteOld(map.get("rolesid"));

        rolesDao.fenpei(map);
    }
}
