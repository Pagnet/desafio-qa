package br.com.blue.util;

import org.apache.commons.lang3.StringUtils;

import java.nio.file.Paths;

public final class PathUtils {

    public static String getPath(String path){
        if(StringUtils.isEmpty(path)){
            throw new RuntimeException(" Path " + path + " invalido ");
        }

        String fullPath = Paths.get(System.getProperty("user.dir"), path).toString();

        return fullPath;
    }

}
