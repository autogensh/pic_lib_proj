package com.piclib.web.service;

import com.piclib.web.dao.AdminMapper;
import com.piclib.web.model.ItemListResp;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class CategoryServiceImpl {
    private AdminMapper adminMapper;

    public CategoryServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
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

    public String getCategoryNameById(int id) {
        return adminMapper.selectCategoryNameById(id);
    }
}
