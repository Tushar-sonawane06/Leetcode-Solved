class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        boolean vis[][] = new boolean[image.length][image[0].length];
        helper(image,sr,sc,color,vis,image[sr][sc]);
        return image;
    }

    public void helper(int[][] image,int sr, int sc, int color,boolean vis[][],int original){
        if(sr<0||sc<0||sr>=image.length||sc>=image[0].length||vis[sr][sc]||image[sr][sc]!=original){
            return;
        }
        vis[sr][sc]=true;
        image[sr][sc]=color;

        helper(image,sr,sc-1,color,vis,original);
        helper(image,sr,sc+1,color,vis,original);
        helper(image,sr-1,sc,color,vis,original);
        helper(image,sr+1,sc,color,vis,original);
    }
}