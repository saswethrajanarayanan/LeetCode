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
    TreeNode save = new TreeNode();
    boolean there = false;
    public TreeNode searchBST(TreeNode root, int val) {
        
        btrack(root, val);
        if(!there) return null;
        return save;
    }
    private void btrack(TreeNode root, int val) {
        if(root == null) {
            return;
        }
        if(root.val == val) {
            save = root;
            there = !there;
            return;
        }
        btrack(root.left, val);
        btrack(root.right, val);
    }
}
