class Solution {
    public int[] getOrder(int[][] tasks) {
        int n=tasks.length;
        Integer[] index=new Integer[n];
        for(int i=0;i<n;i++){
            index[i]=i;
        }
        Arrays.sort(index,(a,b)->tasks[a][0]==tasks[b][0]?Integer.compare(a,b):Integer.compare(tasks[a][0],tasks[b][0]));
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[0]==b[0]?Integer.compare(a[1],b[1]):Integer.compare(a[0],b[0]));
        int currTime=tasks[index[0]][0];
        int i=0;
        int x=0;
        int[] ans=new int[n];
        while(i<n || !pq.isEmpty()){
            while(i<n && tasks[index[i]][0]<=currTime){
                pq.add(new int[]{tasks[index[i]][1],index[i]});
                i++;
                
            }
            if(!pq.isEmpty()){
                int[] val=pq.poll();
                ans[x]=val[1];
                currTime+=val[0];
                x++;
            }
            else if(pq.isEmpty()){
                currTime=tasks[index[i]][0];
            }
        }
        return ans;
    }
}