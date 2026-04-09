class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int buy=prices[0];
        for(int i=1;i<prices.length;i++){
            buy=Math.min(buy,prices[i]);
            ans=Math.max(ans,prices[i]-buy);
        }
        return ans;

    }
}
