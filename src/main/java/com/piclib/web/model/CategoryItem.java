package com.piclib.web.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CategoryItem {
    private int id;
    private String name;
    private int parent;
    private BigDecimal order;
    private List<CategoryItem> children = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public BigDecimal getOrder() {
        return order;
    }

    public void setOrder(BigDecimal order) {
        this.order = order;
    }

    public List<CategoryItem> getChildren() {
        return children;
    }

    public void setChildren(List<CategoryItem> children) {
        this.children = children;
    }
}
