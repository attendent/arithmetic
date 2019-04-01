package com.huachen.demo.search;

public class BinarySearch {
    /**
     * 二分查找，数组必须有序且为升序
     */
    private static int rank(int key, int[] ints) {
        int left = 0;
        int right = ints.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (key > ints[mid]) {
                left = mid + 1;
            } else if (key < ints[mid]) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(rank(1, ints));
    }
}
