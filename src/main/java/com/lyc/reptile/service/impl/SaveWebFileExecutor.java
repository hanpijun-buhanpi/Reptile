package com.lyc.reptile.service.impl;

import com.lyc.reptile.service.Executor;
import com.lyc.reptile.util.SaveFile;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * 保存文件执行类
 */
public class SaveWebFileExecutor implements Executor<String> {
    private String path;

    /**
     *
     * @param path 保存位置
     */
    public SaveWebFileExecutor(String path) {
        this.path = path;
    }

    /**
     * 根据图片路径获取图片并保存到文件
     * @param data 认为这里的都是绝对url
     */
    @Override
    public void executor(List<String> data) {
        for (String s : data) {
            File file = null;
            if (s.contains("/")) {
                file = new File(path + s.replaceFirst("http.{1,2}?//.*?(?=/)", ""));
            } else {
                file = new File(path + "\\" +  s);
            }
            try {
                File dir = new File(file.getAbsolutePath().substring(0, file.getAbsolutePath().lastIndexOf("\\")));
                if (!dir.exists()) {
                    dir.mkdirs();
                }
                SaveFile.save(file, new URL(s).openConnection().getInputStream());
                System.out.println(s + " 已保存到 " + file.getAbsoluteFile());
            } catch (IOException e) { e.printStackTrace();}
        }
    }
}
