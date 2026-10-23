class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        int k=0;

        while(i<nums.length){
            if (nums[i] != nums[k]) {
                k++;
                nums[k]=nums[i];
            }
            i++;
        }

        return k+1;
    }
}