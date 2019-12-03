package com.piclib.web.controller.admin;

import com.piclib.web.dao.AdminMapper;
import com.piclib.web.dao.BaseMapper;
import com.piclib.web.entity.BaseEntity;
import com.piclib.web.entity.BaseExample;
import com.piclib.web.entity.User;
import com.piclib.web.model.ItemListResp;
import com.piclib.web.model.JsonResp;
import com.piclib.web.util.Constants;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class TController<Entity extends BaseEntity,
        Example extends BaseExample, Mapper extends BaseMapper> {
    protected Mapper mapper;
    protected Example example;
    protected AdminMapper adminMapper;

    public TController(Mapper mapper, Example example, AdminMapper adminMapper) {
        this.mapper = mapper;
        this.example = example;
        this.adminMapper = adminMapper;
    }

    public Object getList(String orderBy) {
        return this.getList(orderBy, 1, Integer.parseInt(Constants.defaultPageSize));
    }

    @SuppressWarnings("unchecked")
    public Object getList(String orderBy, Integer page, Integer pageSize) {
        example.clear();
        example.createCriteria().andIsDeletedEqualTo(false);
        example.setOrderByClause(orderBy);
        example.setOffet((page - 1) * pageSize);
        example.setRows(pageSize);
        ItemListResp<Entity> resp = new ItemListResp<>();
        resp.items = (List<Entity>) mapper.selectByExample(example);
        return resp;
    }

    @SuppressWarnings("unchecked")
    public Object getList() {
        return this.getList("updateAt desc, id desc");
    }

    public Object update(@RequestBody Entity e) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int result = 0;

        if (e.getId() == null) {
            e.setCreateBy(user.getId());
            result = mapper.insertSelective(e);
        } else {
            if (!e.getCreateBy().equals(user.getId())) {
                return JsonResp.unauthorizedOperation();
            }
            result = mapper.updateByPrimaryKeySelective(e);
        }
        if (result < 1) {
            return JsonResp.databaseInsertError();
        }
        return JsonResp.success();
    }

    @SuppressWarnings("unchecked")
    public Object delete(@RequestBody Entity e) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!e.getCreateBy().equals(user.getId())) {
            return JsonResp.unauthorizedOperation();
        }
        e.setIsDeleted(true);
        int result = mapper.updateByPrimaryKeySelective(e);
        if (result < 1) {
            return JsonResp.databaseInsertError();
        }
        return JsonResp.success();
    }
}
