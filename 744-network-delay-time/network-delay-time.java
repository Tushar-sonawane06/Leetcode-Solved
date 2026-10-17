class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        List<List<int[]>> graph = new ArrayList<>();

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge:times){
            int u=edge[0];
            int v=edge[1];
            int w=edge[2];

            graph.get(u).add(new int[]{v,w});
        }

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k]=0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(a[0],b[0]));

        pq.offer(new int[]{0,k});

        while(!pq.isEmpty()){
            int[] current=pq.poll();

            int currentDist=current[0];
            int node=current[1];

            if(currentDist>dist[node]){
                continue;
            }

            for(int[] neighbour:graph.get(node)){
                int nextNode = neighbour[0];
                int weight = neighbour[1];
                int newDist = currentDist + weight;

                if(newDist<dist[nextNode]){
                    dist[nextNode]=newDist;
                    pq.offer(new int[]{newDist, nextNode});
                }
            }
        }

        int answer=0;

        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}