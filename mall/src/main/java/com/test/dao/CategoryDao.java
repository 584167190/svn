package com.test.dao;

import com.test.entity.Category;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CategoryDao {

    List<Category> findAllCategory();

    void toaddCategory(Category c);

    void toeditCategory(Category c);

    void deleteCategory(int id);

    Category findCategoryById(int id);

    List<Category> findCategoryByparentid(int id);
}
