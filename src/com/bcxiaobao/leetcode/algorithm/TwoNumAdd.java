package com.bcxiaobao.leetcode.algorithm;

/**
 * Created by IntelliJ IDEA.
 * User: lianxiaobao
 * Date: 2019-12-03
 * Time: 14:47
 */

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 */
public class TwoNumAdd {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(0);
        ListNode offset = start;

        int carry =0;
        while (l1 != null || l2 !=null || carry!=0){
            //求和
            int valuel1 = (l1 !=null) ? l1.val: 0;
            int valuel2 = (l2 !=null) ? l2.val: 0;
            int sum = valuel1 + valuel2 + carry;
            //进位更新
            carry = sum/10;
            //求和后的该位值
            ListNode sumnode = new ListNode(sum % 10);
            offset.next = sumnode;
            offset = sumnode;

            //将l1、l2 进行下个位的运算
            if( l1 != null){
                l1 = l1.next;
            }
            if( l2 != null){
                l2 = l2.next;
            }
        }
        return start.next;
    }



}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }
}
