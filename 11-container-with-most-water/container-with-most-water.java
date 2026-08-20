class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int maxArea=0;
        while(i<j){
            int currArea= currArea(i,j,height);
            maxArea = Math.max(currArea,maxArea);
            if(height[i]<height[j]){
                i++;
            }else{
                j--;
            }
        }
        return maxArea;
    }
    public int currArea(int i, int j,int[] height){
        int heightOfWall=Math.min(height[i],height[j]);
        return heightOfWall*(j-i);
    }
}