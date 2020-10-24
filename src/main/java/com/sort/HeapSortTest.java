package com.sort;

import java.util.*;

public class HeapSortTest {

    public static void main(String[] args) {
        //生成10亿个数字
        Map<Integer, Integer> map = new HashMap<>(10000000);
        Random random = new Random();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            int num = random.nextInt(10000000);
            Integer value = map.get(num);
            if (value == null) {
                map.put(num, 1);
            } else {
                map.put(num, value + 1);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("生成数据耗时：" + (end - start));
        //构造数组
        Collection<Integer> values = map.values();
        List<Integer> list = new ArrayList<>(values);
        Integer[] integers = list.toArray(new Integer[list.size()]);
        HeapSort heapSort = new HeapSort();

    }

}
