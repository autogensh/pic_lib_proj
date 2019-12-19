package com.piclib.web.controller.admin;

import com.piclib.web.dao.AdminMapper;
import com.piclib.web.dao.MaterialCategoryMapper;
import com.piclib.web.entity.MaterialCategory;
import com.piclib.web.entity.MaterialCategoryExample;
import com.piclib.web.model.ItemListResp;
import com.piclib.web.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class CategoryController extends TController<MaterialCategory, MaterialCategoryExample, MaterialCategoryMapper> {
    private static final String basePath = "/admin/category";

    private CategoryServiceImpl categoryService;

    @Autowired
    public CategoryController(MaterialCategoryMapper mapper, MaterialCategoryExample example, AdminMapper adminMapper, CategoryServiceImpl categoryService) {
        super(mapper, example, adminMapper);
        this.categoryService = categoryService;
    }

    @GetMapping(basePath + "/list")
    public Object getCategoryList() {
        return categoryService.getCategoryList();
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
