package com.piclib.web.model;

import com.piclib.web.entity.Material;

import java.util.HashMap;
import java.util.List;

public class MaterialUpdateReq extends Material {
    private String tags;
    private String owner;
    private String categoryName;
    private String licenseTitle;
    private String coverImg;
    private String measure;
    private String colorSpace;
    private String fileSize;
    private String fileFormat;

    private List<HashMap<String, Object>> materialImgs;

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getLicenseTitle() {
        return licenseTitle;
    }

    public void setLicenseTitle(String licenseTitle) {
        this.licenseTitle = licenseTitle;
    }

    public String getCoverImg() {
        return coverImg;
    }

    public void setCoverImg(String coverImg) {
        this.coverImg = coverImg;
    }

    public String getMeasure() {
        return measure;
    }

    public void setMeasure(String measure) {
        this.measure = measure;
    }

    public String getColorSpace() {
        return colorSpace;
    }

    public void setColorSpace(String colorSpace) {
        this.colorSpace = colorSpace;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileFormat() {
        return fileFormat;
    }

    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat;
    }

    public List<HashMap<String, Object>> getMaterialImgs() {
        return materialImgs;
    }

    public void setMaterialImgs(List<HashMap<String, Object>> materialImgs) {
        this.materialImgs = materialImgs;
    }
}
