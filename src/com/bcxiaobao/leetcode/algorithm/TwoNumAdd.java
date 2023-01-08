package com.bcxiaobao.leetcode.algorithm;

/**
 * Created by IntelliJ IDEA.
 * User: lianxiaobao
 * Date: 2019-12-03
 * Time: 14:47
 */

import javax.sound.midi.Soundbank;

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


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
        System.out.println(start.next);
        return start.next;
    }


    /**
     *  * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     *  * 输出：7 -> 0 -> 8
     *  * 原因：342 + 465 = 807
     *  思路
     * 标签：链表
     * 将两个链表看成是相同长度的进行遍历，如果一个链表较短则在前面补 000，比如 987 + 23 = 987 + 023 = 1010
     * 每一位计算的同时需要考虑上一位的进位问题，而当前位计算结束后同样需要更新进位值
     * 如果两个链表全部遍历完毕后，进位值为 111，则在新链表最前方添加节点 111
     * 小技巧：对于链表问题，返回结果为头结点时，通常需要先初始化一个预先指针 pre，该指针的下一个节点指向真正的头结点 head。使用预先指针的目的在于链表初始化时无可用节点值，而且链表构造过程需要指针移动，进而会导致头指针丢失，无法返回结果。
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumber(ListNode l1, ListNode l2) {
       ListNode listNode1 = new ListNode(0);
       ListNode offset = listNode1;

       int carry = 0;
       while (l1 != null || l2 != null || carry !=0){
           int val1 = 0;
           int val2 = 0;
           if (l1 != null){
               val1 = l1.val;
           }else {
               val1 = 0;
           }
           if (l2 != null){
               val2 = l2.val;
           }else {
               val2 = 0;
           }
           int sunmadd = val1 + val2 + carry;
           ListNode sumnode = new ListNode(sunmadd % 10);
           if (sunmadd < 10){
               carry = 0;
           }else {
               carry = 1;
           }
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

        System.out.println(listNode1);
       return listNode1.next;
    }


    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.endAdd(l1, 3);
        l1.endAdd(l1, 4);

        ListNode l2 = new ListNode(5);
        l2.endAdd(l2, 4);
        l2.endAdd(l2, 6);

//        System.out.println(addTwoNumbers(l1, l2));
        System.out.println(addTwoNumber(l1, l2));
    }




}


class ListNode {
    ListNode head;
    int val;
    ListNode next;
    ListNode() {

    }
    ListNode(int x) {
        val = x;
    }

    public ListNode endAdd(ListNode l, int x){
        ListNode l1 = new ListNode(x);
        l1.next  = head;
        head = l1;
        l.next = head;
        return l;
    }
}
