package com.test.utiil;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SecurityUtil {

    public static String encrypt(String src){
        try {
            //创建消息摘要实例对象
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            //摘要
            byte[] a =md5.digest(src.getBytes());
            StringBuilder sd = new StringBuilder();
            for(int i = 0;i < a.length;i++){
                int x = (int)a[i]&0xff;
                //加盐
                x = x + 1;
                if(x < 16){
                    sd.append(0);
                }
                sd.append(Integer.toHexString(x));
            }
            return sd.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
//    测试md5加密代码
//    public static void main(String[] args) {
//
//        System.out.println(encrypt("abc"));
//    }
}
