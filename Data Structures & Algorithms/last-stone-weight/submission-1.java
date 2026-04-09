class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int i=0;i<stones.length;i++)pq.offer(stones[i]);
        while(pq.size()>=2){
            int stone1=pq.poll();
            int stone2=pq.poll();
            if(stone1==stone2)continue;
            else if(stone2<stone1)pq.offer(stone1-stone2);
        }
        return pq.isEmpty()?0:pq.peek();
    }
}
