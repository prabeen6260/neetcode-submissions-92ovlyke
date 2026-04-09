class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq=new int[26];
        Queue<Integer> pq = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        Deque<int[]> q= new ArrayDeque<>();
        for(int i=0;i<tasks.length;i++){
            int index=tasks[i]-'A';
            freq[index]++;
        }
        for(int i=0;i<freq.length;i++)if(freq[i]!=0)pq.offer(freq[i]);
        int ans=0;
        while(!q.isEmpty() || !pq.isEmpty()){
            ans++;
            if (!pq.isEmpty()) {
            int remain = pq.poll() - 1;
            if (remain > 0) {
                q.offer(new int[]{remain, ans + n});
                }
            }       

            if (!q.isEmpty() && q.peek()[1] == ans) {
                pq.offer(q.poll()[0]);
            }
        }
        return ans;
    }
}
