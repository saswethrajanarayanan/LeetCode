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
    public void flatten(TreeNode root) {
        List<Integer> result = new ArrayList();
        btrack(result, root);
        if(result.size() == 0 || result.size() == 1) {
            return;
        }
        TreeNode rooter = new TreeNode();
        rooter = root;
        for(int i = 1; i < result.size(); ++i) {
            TreeNode rootNew = new TreeNode(result.get(i));
            root.right = rootNew;
            root.left = null;
            root = rootNew;
        }
        root = rooter;
    }
    private void btrack(List<Integer> result, TreeNode root) {
        if(root == null) {
            return;
        }
        result.add(root.val);
        btrack(result, root.left);
        btrack(result, root.right);
    }
}