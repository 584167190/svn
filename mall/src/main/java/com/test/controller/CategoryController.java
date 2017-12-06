package com.test.controller;

import com.test.bean.JsonBean;
import com.test.entity.Category;
import com.test.service.CategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
public class CategoryController {

    @Resource
    private CategoryService cs;

    @RequestMapping("findAllCategory")
    public List<Category> findAllCategory(){
        return cs.findAllCategory();
    }

    @RequestMapping("toaddCategory")
    public JsonBean toaddCategory(Category c){
        JsonBean bean = new JsonBean();

        cs.toaddCategory(c);

        return bean;
    }
    @RequestMapping("toeditCategory")
    public JsonBean toeditCategory (Category c){
        JsonBean bean = new JsonBean();
        cs.toeditCategory(c);
        return bean;
    }
    @RequestMapping("deleteCategory")
    public JsonBean deleteCategory(int id){
        JsonBean bean = new JsonBean();
        cs.deleteCategory(id);
        return bean;
    }
    @RequestMapping("findCategoryTree")
    public String findCategoryTree(){
        List<Category> list = cs.findAllCategory();
        String c = "";
        for(int i = 0 ; i < list.size() ; i++){
            if(i != list.size() - 1){
                c += list.get(i).toString() + ",";
            } else {
                c += list.get(i).toString();
            }
        }
//      String c1 = JSONArray.fromObject(c).toString();
        String c2 ="{\"rows\":[" +c  +"]}";
        String c3 = c2.replaceAll("parentid","_parentId");
        String c4 = c3.replaceAll("\"_parentId\":0","\"root\":0");
        return c4;
    }
}
