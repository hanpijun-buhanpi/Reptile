package com.lyc.reptile.service.impl;

import com.lyc.reptile.service.Reptile;
import com.lyc.reptile.util.ReaderHTMLDocument;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 爬虫接口实现类
 */
public class ReptileImpl implements Reptile<String> {
    private Pattern pattern;

    public ReptileImpl() {

    }

    public ReptileImpl(Pattern pattern) {
        this.pattern = pattern;
    }

    /**
     * 根据正则爬取网页数据并返回
     * @param url 网页url
     * @return 爬取到的数据
     */
    @Override
    public List<String> reptile(String url) {
        List<String> result = new ArrayList<>();
        try {
            String s = ReaderHTMLDocument.read(url);
            if (pattern == null) {
                result.add(s);
                return result;
            }
            Matcher m = pattern.matcher(s);
            while (m.find()) {
                result.add(m.group());
            }
        } catch (IOException ignored) { }
        return result;
    }
}
