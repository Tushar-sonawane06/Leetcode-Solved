class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> res = new ArrayList<>();

        if(n==0){
            return res;
        }
        if(n==1){
            res.add(0);
            return res;
        }

        List<List<Integer>> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }

        int[] degree = new int[n];

        for(int[] e:edges){
            degree[e[0]]++;
            degree[e[1]]++;

            list.get(e[0]).add(e[1]);
            list.get(e[1]).add(e[0]);
        }

        Queue<Integer> q=new LinkedList<>();

        for(int i=0;i<n;i++){
            if(degree[i]==1){
                q.add(i);
            }
        }

        while(n>2){
            int size=q.size();
            n-=size;

            while(size-->0){
                int v=q.poll();
                for(int i:list.get(v)){
                    degree[i]--;
                    if(degree[i]==1){
                        q.add(i);
                    }
                }
            }
        }

        res.addAll(q);
        return res;
    }
}