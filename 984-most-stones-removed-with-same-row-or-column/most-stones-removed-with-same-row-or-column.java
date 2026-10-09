class Solution {
    int[] parent;
    int[] size;
    public int removeStones(int[][] stones) {
        int n=stones.length;

        parent = new int[n];
        size = new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }

        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(stones[i][0]==stones[j][0] || stones[i][1]==stones[j][1]){
                    union(i,j);
                }
            }
        }

        int components=0;

        for(int i=0;i<n;i++){
            if(find(i)==i){
                components++;
            }
        }

        return n-components;
    }
    public int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    public void union(int x,int y){
        int rootX = find(x);
        int rootY = find(y);

        if(rootX==rootY){
            return;
        }

        if(size[rootX]<size[rootY]){
            parent[rootX]=rootY;
            size[rootY]+=size[rootX];
        }else{
            parent[rootY]=rootX;
            size[rootX]+=size[rootY];
        }
    }
}