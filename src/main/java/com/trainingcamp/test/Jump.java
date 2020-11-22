package com.trainingcamp.test;

/**
 * @author jiaming
 */
public class Jump {

    public int jump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int step = 0; // 跳了多少步
        int cur = 0; // step步内，右边界
        int next = 0;// step+1步内，右边界
        for (int i = 0; i < nums.length; i++) {
            if (cur < i) {
                step++;
                cur = next;
            }
            next = Math.max(next, i + nums[i]);
        }
        return step;
    }

}
