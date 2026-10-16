class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map= new HashMap<>();

        for(char task:tasks){
            map.put(task,map.getOrDefault(task,0)+1);
        }

        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());

        for(int freq:map.values()){
            pq.add(freq);
        }

        Queue<int[]> cooldown = new LinkedList<>();
        int time=0;

        while(!pq.isEmpty() || !cooldown.isEmpty()){
            time++;

            if(!cooldown.isEmpty() && cooldown.peek()[1]==time){
                pq.offer(cooldown.poll()[0]);
            }

            if(!pq.isEmpty()){
                int freq=pq.poll();

                freq--;

                if(freq>0){
                    cooldown.offer(new int[]{freq,time+n+1});
                }
            }
        }
        return time;
    }
}