package com.piclib.web.controller.admin;

import com.piclib.web.dao.AdminMapper;
import com.piclib.web.dao.MaterialCategoryMapper;
import com.piclib.web.entity.MaterialCategory;
import com.piclib.web.entity.MaterialCategoryExample;
import com.piclib.web.model.CategoryItem;
import com.piclib.web.model.ItemListResp;
import com.piclib.web.model.JsonResp;
import com.piclib.web.model.req.CategoryMoveReq;
import com.piclib.web.model.req.CategoryUpdateReq;
import com.piclib.web.service.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping(basePath + "/list2")
    public Object getCategoryList2() {
        List<CategoryItem> items = categoryService.getCategoryList2();
        ItemListResp<CategoryItem> resp = new ItemListResp<>();
        resp.total = items.size();
        resp.items = items;
        return resp;
    }

    @PostMapping(basePath + "/move")
    public Object move(@RequestBody CategoryMoveReq req) {
        // dropType:'before','after','inner',
        if ("before".equals(req.dropType)) {
            adminMapper.moveCategoryBefore(req.dragId, req.dropId);
        } else if ("after".equals(req.dropType)) {
            adminMapper.moveCategoryAfter(req.dragId, req.dropId);
        } else if ("inner".equals(req.dropType)) {
            adminMapper.moveCategoryInner(req.dragId, req.dropId);
        } else {
            return JsonResp.unsupportOperation();
        }
        return JsonResp.success();
    }

    @PostMapping(basePath + "/update")
    public Object updateCategory(@RequestBody CategoryUpdateReq category) {
        return super.update(category);
    }

    @PostMapping(basePath + "/del")
    public Object deleteCategory(@RequestBody CategoryUpdateReq category) {
        return super.delete(category);
    }
}
