package com.huachen.demo.first;

public class GCD {
    /**
     * 计算两个非负整数的最大公约数
     */
    private static int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        int r = p % q;
        return gcd(q, r);
    }

    public static void main(String[] args) {
        System.out.println(gcd(100, 20));
    }
}
