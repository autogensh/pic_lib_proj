package com.piclib.web.entity;

import java.io.Serializable;
import java.util.Date;

public class Material implements Serializable, BaseEntity {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_material.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_material.catId
     *
     * @mbg.generated
     */
    private Integer catId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_material.name
     *
     * @mbg.generated
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_material.isDeleted
     *
     * @mbg.generated
     */
    private Boolean isDeleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_material.license
     *
     * @mbg.generated
     */
    private Integer license;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_material.desc
     *
     * @mbg.generated
     */
    private String desc;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_material.views
     *
     * @mbg.generated
     */
    private Integer views;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_material.downs
     *
     * @mbg.generated
     */
    private Integer downs;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_material.createAt
     *
     * @mbg.generated
     */
    private Date createAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_material.updateAt
     *
     * @mbg.generated
     */
    private Date updateAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_material.createBy
     *
     * @mbg.generated
     */
    private Integer createBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_material
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_material.id
     *
     * @return the value of t_material.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_material.id
     *
     * @param id the value for t_material.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_material.catId
     *
     * @return the value of t_material.catId
     *
     * @mbg.generated
     */
    public Integer getCatId() {
        return catId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_material.catId
     *
     * @param catId the value for t_material.catId
     *
     * @mbg.generated
     */
    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_material.name
     *
     * @return the value of t_material.name
     *
     * @mbg.generated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_material.name
     *
     * @param name the value for t_material.name
     *
     * @mbg.generated
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_material.isDeleted
     *
     * @return the value of t_material.isDeleted
     *
     * @mbg.generated
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_material.isDeleted
     *
     * @param isDeleted the value for t_material.isDeleted
     *
     * @mbg.generated
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_material.license
     *
     * @return the value of t_material.license
     *
     * @mbg.generated
     */
    public Integer getLicense() {
        return license;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_material.license
     *
     * @param license the value for t_material.license
     *
     * @mbg.generated
     */
    public void setLicense(Integer license) {
        this.license = license;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_material.desc
     *
     * @return the value of t_material.desc
     *
     * @mbg.generated
     */
    public String getDesc() {
        return desc;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_material.desc
     *
     * @param desc the value for t_material.desc
     *
     * @mbg.generated
     */
    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_material.views
     *
     * @return the value of t_material.views
     *
     * @mbg.generated
     */
    public Integer getViews() {
        return views;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_material.views
     *
     * @param views the value for t_material.views
     *
     * @mbg.generated
     */
    public void setViews(Integer views) {
        this.views = views;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_material.downs
     *
     * @return the value of t_material.downs
     *
     * @mbg.generated
     */
    public Integer getDowns() {
        return downs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_material.downs
     *
     * @param downs the value for t_material.downs
     *
     * @mbg.generated
     */
    public void setDowns(Integer downs) {
        this.downs = downs;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_material.createAt
     *
     * @return the value of t_material.createAt
     *
     * @mbg.generated
     */
    public Date getCreateAt() {
        return createAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_material.createAt
     *
     * @param createAt the value for t_material.createAt
     *
     * @mbg.generated
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_material.updateAt
     *
     * @return the value of t_material.updateAt
     *
     * @mbg.generated
     */
    public Date getUpdateAt() {
        return updateAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_material.updateAt
     *
     * @param updateAt the value for t_material.updateAt
     *
     * @mbg.generated
     */
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_material.createBy
     *
     * @return the value of t_material.createBy
     *
     * @mbg.generated
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_material.createBy
     *
     * @param createBy the value for t_material.createBy
     *
     * @mbg.generated
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_material
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
        sb.append(", catId=").append(catId);
        sb.append(", name=").append(name);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", license=").append(license);
        sb.append(", desc=").append(desc);
        sb.append(", views=").append(views);
        sb.append(", downs=").append(downs);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", createBy=").append(createBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}