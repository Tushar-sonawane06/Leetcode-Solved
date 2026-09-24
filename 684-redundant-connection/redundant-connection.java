class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];

            boolean[] visited=new boolean[n+1];

            if(helper(u,v,graph,visited)){
                return edge;
            }

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return new int[0];
    }
    public boolean helper(int u,int v,List<List<Integer>> graph,boolean[] visited){
        if(u==v){
            return true;
        }

        visited[u]=true;

        for(int neighbour:graph.get(u)){
            if(!visited[neighbour]){
                if(helper(neighbour,v,graph,visited)){
                    return true;
                }
            }
        }
        return false;
    }
}