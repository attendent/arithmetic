package com.qg.enroll.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class FormatUtil {
    /**
     * 字符串判空
     * @param str 字符串
     * @return 不为空返回true
     */
    public static boolean checkNull(String str) {
        return (null != str && !str.equals(""));
    }

    /**
     * 对象判空
     * @param object 对象
     * @return 不为空返回true
     */
    public static boolean checkNull(Object object) {
        return null != object;
    }

    /**
     * 大陆号码或香港号码均可
     */
    public static boolean isPhoneLegal(String str) throws PatternSyntaxException {
        return checkNull(str) && (isChinaPhoneLegal(str) || isHKPhoneLegal(str));
    }

    /**
     * 大陆手机号码11位数，匹配格式：前三位固定格式+后8位任意数
     * 此方法中前三位格式有：
     * 13+任意数
     * 145,147
     * 15+除4的任意数(不要写^4，这样的话字母也会被认为是正确的)
     * 166
     * 17+3,5,6,7,8
     * 18+任意数
     * 198,199
     */
    private static boolean isChinaPhoneLegal(String str) throws PatternSyntaxException {
        // ^ 匹配输入字符串开始的位置
        // \d 匹配一个或多个数字，其中 \ 要转义，所以是 \\d
        // $ 匹配输入字符串结尾的位置
        String regExp = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(166)|(17[3,5,6,7,8])" +
                "|(18[0-9])|(19[8,9]))\\d{8}$";
        return isFormatMatching(str, regExp);
    }

    /**
     * 香港手机号码8位数，5|6|8|9开头+7位任意数
     */
    private static boolean isHKPhoneLegal(String str) throws PatternSyntaxException {
        // ^ 匹配输入字符串开始的位置
        // \d 匹配一个或多个数字，其中 \ 要转义，所以是 \\d
        // $ 匹配输入字符串结尾的位置
        String regExp = "^(5|6|8|9)\\d{7}$";
        return isFormatMatching(str, regExp);
    }

    public static boolean isTimeAndPlace(String str) throws PatternSyntaxException {
        return checkNull(str);
    }

    /**
     * 匹配格式
     * @param message 传入信息
     * @param format 规定格式
     * @return 符合返回true，否则为false
     */
    private static boolean isFormatMatching(String message, String format) {
        Pattern pattern = Pattern.compile(format);
        Matcher matcher = pattern.matcher(message);
        return matcher.matches();
    }

    public static boolean checkGrouper(String str) {
        return checkNull(str) && (str.equals("后台组") || str.equals("前端组") || str.equals("移动组")
                || str.equals("嵌入式组") || str.equals("手游组") || str.equals("设计组") || str.equals("数据挖掘"));
    }

    public static boolean checkSex(String sex) {
        String regExp = "[\"男\",\"女\"]{1}";

        return checkNull(sex) && isFormatMatching(regExp, sex);
    }

    public static boolean checkCurrent(int i) {
        return i > -4 && i < 4;
    }

    public static boolean checkId(String id) {
        String regExp = "\\b311800\\d{4}";

        return checkNull(id) && isFormatMatching(regExp, id);
    }

    @SuppressWarnings("unchecked")
    public static <T> T cast(Object object) {
        return (T)object;
    }

    public static void main(String[] args) {
        String regExp = "[0-4]{1}[.]{1}[0-9]{1}|5.0|[0-5]{1}";
        System.out.println(FormatUtil.isFormatMatching("22222", regExp));

    }
}
