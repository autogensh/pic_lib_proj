package com.piclib.web.controller.admin;

import com.piclib.web.dao.AdminMapper;
import com.piclib.web.dao.MaterialCategoryMapper;
import com.piclib.web.entity.MaterialCategory;
import com.piclib.web.entity.MaterialCategoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController extends TController<MaterialCategory, MaterialCategoryExample, MaterialCategoryMapper> {
    private static final String basePath = "/admin/category";

    @Autowired
    public CategoryController(MaterialCategoryMapper mapper, MaterialCategoryExample example, AdminMapper adminMapper) {
        super(mapper, example, adminMapper);
    }

    @GetMapping(basePath + "/list")
    public Object getCategoryList() {
        return super.getList("updateAt desc, id desc", 1, 1000);
    }

    @PostMapping(basePath + "/update")
    public Object updateCategory(@RequestBody MaterialCategory category) {
        return super.update(category);
    }

    @PostMapping(basePath + "/del")
    public Object deleteCategory(@RequestBody MaterialCategory category) {
        return super.delete(category);
    }
}
