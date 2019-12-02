package com.piclib.web.dao;

import com.piclib.web.entity.BaseEntity;
import com.piclib.web.entity.BaseExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseMapper {
    List selectByExample(BaseExample example);

    int insertSelective(BaseEntity entity);

    int updateByPrimaryKeySelective(BaseEntity entity);

    int updateByExampleSelective(@Param("record") BaseEntity entity, @Param("example") BaseExample example);
}
