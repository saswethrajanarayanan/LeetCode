/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = new ListNode();
        ListNode temp2 = new ListNode();
        temp1 = l1;
        temp2 = l2;
        int carry = 0;
        ListNode temp2Last = new ListNode();
        while(temp1 != null && temp2 != null) {
            int value = temp1.val + temp2.val + carry;
            temp2.val = value % 10;
            carry = value / 10;
            temp1 = temp1.next;
            temp2Last = temp2;
            temp2 = temp2.next;
        }
        if(temp1 != null) {
            while(temp1 != null) {
                int number = temp1.val + carry;
                ListNode nodeNew = new ListNode(number % 10);
                carry = number / 10;
                temp2Last.next = nodeNew;
                temp2Last = nodeNew;
                temp1 = temp1.next;
            }
        }
        if(temp2 != null) {
            while(temp2 != null) {
                int num = temp2.val + carry;
                temp2.val = num % 10;
                carry = num / 10;
                temp2Last = temp2;
                temp2 = temp2.next;
            }
        }
        if(carry != 0) {
            ListNode temp3 = new ListNode(carry);
            temp2Last.next = temp3;
            temp3.next = null;
        }
        return l2;
    }
}