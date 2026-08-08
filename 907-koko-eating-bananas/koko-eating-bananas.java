class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start=1;
        int end= maxInArr(piles);

        while(start<=end){
            int mid= start+(end-start)/2;

            long totalhrs= totalhrs(piles,mid);

            if(totalhrs<=h){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return start;
    }

    public long totalhrs(int[] piles, int h){
        long total=0;

        for(int i=0;i<piles.length;i++){
            total += (piles[i] + h - 1) / h;
        }

        return total;
    }

    public int maxInArr(int[] piles){
        int maxNum=0;

        for(int i=0;i<piles.length;i++){
            maxNum= Math.max(maxNum,piles[i]);
        }

        return maxNum;
    }
}