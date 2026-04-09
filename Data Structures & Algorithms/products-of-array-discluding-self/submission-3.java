class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] prefix=new int[n];
        int[] suffix=new int[n];
        Arrays.fill(suffix,1);        
        Arrays.fill(prefix,1);
        for(int i=1;i<n;i++){
            prefix[i]=nums[i-1]*prefix[i-1];
            suffix[n-i-1]=suffix[n-i]*nums[n-i];
        }
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=prefix[i]*suffix[i];
        }
        return ans;
    }
}  
