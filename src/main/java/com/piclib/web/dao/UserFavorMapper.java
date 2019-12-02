package com.piclib.web.dao;

import com.piclib.web.entity.UserFavor;
import com.piclib.web.entity.UserFavorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFavorMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_favor
     *
     * @mbg.generated
     */
    long countByExample(UserFavorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_favor
     *
     * @mbg.generated
     */
    int deleteByExample(UserFavorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_favor
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_favor
     *
     * @mbg.generated
     */
    int insert(UserFavor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_favor
     *
     * @mbg.generated
     */
    int insertSelective(UserFavor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_favor
     *
     * @mbg.generated
     */
    List<UserFavor> selectByExample(UserFavorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_favor
     *
     * @mbg.generated
     */
    UserFavor selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_favor
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") UserFavor record, @Param("example") UserFavorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_favor
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") UserFavor record, @Param("example") UserFavorExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_favor
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(UserFavor record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_user_favor
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(UserFavor record);
}