package com.huachen.demo.leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

/**
 * 整数转罗马
 */
public class intToRomanTest {

    /**
     * 在可能性有限的情况下列举出全部可能可以有效降低时间复杂度
     */
    public String intToRoman(int num) {
        int values[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String reps[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        String result = "";

        for (int i = 0; i < 13; i++) {
            if (num >= values[i]) {
                num-=values[i];
                result += reps[i];
                i--;
            }
        }
        return result;
    }

    @Test
    public void intToRomanTest() {
        Assert.assertEquals(intToRoman(0), "");
        Assert.assertEquals(intToRoman(3), "III");
        Assert.assertEquals(intToRoman(4), "IV");
        Assert.assertEquals(intToRoman(9), "IX");
        Assert.assertEquals(intToRoman(58), "LVIII");
        Assert.assertEquals(intToRoman(1994), "MCMXCIV");
    }
}
