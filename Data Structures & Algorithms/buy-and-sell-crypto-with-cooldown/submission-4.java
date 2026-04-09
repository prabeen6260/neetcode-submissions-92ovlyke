class Solution {
    public int maxProfit(int[] prices) {
        int hold=-prices[0];
        int sold=0;
        int rest=0;
        for(int i=1; i<prices.length;i++){
            int prev_hold=hold;
            int prev_rest=rest;
            int prev_sold=sold;
            hold=Math.max(hold,prev_rest-prices[i]);
            sold=hold+prices[i];
            rest=Math.max(prev_rest,prev_sold);
        }
        return Math.max(rest,sold);
    }
}
