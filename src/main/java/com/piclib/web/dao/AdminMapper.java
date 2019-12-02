package com.piclib.web.dao;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface AdminMapper {
    List<Object> selectMaterialList(HashMap<String, Object> param);
    int deleteMaterialFiles(Integer matId);
    int insertMaterialFileList(List<HashMap<String, Object>> list);
}
