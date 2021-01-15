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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode[] listnew = new ListNode[lists.length];
        int count = 0;
        for(int i = 0; i < lists.length; ++i) {
            if(lists[i] != null) {
                listnew[count] = lists[i];
                count++;
            }
        }
        if(listnew[0] == null) return null;
        
        ListNode head = new ListNode();
        for(int i = 0; i < count; ++i) {
            if(listnew[i] == null) continue; 
            head = listnew[i];
            while(head.next != null) head = head.next;
            if(i == count - 1) {
                head.next = null;
            }
            else head.next = listnew[i + 1];
        }
        
        ListNode output = new ListNode();
        ListNode temp = new ListNode();
        temp = listnew[0];
        while(temp.next != null) {
            output = temp.next;
            System.out.println(output.val);
            while(output != null) {
                if(temp.val > output.val) {
                    int data = temp.val;
                    temp.val = output.val;
                    output.val = data;
                }
                output = output.next;
            }
            temp = temp.next;
        }
        return listnew[0];
    }
}
