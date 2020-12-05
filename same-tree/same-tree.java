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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return btrack(p, q);
    }
    private boolean btrack(TreeNode p, TreeNode q) {
        if(p == null && q == null) return true;
        
        else if((p == null && q != null) || (p != null && q == null)) return false;
        
        else if(p.val != q.val) return false;
        
        return (btrack(p.left, q.left) && btrack(p.right, q.right));
    }
}
