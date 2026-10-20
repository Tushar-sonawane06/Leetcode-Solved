class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];

        int prob=1;
        for(int i=0;i<nums.length;i++){
            ans[i]=prob;
            prob=prob*nums[i];
        }
        
        prob=1;
        for(int i=nums.length-1;i>=0;i--){
            ans[i]=ans[i]*prob;
            prob=prob*nums[i];
        }
        return ans;
    }
}