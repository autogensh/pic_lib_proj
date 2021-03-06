package com.piclib.web.dao;

import com.piclib.web.entity.MaterialFile;
import com.piclib.web.entity.MaterialFileExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterialFileMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_material_file
     *
     * @mbg.generated
     */
    long countByExample(MaterialFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_material_file
     *
     * @mbg.generated
     */
    int deleteByExample(MaterialFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_material_file
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_material_file
     *
     * @mbg.generated
     */
    int insert(MaterialFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_material_file
     *
     * @mbg.generated
     */
    int insertSelective(MaterialFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_material_file
     *
     * @mbg.generated
     */
    List<MaterialFile> selectByExample(MaterialFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_material_file
     *
     * @mbg.generated
     */
    MaterialFile selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_material_file
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") MaterialFile record, @Param("example") MaterialFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_material_file
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") MaterialFile record, @Param("example") MaterialFileExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_material_file
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(MaterialFile record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_material_file
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(MaterialFile record);
}