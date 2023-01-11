package com.lyc.reptile.factory;

import com.lyc.reptile.service.Reptile;
import com.lyc.reptile.service.impl.ImageReptileImpl;
import com.lyc.reptile.service.impl.SaveWebFileExecutor;

import java.util.List;
import java.util.regex.Pattern;

/**
 * 爬虫工厂
 */
public class ReptileFactory {
    /**
     * 根据爬取网页图片
     * @param url 网页
     * @param dir 存放目录，注意末尾不加斜杠
     */
    public static final void readWebImageAndSave(String url, String dir) {
        ImageReptileImpl imageReptile = new ImageReptileImpl("jpg");
        List<String> list = imageReptile.reptile(url);
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).contains("http") && list.get(i).substring(0, 2).equals("..")) {
                list.set(i, list.get(i).replaceFirst("\\.\\.", url.replaceFirst("(?<=http(.{1,2})?//(.{1,64})?)/.*","")));
            }
        }
        SaveWebFileExecutor saveWebFileExecutor = new SaveWebFileExecutor(dir);
        saveWebFileExecutor.executor(list);
    }
}
