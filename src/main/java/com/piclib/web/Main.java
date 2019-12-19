package com.piclib.web;

import org.im4java.core.ConvertCmd;
import org.im4java.core.IMOperation;

import java.io.File;

// 这个类用来做一些试验
public class Main {
    private ConvertCmd convert = new ConvertCmd(true);

    public static void main(String[] argv) {
        Main main = new Main();
        main.generateImagesByDir("D:\\nginx-1.17.5\\html\\images\\2019-10-30");
        main.generateImagesByDir("D:\\nginx-1.17.5\\html\\images\\2019-11-1");
        main.generateImagesByDir("D:\\nginx-1.17.5\\html\\images\\2019-12-1");
        main.generateImagesByDir("D:\\nginx-1.17.5\\html\\images\\2019-12-2");
        main.generateImagesByDir("D:\\nginx-1.17.5\\html\\images\\2019-12-4");
        main.generateImagesByDir("D:\\nginx-1.17.5\\html\\images\\2019-12-16");
    }

    private void generateImagesByDir(String dir) {
        System.out.println("Process directory: " + dir);
        File file = new File(dir);        //获取其file对象
        File[] fs = file.listFiles();    //遍历path下的文件和目录，放在File数组中
        if (fs == null) {
            return;
        }
        int i = 1;
        for (File f : fs) {                    //遍历File[]数组
            if (f.isFile()) {
                System.out.println(String.format("  File: %d/%d", i++, fs.length));
                createImages(f.getAbsolutePath());
            }
        }
    }

    private void createImage(String origin, int width, int height) {
        try {
            IMOperation op = new IMOperation();
            String size170 = origin.replace(".orin.", String.format(".%dx%d.", width, height));
            op.resize(width, width);
            op.addImage();
            op.addImage();
            convert.run(op, origin, size170);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void createImages(String origin) {
        // 170x170
        createImage(origin, 170, 170);

        // 300x300
        createImage(origin, 300, 300);

        // 768x768
        createImage(origin, 768, 768);

        // 800x800
        createImage(origin, 800, 800);

        // 1000x1000
        createImage(origin, 1000, 1000);

        // 1024x1024
        createImage(origin, 1024, 1024);

        // 1280x1280
        createImage(origin, 1280, 1280);
    }

}
