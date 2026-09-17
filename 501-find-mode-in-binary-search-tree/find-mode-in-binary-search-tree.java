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
    Integer prev=null;
    int count=0;
    int maxcount=0;
    List<Integer> list=new ArrayList<>();
    public int[] findMode(TreeNode root) {
        helper(root);
        int[] ans = new int[list.size()];

        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }

        return ans;
    }
    public void helper(TreeNode root){
        if(root==null){
            return;
        }

        helper(root.left);

        if(prev==null || root.val!=prev){
            count=1;
        }else{
            count++;
        }

        if(count>maxcount){
            maxcount=count;
            list.clear();
            list.add(root.val);
        }else if(count==maxcount){
            list.add(root.val);
        }

        prev=root.val;

        helper(root.right);
    }
}