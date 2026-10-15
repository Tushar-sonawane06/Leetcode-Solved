class Solution {
    public int halveArray(int[] nums) {
        double sum=0.0;

        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int num:nums){
            sum+=num;
            pq.offer((double) num);
        }

        double reduced=0.0;
        int operations=0;

        while(reduced<sum/2.0){
            double largest=pq.poll();

            double half=largest/2.0;

            reduced+=half;
            pq.offer(half);

            operations++;
        }

        return operations;
    }
}