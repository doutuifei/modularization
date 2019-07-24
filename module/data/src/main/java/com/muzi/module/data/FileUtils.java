package com.muzi.module.data;

import com.muzi.annotation.utils.StringUtils;

import java.io.File;

/**
 * Author: lipeng
 * Date: 2019/7/23
 * Email: lipeng@moyi365.com
 * Content:
 */
public class FileUtils {

    public static String readFile(String filePath) {
        if (StringUtils.isEmpty(filePath))
            return null;
        return readFile(new File(filePath));
    }

    public static String readFile(File file) {
        return null;
    }

}
