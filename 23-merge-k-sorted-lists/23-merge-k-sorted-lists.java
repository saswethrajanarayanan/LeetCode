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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode temp = new ListNode();
        temp = null;
        if(lists.length == 0) return null;
        int count = 1;
        ListNode firstNode = new ListNode();
        firstNode = null;
        for(ListNode item : lists) {
            if(item == null) continue;
            if(temp == null) {
                firstNode = item;
            }
            if(temp != null) {
                temp.next = item;
            }
            while(item.next != null) {
                item = item.next;
            }
            temp = item;
        }
        ListNode head = firstNode;
        while(head != null) {
            ListNode node = head.next;
            while(node != null) {
                if(node.val < head.val) {
                    int value = node.val;
                    node.val = head.val;
                    head.val = value;
                }
                node = node.next;
            }
            head = head.next;
        }
        return firstNode;
    }
}