package com.huachen.demo.leetcode.hard;

import org.junit.Assert;
import org.junit.Test;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p)。实现支持 '.' 和 '*' 的正则表达式匹配。
 */
public class isMatchTest {

    public boolean isMatch(String s, String p) {
        char[] c = s.toCharArray();
        char[] reg = p.toCharArray();
        int j = 0;
        for (int i = 0; i < p.length(); i++) {
            if (reg[i] == '.' && i < p.length() - 1 && reg[i + 1] == '*') {
                j++;
                i--;
            } else if (reg[i] == '.') {
                j++;
            } else if (reg[i] != '*' && i < p.length() - 1 && reg[i + 1] == '*') {
                while (j < c.length) {
                    if (c[j] == c[i]) {
                        j++;
                    }
                }
            } else {
                if ((reg[i] != c[j++])) {
                    return false;
                }
            }
        }
        return (j == s.length() - 1);
    }

    @Test
    public void isMatchTest() {
        Assert.assertFalse(isMatch("mississippi", "mis*is*p*."));
        Assert.assertFalse(isMatch("aa", "a"));

        Assert.assertTrue(isMatch("aa", "a*"));

        Assert.assertTrue(isMatch("ab", ".*"));
        Assert.assertTrue(isMatch("aab", "c*a*b"));


    }
}
