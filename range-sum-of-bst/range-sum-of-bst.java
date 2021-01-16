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
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        btrack(root, low, high);
        return sum;
    }
    private void btrack(TreeNode root, int low, int high) {
        if(root == null) return;
        
        if(root.val >= low && root.val <= high) {
            sum += root.val;
        }
        
        btrack(root.left, low, high);
        btrack(root.right, low, high);
    }
}
