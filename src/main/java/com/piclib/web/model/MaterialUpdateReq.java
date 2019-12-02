package com.piclib.web.model;

import com.piclib.web.entity.Material;

import java.util.HashMap;
import java.util.List;

public class MaterialUpdateReq extends Material {
    private List<HashMap<String, Object>> materialImgs;

    public List<HashMap<String, Object>> getMaterialImgs() {
        return materialImgs;
    }

    public void setMaterialImgs(List<HashMap<String, Object>> materialImgs) {
        this.materialImgs = materialImgs;
    }
}
