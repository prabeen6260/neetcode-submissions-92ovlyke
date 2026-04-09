class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        for(char c:tasks)freq[c-'A']++;
        PriorityQueue<Integer>pq = new PriorityQueue<>((a,b)->(Integer.compare(b,a)));
        for(int i=0;i<26;i++){
            if(freq[i]>0)pq.add(freq[i]);
        }
        Queue<int[]> q=new ArrayDeque<>();
        int cycle=0;
        while(!pq.isEmpty() || !q.isEmpty()){
            cycle++;
            if(!pq.isEmpty()){
                int val=pq.poll();
                val--;
                if(val>0)q.offer(new int[]{cycle,val});
            }
            if(!q.isEmpty() && cycle-q.peek()[0]==n){
                int[] qVal=q.poll();
                pq.add(qVal[1]);
            }
        }
        return cycle;
    }
}
