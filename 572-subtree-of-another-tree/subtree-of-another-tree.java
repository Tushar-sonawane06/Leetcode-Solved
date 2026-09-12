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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (subRoot == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        return subtree(root, subRoot);
    }

    public boolean subtree(TreeNode root, TreeNode subroot) {

        if (root == null) {
            return false;
        }

        if (root.val == subroot.val) {
            if (isIdentical(root, subroot)) {
                return true;
            }
        }

        return subtree(root.left, subroot) ||
               subtree(root.right, subroot);
    }

    public boolean isIdentical(TreeNode root, TreeNode subroot) {

        if (root == null && subroot == null) {
            return true;
        }

        if (root == null || subroot == null) {
            return false;
        }

        if (root.val != subroot.val) {
            return false;
        }

        if (!isIdentical(root.left, subroot.left)) {
            return false;
        }

        if (!isIdentical(root.right, subroot.right)) {
            return false;
        }

        return true;
    }
}