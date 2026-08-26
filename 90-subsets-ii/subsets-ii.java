class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        backtracking(ans,nums,0,new ArrayList<>());
        return ans;
    }

    public void backtracking(List<List<Integer>> ans, int[] nums,int index, List<Integer> subset){
        ans.add(new ArrayList<>(subset));

        for(int i=index;i<nums.length;i++){
            if(i > index && nums[i]==nums[i-1]){
                continue;
            }
            
            subset.add(nums[i]);
            backtracking(ans,nums,i+1,subset);
            subset.remove(subset.size()-1);

        }
    }
}