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
        Queue<Integer> maxHeap = new PriorityQueue<>();
        if(lists.length == 0) {
            return null;
        }
        for(ListNode node : lists) {
            while(node != null) {
                maxHeap.add(node.val);    
                node = node.next;
            }
        }
        if(maxHeap.isEmpty()) return null;
        ListNode prev = new ListNode();
        prev = null;
        ListNode head = new ListNode();
        while(!maxHeap.isEmpty()) {
            ListNode node = new ListNode();
            node.next = null;
            node.val = maxHeap.peek();
            maxHeap.poll();
            if(prev == null) {
                prev = node;
                head = node;
            }
            else {
                prev.next = node;
                prev = node;
            }
        }
        return head;
    }
}