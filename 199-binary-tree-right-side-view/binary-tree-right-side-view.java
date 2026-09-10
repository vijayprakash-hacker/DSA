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
    int count = -1;
    public void preorder(TreeNode root, int level, List<Integer> list) { 
            if(root == null) {
                return;
            }
            if(level > count) {
                list.add(root.val);
                count = level;
            }
            preorder(root.right, level + 1, list);
            preorder(root.left, level + 1, list);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, 0, list);
        return list;
    }
}