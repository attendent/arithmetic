package com.huachen.demo.leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。
 * 返回这三个数的和。假定每组输入只存在唯一答案。
 */
public class threeSumClosestTest {

    /**
     * 一开始把minTarget设置为Integer.MAX_VALUE,导致溢出。
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length < 3) {
            return 0;
        }
        int minTarget = nums[0] + nums[1] + nums[2];

        Arrays.sort(nums);
        int len = nums.length;
        for (int left = 0; left <= len - 3; left++) {
            int mid = left + 1;
            int right = len - 1;
            while (mid < right) {
                int sum = nums[left] + nums[mid] + nums[right];
                minTarget = Math.abs(minTarget - target) > Math.abs(sum - target) ? sum : minTarget;

                if (sum < target) {
                    mid++;
                } else if (sum > target)
                    right--;
                else {
                    return target;
                }
            }
        }

        return minTarget == Integer.MAX_VALUE ? 0 : minTarget;
    }

    @Test
    public void threeSumClosestTest() {
        Assert.assertEquals(threeSumClosest(new int[]{1, 1, 1, 0}, 100), 3);
        Assert.assertEquals(threeSumClosest(new int[]{-1, 2, 1, -4}, 1), 2);
        Assert.assertEquals(threeSumClosest(new int[]{1,1,-1,-1,3}, -1), -1);
        Assert.assertEquals(threeSumClosest(new int[]{-3,-2,-5,3,-4}, -1), -2);
    }
}
