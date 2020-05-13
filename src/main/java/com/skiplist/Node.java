package com.skiplist;

public class Node {

    int data = -1;
    /**
     * 表示当前节点位置的下一个节点所有层的数据，从上层切换到下层，就是数组下标-1，
     * forwards[3]表示当前节点在第三层的下一个节点。
     */
    Node forwards[];

    /**
     * 这个值其实可以不用，看优化insert()
     */
    private int maxLevel = 0;

    public Node(int level) {
        forwards = new Node[level];
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("{ data: ");
        builder.append(data);
        builder.append("; levels: ");
        builder.append(maxLevel);
        builder.append(" }");
        return builder.toString();
    }

}
