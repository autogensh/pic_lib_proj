package com.piclib.web.model;

import java.util.List;

public class ItemListResp<T> extends JsonResp {
    public Integer total;
    public List<T> items;
}
