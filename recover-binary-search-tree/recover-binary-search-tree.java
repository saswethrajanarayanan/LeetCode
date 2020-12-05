/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    TreeNode first = null;
    TreeNode second = null;
    TreeNode prevNode = null;
    public void recoverTree(TreeNode root) {
        btrack(root);
        swap(first, second);
    }
    private void btrack(TreeNode root) {
        if(root == null) return;
        
        btrack(root.left);
        if(prevNode != null && prevNode.val > root.val) {
            second = root;
            if(first == null) {
                first = prevNode;
            }
            else return;
        }
        prevNode = root;
        btrack(root.right);
    }
    private void swap(TreeNode a, TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
}
