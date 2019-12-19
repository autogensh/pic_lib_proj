package com.piclib.web.dao;

import com.piclib.web.model.MaterialInfo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface AdminMapper {
    List<HashMap<String, Object>> selectMaterialList(HashMap<String, Object> param);

    List<HashMap<String, Object>> selectCategoryList(HashMap<String, Object> param);

    String selectCategoryNameById(Integer id);

    MaterialInfo selectMaterialInfoWithoutImg(Integer matId);

    int deleteMaterialTags(Integer matId);

    int deleteMaterialFiles(Integer matId);

    int insertMaterialFileList(List<HashMap<String, Object>> list);

    int insertMaterialTagList(List<HashMap<String, Object>> list);
}
