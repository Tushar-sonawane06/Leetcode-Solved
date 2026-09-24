class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph=new ArrayList<>();

        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] prerequisite:prerequisites){
            int u=prerequisite[0];
            int v=prerequisite[1];

            graph.get(v).add(u);
        }

        int[] state=new int[numCourses];

        for(int i=0;i<numCourses;i++){
            if(helper(i,graph,state)){
                return false;
            }
        }

        return true;
    }

    public boolean helper(int i,List<List<Integer>> graph,int[] state){
        if(state[i]==1){
            return true;
        }

        if(state[i]==2){
            return false;
        }

        state[i]=1;

        for(int neighbour:graph.get(i)){
            if(helper(neighbour,graph,state)){
                return true;
            }
        }

        state[i]=2;

        return false;
    }
}