package com.piclib.web.controller;

import com.piclib.web.model.ItemListResp;
import com.piclib.web.model.MaterialInfo;
import com.piclib.web.service.CategoryServiceImpl;
import com.piclib.web.service.MaterialServiceImpl;
import com.piclib.web.util.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;

@Controller
public class IndexController {
    private CategoryServiceImpl categoryService;
    private MaterialServiceImpl materialService;

    @Autowired
    public IndexController(CategoryServiceImpl categoryService, MaterialServiceImpl materialService) {
        this.categoryService = categoryService;
        this.materialService = materialService;
    }

    private Integer checkPage(Integer page) {
        if (page < 1) {
            return 1;
        }
        return page;
    }

    private Integer checkPageSize(Integer pageSize) {
        if (pageSize < 1) {
            return 1;
        }
        if (pageSize > 100) {
            return 100;
        }
        return pageSize;
    }

    // 首页
    @GetMapping("/")
    public String index(
            @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
            @RequestParam(name = "pageSize", required = false, defaultValue = Constants.defaultPageSize) Integer pageSize,
            ModelMap model) {

        page = checkPage(page);
        pageSize = checkPageSize(pageSize);

        // 素材列表
        ItemListResp<HashMap<String, Object>> materials = materialService.getMaterialList(page, pageSize);

        // header
        ItemListResp<HashMap<String, Object>> categories = categoryService.getCategoryList();
        // footer
        ItemListResp<HashMap<String, Object>> footerMaterials = materialService.getMaterialList(1, 8);

        model.addAttribute("focus", footerMaterials.items.get(0));  // 首页聚焦
        model.addAttribute("total", materials.total);
        model.addAttribute("materials", materials.items);
        model.addAttribute("categories", categories.items);
        model.addAttribute("footerMaterials", footerMaterials.items);
        model.addAttribute("page", page);
        model.addAttribute("pageSize", pageSize);
        return "index";
    }

    // 素材详情页
    @GetMapping("/detail")
    public String index(@RequestParam("id") Integer id, ModelMap model) {
        // 素材详情
        MaterialInfo info = materialService.getMaterialInfoById(id);

        // header
        ItemListResp<HashMap<String, Object>> categories = categoryService.getCategoryList();
        // footer
        ItemListResp<HashMap<String, Object>> footerMaterials = materialService.getMaterialList(1, 8);

        model.addAttribute("info", info);  // 素材详情
        model.addAttribute("categories", categories.items);
        model.addAttribute("footerMaterials", footerMaterials.items);
        return "detail";
    }

    // 素材详情页
    @GetMapping("/category")
    public String index(@RequestParam("id") Integer id,
                        @RequestParam(name = "page", required = false, defaultValue = "1") Integer page,
                        @RequestParam(name = "pageSize", required = false, defaultValue = Constants.defaultPageSize) Integer pageSize,
                        ModelMap model) {

        page = checkPage(page);
        pageSize = checkPageSize(pageSize);

        // 素材列表
        ItemListResp<HashMap<String, Object>> materials = materialService.getMaterialListByCatId(page, pageSize, id);

        String name = categoryService.getCategoryNameById(id);

        // header
        ItemListResp<HashMap<String, Object>> categories = categoryService.getCategoryList();

        // footer
        ItemListResp<HashMap<String, Object>> footerMaterials = materialService.getMaterialList(1, 8);
        model.addAttribute("total", materials.total);
        model.addAttribute("materials", materials.items);
        model.addAttribute("categories", categories.items);
        model.addAttribute("footerMaterials", footerMaterials.items);
        model.addAttribute("categoryName", name);
        model.addAttribute("page", page);
        model.addAttribute("pageSize", pageSize);
        return "category";
    }
}
