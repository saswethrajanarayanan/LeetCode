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
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    public List<List<Integer>> findLeaves(TreeNode root) {
        computeLeaves(root, 0);
        return new ArrayList<>(map.values());
    }
    public int computeLeaves(TreeNode root, int layer) {
        if(root == null) {
            return layer;
        }
        int left = computeLeaves(root.left, layer);
        int right = computeLeaves(root.right, layer);
        layer = Math.max(left, right);
        
        if(map.containsKey(layer)) {
            List<Integer> list = map.get(layer);
            list.add(root.val);
            map.put(layer, list);
        }
        else {
            List<Integer> list = new ArrayList<>();
            list.add(root.val);
            map.put(layer, list);
        }
        return layer + 1;
    }
    
}