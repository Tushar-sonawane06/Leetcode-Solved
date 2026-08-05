class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans= new ArrayList<>();
        boolean[] check = new boolean[nums.length];

        recursion(nums,ans,check,new ArrayList<>());

        return ans;
    }

    public static void recursion(int[] nums,List<List<Integer>> ans,boolean[] check, List<Integer> subset){
        if(nums.length==subset.size()){
            ans.add(new ArrayList<>(subset));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(check[i]){
                continue;
            }

            subset.add(nums[i]);
            check[i]=true;

            recursion(nums,ans,check,subset);

            subset.remove(subset.size()-1);
            check[i]=false;

        }
    }
}