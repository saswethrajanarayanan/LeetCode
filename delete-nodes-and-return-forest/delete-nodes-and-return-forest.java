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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> result = new ArrayList();
        
        HashSet<Integer> to_del = new HashSet();
        for(int item : to_delete) {
            to_del.add(item);
        }
        root = btrack(root, result, to_del);
        if(root != null) result.add(root);
        return result;
    }
    
    private TreeNode btrack(TreeNode root, List<TreeNode> result, HashSet<Integer> to_del) {
        if(root == null) {
            return null;
        }
        
        root.left = btrack(root.left, result, to_del);
        root.right = btrack(root.right, result, to_del);
        
        if(to_del.contains(root.val)) {
            if(root.left != null) result.add(root.left);
            if(root.right != null) result.add(root.right);
            return null;
        }
        return root;
    }
}
