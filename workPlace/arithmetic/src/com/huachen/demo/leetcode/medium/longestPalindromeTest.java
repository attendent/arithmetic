package com.huachen.demo.leetcode.medium;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.Vector;

public class longestPalindromeTest {
    /**
     * 超时了
     * 当输入长度较大的相同字符时，会导致多次的循环操作，时间复杂度直升
     * @param s
     * @return
     */
    public String longestPalindromeOverTime1(String s) {
        if (null == s || s.isEmpty())
            return "";
        char[] c = s.toCharArray();
        String result = "";
        for (int i = 0; i < c.length - 1; i++) {
            if(c[i] == c[i + 1]) {
                int j = i + 2;
                String temp = String.valueOf(c[i]) + String.valueOf(c[i + 1]);
                while(j < c.length && 2 * i - j + 1 >= 0 && c[j] == c[2 * i - j + 1]) {
                    temp = String.valueOf(c[j]) + temp + String.valueOf(c[2 * i - j + 1]);
                    j++;
                }
                result = result.length() > temp.length() ? result : temp;
            }
            if(i - 1 >= 0 && c[i - 1] == c[i + 1]) {
                int j = i + 1;
                String temp = String.valueOf(c[i]);
                while (j < c.length && 2 * i - j >= 0 && c[j] == c[2 * i - j]) {
                    temp = String.valueOf(c[j]) + temp + String.valueOf(c[2 * i - j]);
                    j++;
                }
                result = result.length() > temp.length() ? result : temp;
            }
        }
        return result.length() > 1 ? result : String.valueOf(c[0]);
    }

    /**
     * 判断是否是回文串
     */
    private boolean isPalindrome(String x) {
        if (x == null || x.isEmpty())
            return false;

        char[] c = String.valueOf(x).toCharArray();
        Stack<Character> stack = new Stack<>();
        if (c.length % 2 == 0) {
            for (int i = 0; i < c.length; i++) {
                if (stack.contains(c[i]) && stack.peek() == c[i] && stack.size() == c.length - i) {
                    stack.pop();
                } else {
                    stack.push(c[i]);
                }
            }
        } else {
            for (int i = 0; i < c.length; i++) {
                if (stack.contains(c[i]) && stack.size() - 1 == c.length - i) {
                    char temp = stack.pop();
                    if (stack.peek() == c[i]) {
                        stack.pop();
                    }
                    stack.push(temp);
                } else {
                    stack.push(c[i]);
                }
            }
            stack.pop();
        }
        return stack.empty();
    }

    /**
     * 超时了，递归碰到长的没有回文字符串的就很难受
     * @param s
     * @return
     */
    public String longestPalindromeOverTime2(String s) {
        if (!isPalindrome(s)) {
            if (!s.isEmpty()) {
                String s1 = longestPalindromeOverTime2(s.substring(1));
                String s2 = longestPalindromeOverTime2(s.substring(0, s.length() - 1));
                return s1.length() > s2.length() ? s1 : s2;
            }
        } else {
            return s;
        }
        return "";
    }

    public String longestPalindromeOverTime3(String s) {
        if (isPalindrome(s)) {
            return s;
        }

        if (null == s || s.isEmpty())
            return "";

        List<String> queue = new LinkedList<>();
        ((LinkedList<String>) queue).offer(s);
        int i = 0;
        while(!queue.isEmpty()) {
            s = ((LinkedList<String>) queue).poll();
            if (isPalindrome(s)) {
                return s;
            }
            ((LinkedList<String>) queue).offer(s.substring(1));
            ((LinkedList<String>) queue).offer(s.substring(0, s.length() - 1));
        }
        return "";
    }

    /**
     * 中心拓展算法
     */
    public String longestPalindromeSuccess(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }


    /**
     * 马拉车算法
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        if (null == s || s.equals(""))
            return "";
        String t ="$#";
        for(int i = 0 ; i < s.length(); i++) {
            t += s.charAt(i);
            t += "#";
        }
        t += '0';

        // p[]记录每个点为中心的最大回文子串
        int[] p =new int[t.length()];
        // id为能延伸到最右边的的回文子串的中心，mx为它的最右
        int id = 0, mx = 0;
        // resLen为当前最长字串长度，resCenter当前最长字串中心
        int resLen = 0, resCenter = 0;
        // 从1循环是p[0]一定是1,因为t[0]是$


        for(int i = 1; i < t.length() - 1; i++) {
            p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 1;

            while (((i - p[i]) >= 0) && ((i + p[i]) < t.length()-1) && (t.charAt(i + p[i]) == t.charAt(i - p[i]))) {
                p[i]++;
            }
            if(mx < i + p[i]) {
                mx = i + p[i];
                id = i;
            }
            if(resLen < p[i]) {
                resLen = p[i];
                resCenter = i;
            }
        }
        return s.substring((resCenter - resLen) / 2, (resCenter - resLen) / 2 + resLen - 1);
    }

    @Test
    public void longestPalindromeTest() {
        System.out.println(longestPalindrome("12212"));
        System.out.println(longestPalindrome("abcabbca"));
        System.out.println(longestPalindrome("abbaa"));
        System.out.println(longestPalindrome("sadabbbabbb"));
        System.out.println(longestPalindrome("isPalindromeTest"));
        System.out.println(longestPalindrome("ccc"));
        System.out.println(longestPalindrome(""));

    }
}
