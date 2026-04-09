class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n =numbers.length;
        int l=0;
        int r=n-1;
        int[] ans =new int[2];
        for(int i=0;i<n;i++){
            if(i>0 && numbers[i]==numbers[i-1])continue;
            if(numbers[l]+numbers[r]>target)r--;
            else if(numbers[l]+numbers[r]<target)l++;
            else {
                ans[0]=l+1;
                ans[1]=r+1;
            }
        }
        return ans;
    }
}
