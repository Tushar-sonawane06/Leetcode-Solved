class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length == 0){
            return false;
        }
        if(nums.length == 1){
            return false;
        }

        Map<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                return true;
            }
            map.put(nums[i],i);
        }
        return false;
    }
}