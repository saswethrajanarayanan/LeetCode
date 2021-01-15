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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList();
        queue.offer(new Pair(root, 0));
        int max = 0;
        while(!queue.isEmpty()) {
            Pair<TreeNode, Integer> firstpos = queue.peek();
            Pair<TreeNode, Integer> currpos = null;
            int size = queue.size();
            for(int i = 0; i < size; ++i) {
                currpos = queue.poll();
                int idx = currpos.getValue();
                TreeNode node = currpos.getKey();
                if(node.left != null) queue.offer(new Pair(node.left, 2 * idx));
                if(node.right != null) queue.offer(new Pair(node.right, (2 * idx) + 1));
            }
            max = Math.max(max, currpos.getValue() - firstpos.getValue() + 1);
        }
        return max;
    }
}
