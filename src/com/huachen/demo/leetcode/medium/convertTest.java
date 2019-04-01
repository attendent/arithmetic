package com.huachen.demo.leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Z型变换
 */
public class convertTest {

    /**
     * 代码有点多，还是一开始没考虑好
     */
    public String convertSuccess(String s, int numRows) {
        char[] c = s.toCharArray();
        char[][] t = new char[numRows][s.length()];
        int r = 0, line = 0;
        for (int i = 0; i < s.length(); i++) {
            if (r == 0) {
                for (; r < numRows; r++) {
                    if (i == s.length())
                        break;
                    t[r][line] = c[i++];
                    if (r == numRows - 1)
                        i--;
                }
                line++;
            } else {
                if ((r -= 2) <= 0) {
                    i--;
                    r = 0;
                    continue;
                }
                for (; r > 0; r--) {
                    if (i == s.length())
                        break;
                    t[r][line++] = c[i++];
                    if (r == 1)
                        i--;
                }
            }
        }

        String result = "";
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < line; j++) {
                if (t[i][j] != 0) {
                    result += String.valueOf(t[i][j]);
                }
            }
        }
        return result;
    }

    /**
     * 使用StringBuilder来连接字符串，减少了使用数组所需要的空间，字符串拼接效率也有所提高
     * 最后是忽略掉空字符，可以在最后直接拼所有的StringBuilder
     */
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        // 这样可以直接忽略空字符，减少了很多判断
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1)
                goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows)
            ret.append(row);
        return ret.toString();

    }


    @Test
    public void covertTest() {
        Assert.assertEquals(convert("", 0), "");
        Assert.assertEquals(convert("LEETCODEISHIRING", 3), "LCIRETOESIIGEDHN");
        Assert.assertEquals(convert("LEETCODEISHIRING", 4), "LDREOEIIECIHNTSG");
        Assert.assertEquals(convert("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS", 10), "SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
        Assert.assertEquals(convert("AB",1), "AB");
        Assert.assertEquals(convert("ABC", 2), "ACB");
    }
}
