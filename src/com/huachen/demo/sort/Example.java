package com.huachen.demo.sort;

/**
 * 升序排序模板
 */
abstract class Example {
    static void sort(Comparable[] comparables) {
        
    }

    static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    static void exch(Comparable[] comparables, int i, int j) {
        Comparable t = comparables[i];
        comparables[i] = comparables[j];
        comparables[j] = t;
    }

    static void show(Comparable[] comparables) {
        for (Comparable comparable : comparables) {
            System.out.print(comparable + " ");
        }
        System.out.println();
    }

    static boolean isSorted(Comparable[] comparables) {
        // 测试数组是否有序
        for(int i = 0; i < comparables.length; i++) {
            if(less(comparables[i], comparables[i - 1]))
                return false;
        }
        return true;
    }

}
