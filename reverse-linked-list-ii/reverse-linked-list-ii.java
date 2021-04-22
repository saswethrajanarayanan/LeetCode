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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode temp = new ListNode();
        temp = head;
        ListNode first = new ListNode();
        HashMap<Integer, ListNode> map = new HashMap();
        int count = 0;
        first = null;
        int pos = 0;
        while(temp != null) {
            pos++;
            if(pos == left) {
                first = temp;
            }
            if(first != null) {
                count++;
                map.put(count, temp);
            }
            if(pos == right) {
                break;
            }
            temp = temp.next;
        }
        if(first == null) {
            first = head;
            temp = head;
            while(temp != null) {
                count++;
                map.put(count, temp);
                temp = temp.next;
            }
        }
        int var = count;
        while(count > var / 2) {
            int data = first.val;
            first.val = map.get(count).val;
            map.get(count).val = data;
            first = first.next;
            count--;
        }
        
        return head;
    }
}