class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map=new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int next=target-nums[i];
            if(map.containsKey(next)){
                return new int[] {map.get(next),i};
            }
            map.put(nums[i],i);
        }

        return new int[] {};
    }
}