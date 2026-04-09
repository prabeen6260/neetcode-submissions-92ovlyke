class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n=arr.length;
        List<Integer> ans=new ArrayList<>();
        if(k>n)return ans;
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0])==0?Integer.compare(a[1],b[1]):Integer.compare(a[0],b[0]));
        for(int num:arr){
            pq.offer(new int[]{Math.abs(x-num),num});
        }
        for(int i=0;i<k;i++){
            int[] nums=pq.poll();
            ans.add(nums[1]);
        }
        ans.sort((a,b)->Integer.compare(a,b));
        return ans;
    }
}