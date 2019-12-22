package com.piclib.web.service;

import com.piclib.web.dao.AdminMapper;
import com.piclib.web.dao.MaterialCategoryMapper;
import com.piclib.web.entity.MaterialCategory;
import com.piclib.web.entity.MaterialCategoryExample;
import com.piclib.web.model.CategoryItem;
import com.piclib.web.model.ItemListResp;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class CategoryServiceImpl {
    private AdminMapper adminMapper;
    private MaterialCategoryMapper categoryMapper;
    private MaterialCategoryExample categoryExample;

    public CategoryServiceImpl(AdminMapper adminMapper, MaterialCategoryMapper categoryMapper, MaterialCategoryExample categoryExample) {
        this.adminMapper = adminMapper;
        this.categoryMapper = categoryMapper;
        this.categoryExample = categoryExample;
    }

    @SuppressWarnings("unchecked")
    public ItemListResp<HashMap<String, Object>> getCategoryList() {
        HashMap<String, Object> req = new HashMap<>();
        req.put("orderBy", "id");
        List<HashMap<String, Object>> list = adminMapper.selectCategoryList(req);
        ItemListResp<HashMap<String, Object>> resp = new ItemListResp<>();
        resp.items = (List<HashMap<String, Object>>) list.get(0);
        resp.total = ((List<Integer>) list.get(1)).get(0);
        return resp;
    }

    public List<CategoryItem> getCategoryList2() {
        categoryExample.clear();
        categoryExample.setOrderByClause("`order`");
        categoryExample.createCriteria().andIsDeletedEqualTo(false);
        List<MaterialCategory> categories = categoryMapper.selectByExample(categoryExample);
        List<CategoryItem> items = new ArrayList<>();
        for (MaterialCategory c : categories) {
            CategoryItem item = new CategoryItem();
            item.setId(c.getId());
            item.setName(c.getName());
            item.setParent(c.getParent());
            item.setOrder(c.getOrder());

            CategoryItem find = findCategoryItem(items, c.getParent());
            if (find == null) {
                items.add(item);
            } else {
                find.getChildren().add(item);
            }
        }
        return items;
    }

    public String getCategoryNameById(int id) {
        return adminMapper.selectCategoryNameById(id);
    }

    private CategoryItem findCategoryItem(List<CategoryItem> items, int id) {
        for (CategoryItem item : items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }
}
