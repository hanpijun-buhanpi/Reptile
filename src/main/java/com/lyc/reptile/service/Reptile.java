package com.lyc.reptile.service;

import java.util.List;

/**
 * 爬虫接口
 * @param <T> 爬取的数据类型
 * @author lyc
 */
public interface Reptile<T> {
    List<T> reptile(String url);
}
