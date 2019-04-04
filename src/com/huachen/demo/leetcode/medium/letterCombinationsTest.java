package com.huachen.demo.leetcode.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombinationsTest {

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if(digits.length()==0){
            return list;
        }
        Map<Character, String[]> map = new HashMap<>();
        map.put('2',new String[]{"a","b","c"});
        map.put('3',new String[]{"d","e","f"});
        map.put('4',new String[]{"g","h","i"});
        map.put('5',new String[]{"j","k","l"});
        map.put('6',new String[]{"m","n","o"});
        map.put('7',new String[]{"p","q","r","s"});
        map.put('8',new String[]{"t","u","v"});
        map.put('9',new String[]{"w","x","y","z"});
        getAllStrs(digits.toCharArray(), map, 0, list, "");
        return list;
    }

    private static void getAllStrs(char[] chars, Map<Character, String[]> map, int index, List<String> list, String temp) {
        String[] s = map.get(chars[index]);
        if (index == chars.length - 1) {
            for (String a : s) {
                list.add(temp + a);
            }
            return;
        }
        for (String a : s) {
            getAllStrs(chars, map, index + 1, list, temp + a);
        }
    }
}
