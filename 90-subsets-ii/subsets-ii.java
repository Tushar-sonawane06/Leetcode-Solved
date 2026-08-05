class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        subsets2(nums,ans,new ArrayList<>(),0);

        return ans;
    }

    public static void subsets2(int nums[],List<List<Integer>> ans, List<Integer> current,int index){

        ans.add(new ArrayList<>(current));

        for(int i=index;i<nums.length;i++){

            if(i>index && nums[i]==nums[i-1]){
                continue;
            }

            current.add(nums[i]);

            subsets2(nums,ans,current,i+1);

            current.remove(current.size()-1);
        }
    }
}