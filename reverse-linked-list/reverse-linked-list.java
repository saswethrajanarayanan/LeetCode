/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode left = new ListNode();
        ListNode right = new ListNode();
        if(head == null) return null;
        left = head;
        ListNode temp = new ListNode();
        temp = head;
        HashMap<Integer, ListNode> map = new HashMap();
        int count = 0;
        while(temp != null) {
            count++;
            map.put(count, temp);
            temp = temp.next;
        }
        int total = count;
        right = map.get(count);
        while(left != right && count != total / 2) {
            count--;
            int data = left.val;
            left.val = right.val;
            right.val = data;
            left = left.next;
            right = map.get(count);
        }
        return head;
    }
}
