package com.piclib.web.entity;

import java.io.Serializable;

public class MaterialFile implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_material_file.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_material_file.matId
     *
     * @mbg.generated
     */
    private Integer matId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_material_file.fileUrl
     *
     * @mbg.generated
     */
    private String fileUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_material_file.fileFormat
     *
     * @mbg.generated
     */
    private String fileFormat;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_material_file.fileSize
     *
     * @mbg.generated
     */
    private String fileSize;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_material_file.desc
     *
     * @mbg.generated
     */
    private String desc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_material_file.measure
     *
     * @mbg.generated
     */
    private String measure;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_material_file.colorSpace
     *
     * @mbg.generated
     */
    private String colorSpace;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_material_file.isDeleted
     *
     * @mbg.generated
     */
    private Boolean isDeleted;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_material_file
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_material_file.id
     *
     * @return the value of t_material_file.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_material_file.id
     *
     * @param id the value for t_material_file.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_material_file.matId
     *
     * @return the value of t_material_file.matId
     *
     * @mbg.generated
     */
    public Integer getMatId() {
        return matId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_material_file.matId
     *
     * @param matId the value for t_material_file.matId
     *
     * @mbg.generated
     */
    public void setMatId(Integer matId) {
        this.matId = matId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_material_file.fileUrl
     *
     * @return the value of t_material_file.fileUrl
     *
     * @mbg.generated
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_material_file.fileUrl
     *
     * @param fileUrl the value for t_material_file.fileUrl
     *
     * @mbg.generated
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl == null ? null : fileUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_material_file.fileFormat
     *
     * @return the value of t_material_file.fileFormat
     *
     * @mbg.generated
     */
    public String getFileFormat() {
        return fileFormat;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_material_file.fileFormat
     *
     * @param fileFormat the value for t_material_file.fileFormat
     *
     * @mbg.generated
     */
    public void setFileFormat(String fileFormat) {
        this.fileFormat = fileFormat == null ? null : fileFormat.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_material_file.fileSize
     *
     * @return the value of t_material_file.fileSize
     *
     * @mbg.generated
     */
    public String getFileSize() {
        return fileSize;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_material_file.fileSize
     *
     * @param fileSize the value for t_material_file.fileSize
     *
     * @mbg.generated
     */
    public void setFileSize(String fileSize) {
        this.fileSize = fileSize == null ? null : fileSize.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_material_file.desc
     *
     * @return the value of t_material_file.desc
     *
     * @mbg.generated
     */
    public String getDesc() {
        return desc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_material_file.desc
     *
     * @param desc the value for t_material_file.desc
     *
     * @mbg.generated
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_material_file.measure
     *
     * @return the value of t_material_file.measure
     *
     * @mbg.generated
     */
    public String getMeasure() {
        return measure;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_material_file.measure
     *
     * @param measure the value for t_material_file.measure
     *
     * @mbg.generated
     */
    public void setMeasure(String measure) {
        this.measure = measure == null ? null : measure.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_material_file.colorSpace
     *
     * @return the value of t_material_file.colorSpace
     *
     * @mbg.generated
     */
    public String getColorSpace() {
        return colorSpace;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_material_file.colorSpace
     *
     * @param colorSpace the value for t_material_file.colorSpace
     *
     * @mbg.generated
     */
    public void setColorSpace(String colorSpace) {
        this.colorSpace = colorSpace == null ? null : colorSpace.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_material_file.isDeleted
     *
     * @return the value of t_material_file.isDeleted
     *
     * @mbg.generated
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_material_file.isDeleted
     *
     * @param isDeleted the value for t_material_file.isDeleted
     *
     * @mbg.generated
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_material_file
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", matId=").append(matId);
        sb.append(", fileUrl=").append(fileUrl);
        sb.append(", fileFormat=").append(fileFormat);
        sb.append(", fileSize=").append(fileSize);
        sb.append(", desc=").append(desc);
        sb.append(", measure=").append(measure);
        sb.append(", colorSpace=").append(colorSpace);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}