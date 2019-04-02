package com.huachen.demo.leetcode.medium;


import org.junit.Assert;
import org.junit.Test;

/**
 * 11. 盛最多水的容器
 */
public class maxAreaTest {
    public int maxArea(int[] height) {
        if (height.length == 0)
            return 0;
        int max = 0;
        int L = 0, R = height.length - 1;
        while (L != R) {
            int valueOfL = height[L], valuseOfR = height[R];
            max = Math.max(max, Math.min(valueOfL, valuseOfR) * (R - L));
            if (valueOfL - valuseOfR >= 0) {
                R--;
            } else {
                L++;
            }
        }
        return max;
    }

    @Test
    public void maxAreaTest() {
        Assert.assertEquals(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}), 49);
        Assert.assertEquals(maxArea(new int[]{}), 0);
        Assert.assertEquals(maxArea(new int[]{1}), 0);
    }

}
