class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        int[] freq = new int[26];
        for(char c: tasks){
            int i= c-'A';
            freq[i]++;
        }
        for(int f:freq){
            if(f>0)pq.offer(f);
        }
        
        int time=0;
        while(!pq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int cycle = n+1;
            while(!pq.isEmpty() && cycle>0){
                int curr = pq.poll();
                if(curr>1){
                    temp.add(curr-1);
                }
                time++;
                cycle--;
            }
            for(int t:temp)pq.offer(t);
            if(!pq.isEmpty()){
                time+=cycle;
            }
        }
        return time;


    }
}
