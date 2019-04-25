package com.zl.autism.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class MD5 {

    //MD5加密
    public static String md5(String text) throws Exception{
        String encodeStr = DigestUtils.md5Hex(text);
        return encodeStr;
    }

    //md5验证
    public static boolean verify(String text,String md5) throws Exception{
        String md5Text = md5(text);
        if (md5Text.equalsIgnoreCase(md5)){
            return true;
        }
        return false;
    }

}