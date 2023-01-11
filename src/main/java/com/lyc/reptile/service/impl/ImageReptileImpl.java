package com.lyc.reptile.service.impl;

import com.lyc.reptile.service.Reptile;
import com.lyc.reptile.util.ReaderHTMLDocument;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ImageReptileImpl implements Reptile<String> {
    private Pattern pattern;

    public ImageReptileImpl(String suffix) {
        if (suffix.equals("jpg")) {
            pattern = Pattern.compile("(?<=<img src=\").*?\\.jpg(?=\")");
        } else if (suffix.equals("png")) {
            pattern = Pattern.compile("(?<=<img src=\").*?\\.png(?=\")");
        } else if (suffix.equals("gif")) {
            pattern = Pattern.compile("(?<=<img src=\").*?\\.gif(?=\")");
        }
    }
    @Override
    public List<String> reptile(String url) {
        if (pattern == null) {
            return null;
        }
        List<String> result = new ArrayList<>();
        try {
            String document = ReaderHTMLDocument.read(url);
            Matcher matcher = pattern.matcher(document);
            while (matcher.find()) {
                result.add(matcher.group());
            }
        } catch (IOException ignored) { }
        return result;
    }
}
