package com.neusoftwjj.crm.commons.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 对Date类型的数据格式处理
 */
public class DateUtils {
    /**
     *
     * @param date:"yyyy-MM-dd HH:mm:ss"
     * @return
     */
    public static String formateDateTime(Date date){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr=sdf.format(date);
        return dateStr;
    }
    /**
     *
     * @param date:"yyyy-MM-dd"
     * @return
     */
    public static String formateDate(Date date){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        String dateStr=sdf.format(date);
        return dateStr;
    }
    /**
     *
     * @param date:"HH:mm:ss"
     * @return
     */
    public static String formateTime(Date date){
        SimpleDateFormat sdf=new SimpleDateFormat("HH:mm:ss");
        String dateStr=sdf.format(date);
        return dateStr;
    }

}
