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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        TreeNode root = new TreeNode();
        if(nums.length == 0) return null;
        int index = 0;
        int max = nums[index];
        for(int i = 0; i < nums.length; ++i) {
            if(nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
        root.val = max;
        root.left = btrack(nums, 0, index - 1);
        root.right = btrack(nums, index + 1, nums.length - 1);
        return root;
    }
    private TreeNode btrack(int[] nums, int left, int right) {
        if(left > right) return null;
        TreeNode root = new TreeNode();
        int max = nums[left];
        int index = left;
        for(int i = left; i <= right; ++i) {
            if(nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
        root.val = max;
        root.left = btrack(nums, left, index - 1);
        root.right = btrack(nums, index + 1, right);
        return root;
        
    }
}
