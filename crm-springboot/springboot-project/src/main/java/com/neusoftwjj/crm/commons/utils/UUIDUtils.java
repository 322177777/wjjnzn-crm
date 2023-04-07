package com.neusoftwjj.crm.commons.utils;

import java.util.UUID;

public class UUIDUtils {
    /**
     * //UUID算法生成ID,不会重复
     */
    public static String getUUID(){
        String uuid= UUID.randomUUID().toString().replaceAll("-","");
        return uuid;
    }
}
