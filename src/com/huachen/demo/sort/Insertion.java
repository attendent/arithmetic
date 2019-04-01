package com.huachen.demo.sort;

import com.sun.activation.registries.MailcapParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 插入排序
 */
public class Insertion extends Example {

    public static void sort(Comparable[] comparables) {
        int length = comparables.length;
        for (int i = 0; i < length; i++) {
            // 将comparables[i]插到前续数组中
            for (int j = i; j > 0 && less(comparables[j], comparables[j - 1]); j--) {
                exch(comparables, j, j - 1);
            }
        }
    }

    public static void main(String[] args) {
        Comparable[] comparables = new Comparable[]{1,2,9,4,2,67,13,864,342,64,123,5784,347,64,24,112};
        sort(comparables);
        show(comparables);
    }
}
