class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list= new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }

        for(int[] prerequisite:prerequisites){
            int course=prerequisite[0];
            int pre=prerequisite[1];

            list.get(pre).add(course);
        }

        int[] state = new int[numCourses];

        List<Integer> ans = new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            if(state[i]==0){
                if(helper(i,list,ans,state)){
                    return new int[0];
                }
            }
        }

        Collections.reverse(ans);

        int[] answer=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            answer[i]=ans.get(i);
        }

        return answer;
    }
    public boolean helper(int i,List<List<Integer>> list, List<Integer> ans,int[] state){
        if(state[i]==1){
            return true;
        }
        if(state[i]==2){
            return false;
        }

        state[i]=1;

        for(int neighbour:list.get(i)){
            if(helper(neighbour,list,ans,state)){
                return true;
            }
        }

        state[i]=2;

        ans.add(i);

        return false;
    }
}