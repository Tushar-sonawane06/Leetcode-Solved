class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        combinational(target,candidates,ans,0,new ArrayList<>());

        return ans;
    }

    public static void combinational(int target, int[] candidates,List<List<Integer>> ans,int index, List<Integer> current){
        if(target==0){
            ans.add(new ArrayList<>(current));
            return;
        }

        if(target<0 || index==candidates.length){
            return;
        }

        current.add(candidates[index]);

        combinational(target-candidates[index],candidates,ans,index,current);

        current.remove(current.size()-1);

        combinational(target,candidates,ans,index+1,current);

    }
}