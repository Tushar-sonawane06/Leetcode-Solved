class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int v=graph.length;
        List<List<Integer>> mainGraph = new ArrayList<>();

        for(int i=0;i<v;i++){
            mainGraph.add(new ArrayList<>());
        }

        int[] indegree = new int[v];

        for(int i=0;i<v;i++){
            for(int j:graph[i]){
                mainGraph.get(j).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();

        for(int i=0;i<v;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int node = q.peek();
            q.remove();
            safeNodes.add(node);
            for(int no:mainGraph.get(node)){
                indegree[no]--;
                if(indegree[no]==0){
                    q.add(no);
                }
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
}