package com.piclib.web.service;

import com.piclib.web.dao.AdminMapper;
import com.piclib.web.dao.MaterialFileMapper;
import com.piclib.web.dao.MaterialMapper;
import com.piclib.web.dao.MaterialTagMapper;
import com.piclib.web.entity.*;
import com.piclib.web.model.ItemListResp;
import com.piclib.web.model.MaterialInfo;
import com.piclib.web.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MaterialServiceImpl {
    private MaterialMapper mapper;
    private MaterialExample example;
    private AdminMapper adminMapper;
    private MaterialFileMapper fileMapper;
    private MaterialFileExample fileExample;
    private MaterialTagMapper tagMapper;
    private MaterialTagExample tagExample;

    @Autowired
    public MaterialServiceImpl(
            MaterialMapper mapper,
            MaterialExample example,
            AdminMapper adminMapper,
            MaterialFileMapper fileMapper,
            MaterialFileExample fileExample,
            MaterialTagMapper tagMapper,
            MaterialTagExample tagExample) {
        this.mapper = mapper;
        this.example = example;
        this.adminMapper = adminMapper;
        this.fileMapper = fileMapper;
        this.fileExample = fileExample;
        this.tagMapper = tagMapper;
        this.tagExample = tagExample;
    }

    public ItemListResp<HashMap<String, Object>> getMaterialList(int page, int pageSize) {
        HashMap<String, Object> req = new HashMap<>();
        req.put("page", page);
        req.put("pageSize", pageSize);
        req.put("orderBy", "updateAt desc");
        return getMaterialList(req);
    }

    public ItemListResp<HashMap<String, Object>> getMaterialListByCatId(int page, int pageSize, int catId) {
        HashMap<String, Object> req = new HashMap<>();
        req.put("page", page);
        req.put("pageSize", pageSize);
        req.put("orderBy", "updateAt desc");
        req.put("catId", catId);
        return getMaterialList(req);
    }

    @SuppressWarnings("unchecked")
    private ItemListResp<HashMap<String, Object>> getMaterialList(HashMap<String, Object> req) {
        List<HashMap<String, Object>> list = adminMapper.selectMaterialList(req);
        ItemListResp<HashMap<String, Object>> resp = new ItemListResp<>();
        resp.items = (List<HashMap<String, Object>>) list.get(0);
        resp.total = ((List<Integer>) list.get(1)).get(0);
        return resp;
    }

    public MaterialInfo getMaterialInfoById(Integer id) {
        MaterialInfo info = adminMapper.selectMaterialInfoWithoutImg(id);

        fileExample.clear();
        fileExample.createCriteria().andMatIdEqualTo(id);
        List<MaterialFile> files = fileMapper.selectByExample(fileExample);
        info.setFiles(files);

        return info;
    }
}
