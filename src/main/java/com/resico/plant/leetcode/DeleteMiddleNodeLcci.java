package com.resico.plant.leetcode;
//若链表中的某个节点，既不是链表头节点，也不是链表尾节点，则称其为该链表的「中间节点」。
//
// 假定已知链表的某一个中间节点，请实现一种算法，将该节点从链表中删除。 
//
// 例如，传入节点 c（位于单向链表 a->b->c->d->e->f 中），将其删除后，剩余链表为 a->b->d->e->f 
//
// 
//
// 示例： 
//
// 
//输入：节点 5 （位于单向链表 4->5->1->9 中）
//输出：不返回任何数据，从链表中删除传入的节点 5，使链表变为 4->1->9
// 
//
// 
// Related Topics 链表 
// 👍 108 👎 0


public class DeleteMiddleNodeLcci {
    public static void main(String[] args) {
        Solution solution = new DeleteMiddleNodeLcci().new Solution();

        ListNode listNode = new ListNode(4);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(9);
        listNode.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        solution.deleteNode(listNode);

    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public void deleteNode(ListNode node) {

            node.val=node.next.val;
            node.next=node.next.next;

        }
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}