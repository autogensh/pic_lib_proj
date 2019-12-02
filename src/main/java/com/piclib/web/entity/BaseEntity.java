package com.piclib.web.entity;

import java.util.Date;

public interface BaseEntity {
    Integer getId();

    void setId(Integer id);

    Boolean getIsDeleted();

    void setIsDeleted(Boolean isDeleted);

    Date getUpdateAt();

    void setUpdateAt(Date updateAt);

    Integer getCreateBy();
    
    void setCreateBy(Integer id);
}
