class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int sold=0;
        int rest=0;
        int hold=-prices[0];
        for(int i=1;i<n;i++){
            int prev_rest=rest;
            int prev_hold=hold;
            int prev_sold=sold;
            hold=Math.max(prev_hold,prev_rest-prices[i]);
            sold=prices[i]+prev_hold;
            rest=Math.max(prev_sold,prev_rest);
        }
        return Math.max(sold,rest);
    }
}
