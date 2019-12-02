package com.piclib.web.entity;

public abstract class BaseExample {
    // 支持分页
    protected Integer offset;
    protected Integer rows;

    public void setOffet(Integer offer) {
        this.offset = offset;
    }

    public Integer getOffset() {
        return this.offset;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getRows() {
        return this.rows;
    }

    public abstract void clear();

    public abstract void setOrderByClause(String orderByClause);

    public abstract Criteria createCriteria();

    public interface Criteria {
        Criteria andIsDeletedEqualTo(Boolean value);

        Criteria andIdEqualTo(Integer value);
    }
}
