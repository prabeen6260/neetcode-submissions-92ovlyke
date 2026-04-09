class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int num:nums)pq.add(num);
        for(int i=1;i<=k;i++){
            if(i==k){
                return pq.poll();
            }
            pq.poll();
        }
        return -1;
    }
}
