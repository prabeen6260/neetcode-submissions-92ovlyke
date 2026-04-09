class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((x,y)->Integer.compare(y[0],x[0]));
        if(a>0)pq.add(new int[]{a,0});
        if(b>0)pq.add(new int[]{b,1});
        if(c>0)pq.add(new int[]{c,2});
        StringBuilder ans=new StringBuilder();
        while(!pq.isEmpty()){
            if(ans.length()>=2){
                int j=ans.charAt(ans.length()-1)-'a';
                int i=ans.charAt(ans.length()-2)-'a';
                if(pq.peek()[1]== j && pq.peek()[1]==i){
                    int[] temp=pq.poll();
                    if(pq.isEmpty())return ans.toString();
                    int[] val=pq.poll();
                    ans.append((char)(val[1]+'a'));
                    val[0]--;
                    if(val[0]>0)pq.add(new int[]{val[0],val[1]});
                    pq.add(temp);
                }
                else{
                    int[] val=pq.poll();
                    ans.append((char)(val[1]+'a'));
                    val[0]--;
                    if(val[0]>0)pq.add(new int[]{val[0],val[1]});
                }
            }
            else{
                int[] val=pq.poll();
                ans.append((char)(val[1]+'a'));
                val[0]--;
                if(val[0]>0)pq.add(new int[]{val[0],val[1]});
            }
           
        }
        return ans.toString();
    }
}