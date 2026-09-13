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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }

        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int currentLevel = queue.size();
            List<Integer> subresult = new ArrayList<>();
            
            for(int i=0;i<currentLevel;i++){
                TreeNode currentElement = queue.poll();
                subresult.add(currentElement.val);
                if(currentElement.left!=null){
                    queue.offer(currentElement.left);
                }
                if(currentElement.right!=null){
                    queue.offer(currentElement.right);
                }
            }
            result.add(subresult);
        }
        return result;
    }
}