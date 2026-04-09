class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum=0;
        int costSum=0;
        for(int i=0;i<gas.length;i++){
            gasSum+=gas[i];
            costSum+=cost[i];
        }
        if(gasSum<costSum)return -1;
        int total=0;
        int ans=0;
        for(int i=0;i<gas.length;i++){
            total+=gas[i]-cost[i];
            if(total<0){
                total=0;
                ans=i+1;
            }
        }
        return ans;
    }
}
