package com.test.utiil;

import java.util.UUID;

public class UUIDUtil {
    public static String createID(){
        String s = UUID.randomUUID().toString();
        s = s.replaceAll("-","");
        return s;
    }
}
