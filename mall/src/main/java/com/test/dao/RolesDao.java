package com.test.dao;


import com.test.entity.Roles;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface RolesDao {
    public List<Roles> findAllRoles();
    public void saveRole(Roles role);
    public void deleteRoles(ArrayList<Integer> list);
    public void updateRole(Roles role);
    public void deleteOld(Object rolesid);
    void fenpei(Map<String, Object> map);
}
