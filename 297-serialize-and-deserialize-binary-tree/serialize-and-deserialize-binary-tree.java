/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();

        helper(root,list);

        return String.join(",", list);
    }

    public void helper(TreeNode root, List<String> list){
        if(root==null){
            list.add("null");
            return;
        }

        list.add(String.valueOf(root.val));

        helper(root.left,list);
        helper(root.right,list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        int[] index={0};
        return helper2(values,index);
    }
    public TreeNode helper2(String[] values, int[] index){
        if(values[index[0]].equals("null")){
            index[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(values[index[0]]));
        
        index[0]++;
        
        node.left=helper2(values,index);
        node.right=helper2(values,index);

        return node;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));