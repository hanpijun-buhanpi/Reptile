package com.lyc.reptile.service;

import java.util.List;

/**
 * 爬取数据后的执行类的接口
 * @param <T> 爬取到的数据类型
 * @author lyc
 */
public interface Executor<T> {
    void executor(List<T> data);
}
