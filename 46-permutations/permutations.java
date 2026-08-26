class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        boolean[] check=new boolean[nums.length];

        backtracking(ans,new ArrayList<>(),nums,check);

        return ans;
    }

    public void backtracking(List<List<Integer>> ans,List<Integer> subset,int[] nums,boolean[] check){

        if(subset.size()==nums.length){
            ans.add(new ArrayList<>(subset));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(check[i]){
                continue;
            }
            subset.add(nums[i]);
            check[i]=true;
            backtracking(ans,subset,nums,check);
            subset.remove(subset.size()-1);
            check[i]=false;
        }
    }
}