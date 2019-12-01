package com.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiaming on 2019/8/8.
 */
public class Bag {

    public static void bag(int[] values, int bagWeight, int index, List<Integer> result) {
        if (values.length == index) {
            return;
        }
        if (values[index] > bagWeight) {
            bag(values, bagWeight, ++index, result);
        } else if (values[index] == bagWeight) {
            result.add(values[index]);
            System.out.println(result);
            result.clear();
        } else {
            result.add(values[index]);
            bag(values, bagWeight - values[index], ++index, result);
        }
    }

    public static void main(String[] args) {
        int bagWeight = 10;
        int[] values = new int[]{2, 2, 6, 5, 4};
        for (int i = 0; i < values.length; i++) {
            bag(values,bagWeight,i,new ArrayList<Integer>());
        }
    }

}
