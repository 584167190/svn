package com.test.service;

import com.test.dao.ResDao;
import com.test.entity.Res;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
public class ResService {

    @Resource
    private ResDao rd;

    public List<Res> FindAllRes(int userid){
        return  rd.findAllRes(userid);
    }

    public List<Res> findAllResForRole() {
        return rd.findAllResForRole();
    }

    public List<Res> findAllRess(){
        return rd.findAllRess();
    }

    public void toaddfu(String text) {
        rd.toaddfu(text);
    }

    public void toaddzi(Map<String,Object> map) {
        rd.toaddzi(map);
    }

    public void toeditname(Map<String, Object> map) {
        rd.toeditname(map);
    }

    public void todeleteRess(int ressid) {
        int id = ressid;
        Res r = rd.findRessById(id);
//        int parentid = r.getParentid();
        if(r.getParentid() != 0){
            rd.todeleteRess(id);
        } else {

            rd.todeleteRess(id);
            List<Res> list = rd.findRessByParentid(id);
            Map<String,Integer> map = new HashMap<>();
            for(int i = 0 ; i < list.size() ; i++){
                map.put("parentid",r.getParentid());
                map.put("id",list.get(i).getId());
                rd.updateparentid(map);
            }
        }
    }
}
