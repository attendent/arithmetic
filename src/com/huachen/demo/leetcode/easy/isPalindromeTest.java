package com.huachen.demo.leetcode.easy;

import org.junit.Test;

import java.util.Stack;

/**
 * 判断回文
 */
public class isPalindromeTest {
    private boolean isPalindrome1(int x) {
        if (x < 0)
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

    private boolean isPalindrome2(int x) {
        if (x < 0)
            return false;

        int dev = 0;
        int m = x;
        while(m != 0) {
            dev = dev * 10 + m % 10;
            m /= 10;
        }
        return dev == x;
    }

    /**
     * 字符的一个回文判断方法，可以不用考虑奇偶性
     * @param s
     * @return
     */
    private boolean isPalindrome(String s) {
        int L = (s.length() -1) / 2, R = s.length() / 2;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L == s.length() + 1;
    }


    @Test
    public void isPalindromeTest() {
        System.out.println(isPalindrome(String.valueOf(123321)));
        System.out.println(isPalindrome(String.valueOf(1122)));
        System.out.println(isPalindrome(String.valueOf(121)));

    }
}
