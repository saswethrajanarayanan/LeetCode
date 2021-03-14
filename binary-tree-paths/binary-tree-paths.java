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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList();
        List<Integer> sub_res = new ArrayList();
        decodePaths(result, sub_res, root);
        return result;
    }
    private void decodePaths(List<String> result, List<Integer> sub_res, TreeNode root) {
        if(root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            sub_res.add(root.val);
            String path = "";
            for(int i = 0; i < sub_res.size() - 1; ++i) {
                path += Integer.toString(sub_res.get(i)) + "->";
            }
            path += Integer.toString(sub_res.get(sub_res.size() - 1));
            result.add(path);
            sub_res.remove(sub_res.size() - 1);
            return;
        }
        sub_res.add(root.val);
        decodePaths(result, sub_res, root.left);
        decodePaths(result, sub_res, root.right);
        sub_res.remove(sub_res.size() - 1);
    }
}