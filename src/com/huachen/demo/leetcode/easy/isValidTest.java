package com.huachen.demo.leetcode.easy;

import org.junit.Test;

import java.util.Stack;

/**
 * 括号匹配
 */
public class isValidTest {

    public boolean isValid(String s) {
        // 在已知长度的情况下使用数组模拟栈会更快
        // 对于符号的判断应该分开，这样能有效减少判断的次数
        // 在出现右括号不匹配时即可return false，这里多做了很多不必要的判断
        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < c.length; i++) {
            if (!stack.empty()) {
                if (stack.peek().equals('(') && c[i] == ')' || stack.peek().equals('[') && c[i] == ']' || stack.peek().equals('{') && c[i] == '}')
                    stack.pop();
                else
                    stack.push(c[i]);
            } else {
                stack.push(c[i]);
            }
        }
        return stack.empty();
    }


    @Test
    public void isValidTest() {
        System.out.println(isValid("{}()"));
        System.out.println(isValid("{{()}}"));
        System.out.println(isValid("{}}}{"));
    }
}
