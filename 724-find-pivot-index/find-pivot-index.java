class Solution {
    public int pivotIndex(int[] nums) {
        int total = calTotal(nums);
        int prefix=0;
        int suffix=0;
        for(int i=0;i<nums.length;i++){
            suffix= total-nums[i]-prefix;
            if(prefix==suffix){
                return i;
            }
            prefix+=nums[i];

        }
        return -1;
    }
    public int calTotal(int[] nums){
        int total = 0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
        }
        return total;
    }
}