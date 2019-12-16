package com.piclib.web.controller.admin;

import com.piclib.web.dao.AdminMapper;
import com.piclib.web.dao.MaterialCategoryMapper;
import com.piclib.web.entity.MaterialCategory;
import com.piclib.web.entity.MaterialCategoryExample;
import com.piclib.web.model.ItemListResp;
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

    @Autowired
    public CategoryController(MaterialCategoryMapper mapper, MaterialCategoryExample example, AdminMapper adminMapper) {
        super(mapper, example, adminMapper);
    }

    @SuppressWarnings("unchecked")
    @GetMapping(basePath + "/list")
    public Object getCategoryList() {
        HashMap<String, Object> req = new HashMap<>();
        req.put("orderBy", "id");
        List<Object> list = adminMapper.selectCategoryList(req);
        ItemListResp<HashMap<String, Object>> resp = new ItemListResp<>();
        resp.items = (List<HashMap<String, Object>>) list.get(0);
        resp.total = ((List<Integer>) list.get(1)).get(0);
        return resp;
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
