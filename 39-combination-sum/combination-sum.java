class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        candidate(candidates,target, 0, new ArrayList<>(),ans);

        return ans;
    }

    public void candidate(int[] candidates, int target, int index, List<Integer> newans, List<List<Integer>> ans){
        if(target==0){
           ans.add(new ArrayList<>(newans));
           return;
        }

        if(target<0 || candidates.length==index){
            return;
        }

        newans.add(candidates[index]);

        candidate(candidates,target-candidates[index], index, newans, ans);

        newans.remove(newans.size()-1);

        candidate(candidates,target, index+1, newans, ans);
    }
}