class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start=1;
        int end= maxElem(piles);

        while(start<=end){
            int mid=start+(end-start)/2;
            long totalhrs = totalhrs(piles, mid);

            if(totalhrs<=h){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return start;
    }

    public long totalhrs(int[] piles, int mid){
        long total=0;
        for(int i=0;i<piles.length;i++){
            total+= (piles[i]+mid-1)/mid;  
        }
        return total;
    }

    public int maxElem(int[] piles){
        int max=0;
        for(int i=0;i<piles.length;i++){
            max= Math.max(max,piles[i]);
        }
        return max;
    }
}