class Solution {
    public int[] sortArray(int[] nums) {
        int n=nums.length;

        for(int i=n/2-1;i>=0;i--){
            heapify(i,n,nums);
        }

        for(int i=n-1;i>0;i--){
            int temp = nums[0];
            nums[0]=nums[i];
            nums[i]=temp;
            heapify(0,i,nums);
        }

        return nums;
    }
    public void heapify(int i,int size,int[] nums){
        int left=2*i+1;
        int right=2*i+2;
        int maxInt=i;

        if(left<size && nums[left]>nums[maxInt]){
            maxInt=left;
        }
        if(right<size && nums[right]>nums[maxInt]){
            maxInt=right;
        }
        if(maxInt!=i){
            int temp=nums[i];
            nums[i]=nums[maxInt];
            nums[maxInt]=temp;
            heapify(maxInt,size,nums);
        }
        
    }
}