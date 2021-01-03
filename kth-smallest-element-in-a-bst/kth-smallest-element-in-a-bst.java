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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> container = new ArrayList();
        btrack(container, root);
        return container.get(k - 1);
    }
    
    private void btrack(List<Integer> container, TreeNode root) {
        if(root == null) return;
        
        btrack(container, root.left);
        container.add(root.val);
        btrack(container, root.right);
        return;
    }
}
