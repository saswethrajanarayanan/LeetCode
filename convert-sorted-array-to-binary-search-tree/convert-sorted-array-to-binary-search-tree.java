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
    public TreeNode sortedArrayToBST(int[] nums) {
        int left = 0;
        if(nums.length == 0) return null;
        int right = nums.length - 1;
        int mid = left + (right - left) / 2;
        int value = nums[mid];
        TreeNode root = new TreeNode();
        root.val = value;
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);
        return root;
    }
    private TreeNode dfs(int[] nums, int left, int right) {
        if(right < 0 || left > nums.length - 1) return null;
        
        if(left > right) return null;
        
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode();
        root.val = nums[mid];
            
        root.left = dfs(nums, left, mid - 1);
        root.right = dfs(nums, mid + 1, right);
        
        return root;
    }
}
