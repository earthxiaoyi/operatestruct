package com.trainingcamp.week5;

/**
 * trie树的基本实现
 * <p>
 * 特性：
 * 1.节点本身不存储完整的单词
 * 2.从根节点到某一节点，路径上经过的字符连起来为该节点对应的字符串
 * 3.每个节点所代表的子节点路径代表的字符都不相同
 * <p>
 * <p>
 * 核心思想：
 * 1.trie数的核心思想是空间换时间。
 * 2.利用字符串的公共前缀来降低查询时间的开销以达到提高效率的目的。
 *
 * @author jiaming
 */
public class Trie {

    private boolean isEnd;
    private Trie[] next;

    public Trie() {
        this.isEnd = false;
        this.next = new Trie[26];
    }

    /**
     * 公式：（单词-'a'）得到一个数字，把单词转换成trie树数组的的下标
     *
     * @param word
     */
    public void insert(String word) {
        if (word == null || word.length() == 0) {
            return;
        }
        Trie curr = this;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int n = chars[i] - 'a';
            if (curr.next[n] == null) {
                curr.next[n] = new Trie();
            }
            curr = curr.next[n];
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        Trie trie = searchPrefix(word);
        return trie != null && trie.isEnd;
    }

    public Trie searchPrefix(String word) {
        Trie node = this;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            node = node.next[chars[i] - 'a'];
            if (node == null) {
                return null;
            }
        }
        return node;
    }

}
