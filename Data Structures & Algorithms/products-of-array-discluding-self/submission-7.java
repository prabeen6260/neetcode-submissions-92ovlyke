class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] prefix=new int[n];
        Arrays.fill(prefix,1);
        for(int i=1;i<n;i++){
            prefix[i]=nums[i-1]*prefix[i-1];
        }
        int temp=1;
        for(int i=n-1;i>=0;i--){
            prefix[i]=temp*prefix[i];
            temp=nums[i]*temp;
        }
        return prefix;
    }
}  
