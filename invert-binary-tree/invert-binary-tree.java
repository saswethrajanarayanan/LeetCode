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
    TreeNode firstnode = new TreeNode();
    TreeNode secondnode = new TreeNode();
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        btrack(root);
        return root;
    }
    
    private void btrack(TreeNode root) {
        if(root == null) {
            return;
        }
        
        btrack(root.left);
        btrack(root.right);
        
        TreeNode temp = new TreeNode();
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        return;
        
        
    }
}
