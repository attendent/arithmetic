package com.huachen.demo.leetcode.easy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转化
 */
public class romanToIntTest {
    static Map<Character, Integer> hashMap = new HashMap<>();
    static {
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);
    }

    public int romanToInt(String s) {
        char[] ch = s.toCharArray();
        int sum = 0;
        for (int i = 0; i < ch.length - 1; i++) {
            sum += hashMap.get(ch[i]);
            switch (ch[i]) {
                case 'I': {
                    sum += ch[i + 1] == 'V' || ch[i + 1] == 'X' ? -1 : 0;
                    break;
                }
                case 'X': {
                    sum += ch[i + 1] == 'L' || ch[i + 1] == 'C' ? -10 : 0;
                    break;
                }
                case 'C': {
                    sum += ch[i + 1] == 'D' || ch[i + 1] == 'M' ? -100 : 0;
                    break;
                }
                default:break;
            }
        }
        return sum + hashMap.get(ch[ch.length - 1]);
    }

    @Test
    public void romanToIntTest() {

    }
}
