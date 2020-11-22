package com.trainingcamp;

import java.util.LinkedList;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 链表长度 <= 10000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof
 *
 * @author jiaming
 */
public class ReversePrint {

    /**
     * 利用栈来做
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        while (head != null) {
            linkedList.addLast(head.val);
            head = head.next;
        }
        int size = linkedList.size();
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = linkedList.removeLast();
        }
        return res;
    }

    /**
     * 不用栈不用递归的解法
     *
     * @param head
     * @return
     */
    public int[] reversePrint2(ListNode head) {
        if (head == null) {
            return new int[]{};
        }
        int count = 0;
        ListNode node = head;
        while (node != null) {
            count++;
            node = node.next;
        }
        int[] res = new int[count];
        ListNode r = head;
        for (int i = count - 1; i >= 0; i--) {
            res[i] = r.val;
            r = r.next;
        }
        return res;
    }


}
