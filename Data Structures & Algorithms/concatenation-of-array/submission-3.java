class Solution {
    public int[] getConcatenation(int[] nums) {
        int n=nums.length;
        if(n==0)return new int[0];
        int[] ans=new int[2*n];
        for(int i=0;i<n;i++){
            ans[i]=nums[i];
            ans[2*n-1-i]=nums[n-1-i];
        }
        return ans;
    }
}