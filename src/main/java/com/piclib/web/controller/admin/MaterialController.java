package com.piclib.web.controller.admin;

import com.piclib.web.dao.AdminMapper;
import com.piclib.web.dao.MaterialFileMapper;
import com.piclib.web.dao.MaterialMapper;
import com.piclib.web.entity.*;
import com.piclib.web.model.ItemListResp;
import com.piclib.web.model.JsonResp;
import com.piclib.web.model.MaterialUpdateReq;
import com.piclib.web.model.UploadResp;
import com.piclib.web.util.Constants;
import com.piclib.web.util.Generator;
import com.piclib.web.util.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

@RestController
public class MaterialController extends TController<Material, MaterialExample, MaterialMapper> {
    private static final String basePath = "/admin/material";
    private MaterialFileMapper fileMapper;
    private MaterialFileExample fileExample;

    @Autowired
    public MaterialController(
            MaterialMapper mapper,
            MaterialExample example,
            AdminMapper adminMapper,
            MaterialFileMapper fileMapper,
            MaterialFileExample fileExample) {
        super(mapper, example, adminMapper);
        this.fileMapper = fileMapper;
        this.fileExample = fileExample;
    }

    @SuppressWarnings("unchecked")
    @GetMapping(basePath + "/list")
    public Object getList(
            @RequestParam(name = "page", required = false, defaultValue = Constants.defaultPage) Integer page,
            @RequestParam(name = "pageSize", required = false, defaultValue = Constants.defaultPageSize) Integer pageSize) {
        HashMap<String, Object> req = new HashMap<>();
        req.put("page", page);
        req.put("pageSize", pageSize);
        req.put("orderBy", "updateAt desc");
        List<Object> list = adminMapper.selectMaterialList(req);
        ItemListResp<HashMap<String, Object>> resp = new ItemListResp<>();
        resp.items = (List<HashMap<String, Object>>) list.get(0);
        resp.total = ((List<Integer>) list.get(1)).get(0);
        return resp;
    }

    @PostMapping(basePath + "/upload")
    public Object uploadFile(@RequestParam("file") MultipartFile file) {
        // 获取扩展名
        String contentType = file.getContentType();
        assert contentType != null;
        String ext = contentType.substring(contentType.indexOf("/") + 1);
        int width = 0;
        int height = 0;
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int min = c.get(Calendar.MINUTE);
        int sec = c.get(Calendar.SECOND);
        int ms = c.get(Calendar.MILLISECOND);
        String date = String.format("%d-%d-%d", year, month, day);
        String filePath = String.format("D:\\nginx-1.17.5\\html\\images\\%s", date);
        String fileName = String.format("%d%d%d%d%d%d%d_%s.orin",
                year, month, day, hour, min, sec, ms,
                Generator.generateString(5));
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            if (!targetFile.mkdirs()) {
                return JsonResp.uploadFileError();
            }
        }
        try {
            String newFile = String.format("%s\\%s.%s", filePath, fileName, ext);
            FileOutputStream fos = new FileOutputStream(newFile);
            fos.write(file.getBytes());
            fos.flush();
            fos.close();

            // 获取图片信息
            BufferedImage bi = ImageIO.read(new ByteArrayInputStream(file.getBytes()));
            width = bi.getWidth();
            height = bi.getHeight();
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResp.uploadFileError();
        }

        // 返回一个materialFile对象
        String url = String.format("/images/%s/%s.%s", date, fileName, ext);
        MaterialFile materialFile = new MaterialFile();
        materialFile.setFileUrl(url);
        materialFile.setFileFormat(ext);
        materialFile.setFileSize(Utils.humanSize(file.getSize()));
        materialFile.setDesc("");
        materialFile.setMeasure(String.format("%dx%d", width, height));
        materialFile.setColorSpace("sRGB");
        return new UploadResp(materialFile);
    }

    @PostMapping(basePath + "/update")
    public Object update(@RequestBody MaterialUpdateReq req) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        int result = 0;

        // 更新t_material表
        if (req.getId() == null) {
            req.setCreateBy(user.getId());
            result = mapper.insertSelective(req);
        } else {
            // update需要检查是否有操作权限，直接修改自己发布的素材
            Material material = mapper.selectByPrimaryKey(req.getId());
            if (!material.getCreateBy().equals(user.getId())) {
                return JsonResp.unauthorizedOperation();
            }
            example.clear();
            example.createCriteria().andCreateByEqualTo(user.getId()).andIdEqualTo(req.getId());
            result = mapper.updateByExampleSelective(req, example);
        }
        if (result < 1) {
            return JsonResp.databaseInsertError();
        }

        // 更新t_material_file表
        // 1. 将所有matId=req.id的记录标记删除(isDeleted=true)
        adminMapper.deleteMaterialFiles(req.getId());

        // 2. 新增或者标记不删除(replace into, isDeleted=false)
        List<HashMap<String, Object>> imgs = req.getMaterialImgs();
        if (!imgs.isEmpty()) {
            for (HashMap<String, Object> img : imgs) {
                img.put("matId", req.getId());
                img.put("isDeleted", false);
            }
            result = adminMapper.insertMaterialFileList(imgs);
            if (result < 1) {
                return JsonResp.databaseInsertError();
            }
        }
        return JsonResp.success();
    }

    @GetMapping(basePath + "/files")
    public Object getFiles(@RequestParam(name = "id") Integer id) {
        fileExample.clear();
        fileExample.createCriteria().andMatIdEqualTo(id).andIsDeletedEqualTo(false);
        fileExample.setOrderByClause("id asc");
        ItemListResp<MaterialFile> resp = new ItemListResp<>();
        resp.items = fileMapper.selectByExample(fileExample);
        return resp;
    }

    @PostMapping(basePath + "/del")
    public Object delete(@RequestBody Material material) {
        return super.delete(material);
    }
}
