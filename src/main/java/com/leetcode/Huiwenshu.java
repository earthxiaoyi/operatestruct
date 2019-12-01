package com.leetcode;

/**
 * Created by jiaming on 2018/11/24.
 */
public class Huiwenshu {

    public boolean isPalindrome(int x) {

        return false;
    }

    public static void main(String[] args) {
        SingleLinkList singleLinkList = new SingleLinkList();
        for(int i=1;i<10;i++){
            singleLinkList.insert(i);
        }
        singleLinkList.displayList();
        singleLinkList.reverse();
        System.out.println("========");
        singleLinkList.displayList();
    }


}
