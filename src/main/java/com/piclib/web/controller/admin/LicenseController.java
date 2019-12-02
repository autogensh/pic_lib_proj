package com.piclib.web.controller.admin;

import com.piclib.web.dao.AdminMapper;
import com.piclib.web.dao.LicenseMapper;
import com.piclib.web.entity.License;
import com.piclib.web.entity.LicenseExample;
import com.piclib.web.model.ItemListResp;
import com.piclib.web.model.JsonResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class LicenseController extends TController<License, LicenseExample, LicenseMapper> {
    private static final String basePath = "/admin/license";

    @Autowired
    public LicenseController(LicenseMapper mapper, LicenseExample example, AdminMapper adminMapper) {
        super(mapper, example, adminMapper);
    }

    @GetMapping(basePath + "/list")
    public Object getLicenseList() {
        return super.getList("id desc", 1, 1000);
    }

    @PostMapping(basePath + "/update")
    public Object updateLicense(@RequestBody License license) {
        return super.update(license);
    }

    @PostMapping(basePath + "/del")
    public Object deleteLicense(@RequestBody License license) {
        return super.delete(license);
    }
}
