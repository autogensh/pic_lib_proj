package com.piclib.web.model;

import com.piclib.web.entity.MaterialFile;

public class UploadResp extends JsonResp {
    public MaterialFile materialFile;
    public UploadResp(MaterialFile materialFile) {
        super();
        this.materialFile = materialFile;
    }
}
