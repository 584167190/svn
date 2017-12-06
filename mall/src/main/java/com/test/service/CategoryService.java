package com.test.service;

import com.test.dao.CategoryDao;
import com.test.entity.Category;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryService {

    @Resource
    private CategoryDao cd;
    @Cacheable(value = "findAllCategory")
    public List<Category> findAllCategory() {
        return cd.findAllCategory();
    }

    public void toaddCategory(Category c) {
        cd.toaddCategory(c);
    }

    public void toeditCategory(Category c) {
        cd.toeditCategory(c);
    }

    public void deleteCategory(int id) {
        List<Category> list = cd.findCategoryByparentid(id);
        if(list.size() == 0) {
            cd.deleteCategory(id);
        } else {
            throw new RuntimeException("要删除的节点下有子节点,不能删除");
        }

    }
}
