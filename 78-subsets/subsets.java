class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        backtracking(nums,ans,0,new ArrayList<>());

        return ans;
    }

    public static void backtracking(int[] nums,List<List<Integer>> ans,int index,List<Integer> subset){
        ans.add(new ArrayList<>(subset));

        for(int i=index;i<nums.length;i++){
            subset.add(nums[i]);

            backtracking(nums,ans,i+1,subset);

            subset.remove(subset.size()-1);
        }
    }


}