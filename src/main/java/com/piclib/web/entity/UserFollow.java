package com.piclib.web.entity;

import java.io.Serializable;
import java.util.Date;

public class UserFollow implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_follow.id
     *
     * @mbg.generated
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_follow.userId
     *
     * @mbg.generated
     */
    private Integer userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_follow.followUserId
     *
     * @mbg.generated
     */
    private Integer followUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_follow.isDeleted
     *
     * @mbg.generated
     */
    private Boolean isDeleted;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_follow.createAt
     *
     * @mbg.generated
     */
    private Date createAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_user_follow.updateAt
     *
     * @mbg.generated
     */
    private Date updateAt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_user_follow
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_follow.id
     *
     * @return the value of t_user_follow.id
     *
     * @mbg.generated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_follow.id
     *
     * @param id the value for t_user_follow.id
     *
     * @mbg.generated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_follow.userId
     *
     * @return the value of t_user_follow.userId
     *
     * @mbg.generated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_follow.userId
     *
     * @param userId the value for t_user_follow.userId
     *
     * @mbg.generated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_follow.followUserId
     *
     * @return the value of t_user_follow.followUserId
     *
     * @mbg.generated
     */
    public Integer getFollowUserId() {
        return followUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_follow.followUserId
     *
     * @param followUserId the value for t_user_follow.followUserId
     *
     * @mbg.generated
     */
    public void setFollowUserId(Integer followUserId) {
        this.followUserId = followUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_follow.isDeleted
     *
     * @return the value of t_user_follow.isDeleted
     *
     * @mbg.generated
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_follow.isDeleted
     *
     * @param isDeleted the value for t_user_follow.isDeleted
     *
     * @mbg.generated
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_follow.createAt
     *
     * @return the value of t_user_follow.createAt
     *
     * @mbg.generated
     */
    public Date getCreateAt() {
        return createAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_follow.createAt
     *
     * @param createAt the value for t_user_follow.createAt
     *
     * @mbg.generated
     */
    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user_follow.updateAt
     *
     * @return the value of t_user_follow.updateAt
     *
     * @mbg.generated
     */
    public Date getUpdateAt() {
        return updateAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user_follow.updateAt
     *
     * @param updateAt the value for t_user_follow.updateAt
     *
     * @mbg.generated
     */
    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_follow
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
        sb.append(", userId=").append(userId);
        sb.append(", followUserId=").append(followUserId);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", createAt=").append(createAt);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}