package com.huachen.demo.sort;

/**
 * 选择排序
 * 运行时间与输入无关&数据移动是最少的(N)
 * N^2/2次移动和N次交换
 */
public class Selection extends Example {
    public static void sort(Comparable[] comparables) {
        int length = comparables.length;
        for(int i = 0; i < length; i++) {
            // 最小元素的索引
            int min = i;
            // 将comparables[i]与后续中最小的元素交换
            for(int j = i + 1; j < length; j++) {
                if(less(comparables[j], comparables[min])) {
                    min = j;
                }
                exch(comparables, i, min);
            }
        }
    }

    public static void main(String[] args) {
        Comparable[] comparables = new Comparable[]{1,2,9,4,2,67,13,864,342,64,123,5784,347,64,24,112};
        sort(comparables);
        show(comparables);
    }
}
