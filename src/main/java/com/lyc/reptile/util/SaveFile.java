package com.lyc.reptile.util;

import java.io.*;

public class SaveFile {
    /**
     * 将输入流的数据保存到文件中
     * @param file 保存位置
     * @param inputStream 数据
     * @throws IOException
     * @author lyc
     */
    public static final void save(File file, InputStream inputStream) throws IOException {
        OutputStream outputStream = new FileOutputStream(file);
        byte[] bytes = new byte[8192];
        int len = -1;
        while ((len = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }
}
