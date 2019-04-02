package com.huachen.demo.leetcode.hard;

import org.junit.Assert;
import org.junit.Test;

/**
 * 寻找两个数组的中位数。。这应该是道简单题。。
 */
public class findMedianSortedArraysTest {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        int cur = 0;
        int[] num = new int[nums1.length + nums2.length];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                num[cur++] = nums1[i++];
            } else {
                num[cur++] = nums2[j++];
            }
        }
        while (i < nums1.length) {
            num[cur++] = nums1[i++];
        }
        while (j < nums2.length) {
            num[cur++] = nums2[j++];
        }

        if (num.length == 0)
            return 0;

        if (num.length % 2 == 0) {
            return (double) (num[(num.length - 1) / 2] + num[num.length / 2]) / 2;
        } else {
            return (double) num[num.length / 2];
        }
    }

    @Test
    public void findMedianSortedArraysTest() {
        Assert.assertEquals(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}), 2.0, 0.01);
        Assert.assertEquals(findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}), 2.5, 0.01);
        Assert.assertEquals(findMedianSortedArrays(new int[]{}, new int[]{}), 0, 0.01);

    }

}
