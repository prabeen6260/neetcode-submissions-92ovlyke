class Solution {
    public int maxProfit(int[] prices) {
        int ans=0;
        int l=prices[0];
        int n=prices.length;
        for(int i=0;i<n;i++){
            l=Math.min(l,prices[i]);
            int profit = prices[i]-l;
            ans=Math.max(ans,profit);
        }
        return ans;
    }
}
