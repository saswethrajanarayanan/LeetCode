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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList();
        getInorder(result, root);
        return result;
    }
    private void getInorder(List<Integer> result, TreeNode root) {
        if(root == null) {
            return;
        }
        getInorder(result, root.left);
        result.add(root.val);
        getInorder(result, root.right);
    }
}
