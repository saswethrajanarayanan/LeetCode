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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        int count = 0;
        ListNode temp = head;
        if(head == null) {
            return null;
        }
        while(temp != null) {
            count++;
            temp = temp.next;
        }
        temp = head;
        List<Integer> list = new ArrayList();
        for(int i = 0; i < count; ++i) {
            list.add(temp.val);
            temp = temp.next;
        }
        TreeNode root = new TreeNode();
        int left = 0;
        int right = list.size() - 1;
        int midpoint = left + (right - left) / 2;
        root.val = list.get(midpoint);
        root.left = buildTree(list, 0, midpoint - 1);
        root.right = buildTree(list, midpoint + 1, list.size() - 1);
        return root;
    }
    private TreeNode buildTree(List<Integer> list, int left, int right) {
        if(left > list.size() - 1 || right < 0){
            return null;
        }
        if(left > right) {
            return null;
        }
        int midpoint = left + (right - left) / 2;
        TreeNode root = new TreeNode();
        root.val = list.get(midpoint);
        root.left = buildTree(list, left, midpoint - 1);
        root.right = buildTree(list, midpoint + 1, right);
        return root;
    }
}