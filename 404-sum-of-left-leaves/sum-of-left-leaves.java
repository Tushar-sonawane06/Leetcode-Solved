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
    int ans=0;
    public int sumOfLeftLeaves(TreeNode root) {
        if(root==null){
            return 0;
        }

        helper(root,false);
        return ans;
    }
    public void helper(TreeNode root,boolean isLeft){
        if(root==null){
            return;
        }
        
        if(root.left==null && root.right==null && isLeft){
            ans+=root.val;
            return;
        }

        helper(root.left,true);
        helper(root.right,false);

    }
}