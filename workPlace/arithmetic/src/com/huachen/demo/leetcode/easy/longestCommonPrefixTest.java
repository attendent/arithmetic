package com.huachen.demo.leetcode.easy;

import org.junit.Test;

/**
 * 最长的相等字符
 */
public class longestCommonPrefixTest {

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        String temp = "";
        String nexTemp = "";
        int length = Integer.MAX_VALUE;
        for (int i = 0; i < strs.length; i++) {
            length = length < strs[i].length() ? length : strs[i].length();
        }
        if (length == 0)
            return "";
        for (int i = 0; i < length; i++) {
            nexTemp += strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (!strs[j].startsWith(nexTemp)) {
                    return temp;
                }
            }
            temp = nexTemp;
            if (!temp.equals(nexTemp))
                break;
        }
        return temp;
    }

    @Test
    public void testLongestCommonPrefix() {
        System.out.println(longestCommonPrefix(new String[]{"flower","flow","flight"}));
    }
}
