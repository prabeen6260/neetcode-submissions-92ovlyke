class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ans=0;
        int totalRemain=0;
        int total=0;
        for(int i=0;i<gas.length;i++){
            total+=gas[i]-cost[i];
            totalRemain+=gas[i]-cost[i];
            if(total<0){
                total=0;
                ans=i+1;
            }
        }
        return totalRemain<0?-1:ans;
    }
}
