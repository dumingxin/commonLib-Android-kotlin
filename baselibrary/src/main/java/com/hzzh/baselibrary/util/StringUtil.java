package com.hzzh.baselibrary.util;

import android.text.TextUtils;


/**
 * 字符串工具类
 */
public class StringUtil {

    public static boolean isNullOrEmpty(Object str) {
        if (str == null) {
            return true;
        }
        if (str.toString().length() == 0) {
            return true;

        }
        return false;
    }

    public static boolean isNullOrEmpty(String str) {
        if (str == null) {
            return true;
        }
        if (str.length() == 0) {
            return true;

        }
        return false;
    }


    /**
     * 得到文件url前缀
     *
     * @param type 1 from web; 2 from sdcard; 3 from content; 4 from assets; 5 from drawable
     * @return String url前缀
     */
    public static String getFileUrlHead(int type) {
        switch (type) {
            case 1:
                return "http://";
            case 2:
                return "file://";
            case 3:
                return "content://";
            case 4:
                return "assets://";
            case 5:
                return "drawable://";
        }
        return "";
    }

    /**
     * obj为null时返回空,obj为double时可以设置小数点位数
     *
     * @param obj
     * @param length
     * @return
     */
    public static String toString(Object obj, int length) {
        if (obj == null) {
            return "";
        }
        Class cls = obj.getClass();
        if (cls == Double.class || cls == Float.class) {
            return String.format("%.0" + length + "f", obj);
        }
        return obj + "".trim();
    }

    /**
     * obj为null时返回空,obj为double时可以设置小数点位数
     *
     * @param obj
     * @param length
     * @param defaultValue 默认值
     * @return
     */
    public static String toString(Object obj, int length, String defaultValue) {
        if (obj == null) {
            return defaultValue;
        }
        Class cls = obj.getClass();
        if (cls == Double.class || cls == Float.class) {
            String temp = ".";
            for (int i = 0; i < length; i++) {
                temp += "0";
            }
            if (length == 0) {
                temp = "";
            }
            java.text.DecimalFormat df = new java.text.DecimalFormat("########" + temp);
            return df.format(obj);
        }
        return obj + "";
    }

    /**
     * obj为null时返回空
     *
     * @param obj
     * @return
     */
    public static String toString(Object obj) {
        if (obj == null) {
            return "";
        }
        return obj + "";
    }

    /**
     * 解析浮点型数据
     *
     * @param string 待解析的数据
     * @return float 数据解析结果
     */
    public static float parseFloat(String string) {
        if (TextUtils.isEmpty(string)) {
            return 0;
        }
        try {
            return Float.parseFloat(string);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * 解析浮点型数据
     *
     * @param obj 待解析的数据
     * @return float 数据解析结果
     */
    public static float parseFloat(Object obj) {
        if (obj == null) {
            return parseFloat("");
        } else {
            return parseFloat(obj + "");
        }
    }

    /**
     * 解析Int类型数据
     *
     * @param string 待解析的数据
     * @return int 数据解析结果
     */
    public static int parseInt(String string) {
        if (TextUtils.isEmpty(string)) {
            return 0;
        }
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * 解析Double类型数据
     *
     * @param string 待解析数据
     * @return double 返回结果
     */
    public static double parseDouble(String string) {
        if (TextUtils.isEmpty(string)) {
            return 0;
        }
        try {
            return Double.parseDouble(string);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * 解析长整型数据
     *
     * @param string 待解析数据
     * @return long 返回结果
     */
    public static long parseLong(String string) {
        if (TextUtils.isEmpty(string)) {
            return 0;
        }
        try {
            return Long.parseLong(string);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    /**
     * 解析Boolean类型数据
     *
     * @param string 待解析数据
     * @return boolean 返回结果
     */
    public static boolean parseBoolean(String string) {
        if (TextUtils.isEmpty(string)) {
            return false;
        }
        try {
            return Boolean.parseBoolean(string);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * 截取字符串
     *
     * @param str   待截取字符串
     * @param start 开始位置
     * @return String 截取结果
     */
    public static String subString(String str, int start) {
        if (start >= str.length())
            return str;
        else
            return str.substring(start);
    }

    /**
     * 截取字符串
     *
     * @param str   待截取字符串
     * @param start 开始位置
     * @param end   结束位置
     * @return String 截取结果
     */
    public static String subString(String str, int start, int end) {
        if (TextUtils.isEmpty(str) || start >= str.length() || end >= str.length())
            return str;
        else
            return str.substring(start, end);
    }

    /**
     * 从字符末尾截掉指定的字符
     *
     * @param str
     * @param ch
     * @return
     */
    public static String trim(String str, char ch) {
        if (isNullOrEmpty(str)) {
            return str;
        }
        int len = str.length();
        while (len > 0 && str.charAt(len - 1) == ch) {
            len--;
        }
        return str.substring(0, len);
    }

}
