package com.test.dao;

import com.test.entity.Res;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
@Mapper
public interface ResDao {
   public List<Res> findAllRes(int userid);

    List<Res> findAllResForRole();

    public List<Res> findAllRess();

    void toaddfu(String text);

    void toaddzi(Map<String, Object> map);

    void toeditname(Map<String, Object> map);

    Res findRessById(int id);

    void updateparentid(Map<String, Integer> map);

    void todeleteRess(int id);

    List<Res> findRessByParentid(int parentid);
}
