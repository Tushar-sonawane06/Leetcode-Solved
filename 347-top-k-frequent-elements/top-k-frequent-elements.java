class Solution {
    public class Top implements Comparable<Top>{
        int num;
        int times;

        public Top(int nums,int times){
            this.num=nums;
            this.times=times;
        }

        @Override
        public int compareTo(Top t2){
            return Integer.compare(t2.times, this.times);
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map=new HashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Top> pq = new PriorityQueue<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.offer(new Top(entry.getKey(), entry.getValue()));
        }

        int[] ans=new int[k];

        for(int i=0;i<k;i++){
            ans[i]=pq.poll().num;
        }

        return ans;
    }
}