package com.piclib.web.dao;

import com.piclib.web.entity.MaterialTag;
import com.piclib.web.entity.MaterialTagExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialTagMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_material_tag
     *
     * @mbg.generated
     */
    long countByExample(MaterialTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_material_tag
     *
     * @mbg.generated
     */
    int deleteByExample(MaterialTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_material_tag
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_material_tag
     *
     * @mbg.generated
     */
    int insert(MaterialTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_material_tag
     *
     * @mbg.generated
     */
    int insertSelective(MaterialTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_material_tag
     *
     * @mbg.generated
     */
    List<MaterialTag> selectByExample(MaterialTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_material_tag
     *
     * @mbg.generated
     */
    MaterialTag selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_material_tag
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") MaterialTag record, @Param("example") MaterialTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_material_tag
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") MaterialTag record, @Param("example") MaterialTagExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_material_tag
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(MaterialTag record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_material_tag
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(MaterialTag record);
}