package com.leetcode;

import java.util.HashMap;

/**
 * 13. 罗马数字转整数
 * Created by jiaming on 2018/11/24.
 */
public class Solution2 {
    public int romanToInt(String s) {
        int result = 0;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("I",1);
        map.put("V",5);
        map.put("X",10);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);
        for (int i = 0; i <s.length(); i++) {
            String c = s.charAt(i)+"";
            result+=map.get(c);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int iiv = s.romanToInt("IIV");
        System.out.println(iiv);
    }
}
