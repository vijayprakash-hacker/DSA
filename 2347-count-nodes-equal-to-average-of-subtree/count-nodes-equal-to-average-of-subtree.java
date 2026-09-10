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
    class Info {
        int sum;
        int countNodes;
        int countAvg;

        Info(int sum, int countNodes, int countAvg) {
            this.sum = sum;
            this.countNodes = countNodes;
            this.countAvg = countAvg;
        }
    }
    public int averageOfSubtree(TreeNode root) {
        return averageCount(root).countAvg;
    }

    private Info averageCount(TreeNode root) {
        if(root == null) return new Info(0, 0, 0);

        Info left = averageCount(root.left);
        Info right = averageCount(root.right);

        int sum = left.sum + right.sum + root.val;
        int countNodes = left.countNodes + right.countNodes + 1;
        int countAvg = left.countAvg + right.countAvg;
        if(sum / countNodes == root.val)  countAvg++;


        return new Info(sum, countNodes, countAvg);
    }
}