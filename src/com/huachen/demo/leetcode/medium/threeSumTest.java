package com.huachen.demo.leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ExecutionException;

public class threeSumTest {

    /**
     * 改了一堆检验，千万要注意[]里面可以出现重复值，但{}里面不可以啊,并且一个同一个中心值组成的list并不唯一
     */
    public List<List<Integer>> threeSumOverTime(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 1; i < nums.length - 1; i++) {
            int sum;
            int L = 0, R = nums.length - 1;

            while (L < i && i < R) {
                if ((sum = nums[L] + nums[i] + nums[R]) > 0) {
                    R--;
                } else if (sum < 0) {
                    L++;
                } else {
                    List<Integer> list = Arrays.asList(nums[i], nums[L], nums[R]);
                    if (!lists.contains(list))
                        lists.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    R--;
                    L++;
                }
            }
        }
        return lists;
    }


    /**
     * 这都能超出时间限制？
     */
    public List<List<Integer>> threeSumOverTime2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {

            int L = i + 1, R = nums.length - 1, sum = 0 - nums[i];
            while (L < R) {
                if (nums[L] + nums[R] == sum) {
                    List<Integer> list = Arrays.asList(nums[i], nums[L], nums[R]);
                    if (!lists.contains(list))
                        lists.add(list);
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                } else if (nums[L] + nums[R] < sum) {
                    while (L < R && nums[L] == nums[L + 1]) L++;   // 跳过重复值
                    L++;
                } else {
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    R--;
                }
            }
        }
        return lists;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        HashSet<List<Integer>> hashSet = new HashSet<>();

        Arrays.sort(nums);
        int len = nums.length;
        for (int left = 0; left <= len - 3; left++) {
            int mid = left + 1;
            int right = len - 1;
            while (mid < right) {
                int sum = nums[left] + nums[mid] + nums[right];
                if (sum < 0) {
                    mid++;
                } else if (sum > 0)
                    right--;
                else {
                    List<Integer> list = Arrays.asList(nums[left], nums[mid], nums[right]);
                    hashSet.add(list);
                    mid++;
                    right--;
                }
            }
        }
        if (hashSet.size() != 0) {
            lists.addAll(hashSet);
        }
        return lists;
    }

    @Test
    public void threeSumTest() {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{-1, -1, 0, 0, 1, 1}));
        System.out.println(threeSum(new int[]{0, 0, 0, 0}));
        System.out.println(threeSum(new int[]{0, 0, 0}));
        System.out.println(threeSum(new int[]{3, 0, -2, -1, 1, 2}));
        System.out.println(threeSum(new int[]{0,-4,-1,-4,-2,-3,2}));


    }

}
