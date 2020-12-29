package cn.supertao.linked;

import cn.supertao.help.ListNode;

import java.util.StringJoiner;

/**
 * @author shidt
 * @date 2020/12/21 20:07
 *
 */
public class LinkedAlg {

    public static void main(String[] args) {
        final LinkedAlg alg = new LinkedAlg();

        final ListNode node1 = new ListNode(1);
        final ListNode node2 = new ListNode(2);
        final ListNode node3 = new ListNode(3);
        final ListNode node4 = new ListNode(4);
        final ListNode node5 = new ListNode(5);
        final ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node6.next = node6;

        node1.print();

        // alg.print(alg.reverse1(node1));
        // alg.print(alg.reverse2(node1));
        // alg.print(alg.reverseN(node1, 3));
        alg.reverseN(node1, 3).print();


    }


    /**
     * 反转从位置m到n的链表，请使用一趟扫描完成
     * input:1 2 3 4 5  m,n=2,4
     * output:1 4 3 2 5
     *
     * 索引从1开始
     *
     *  循环
     *
     */
    private ListNode reverse1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode curr, next, pre;
        curr = next =  head;
        pre = null;


        while (curr != null) {
           next = curr.next;

           curr.next = pre;
           pre = curr;
           curr = next;
        }

        return pre;
    }


    /**
     * 递归
     *
     */
    private ListNode reverse2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        final ListNode last = reverse2(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }

    ListNode successor = null;

    /**
     * 递归
     *
     */
    private ListNode reverseN(ListNode head, int n) {
        if ( n ==1 ) {
            successor = head.next;
            return head;
        }

        final ListNode last = reverseN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;

        return last;
    }
    /**
     * 递归
     *
     */
    private ListNode reverseBetween(ListNode head, int start, int end) {
        if(head == null || head.next == null) {
            return head;
        }
        final ListNode last = reverse2(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }


    /**
     * 递归
     *
     */
    private void print(ListNode head) {

    }


}
