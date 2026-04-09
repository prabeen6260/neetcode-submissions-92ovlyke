class Solution {
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        if(n<=1)return nums;
        int mid=n/2;
        int[] left=Arrays.copyOfRange(nums,0,mid);
        int[] right=Arrays.copyOfRange(nums,mid,n);
        sortArray(left);
        sortArray(right);
        return merge(nums,left,right);
    }
    private int[] merge(int[] nums,int[] left, int[] right){
        int i=0;
        int j=0;
        int k=0;
        int n=nums.length;
        while(k<n){
            if(i<left.length && j<right.length && left[i]<=right[j]){
                nums[k]=left[i];
                i++;
                k++;
            }
            else if(i<left.length && j<right.length && right[j]<=left[i]){
                nums[k]=right[j];
                j++;
                k++;
            }
            else if (i<left.length){
                nums[k]=left[i];
                i++;
                k++;
            }
            else if(j<right.length){
                nums[k]=right[j];
                k++;
                j++;
            }
        }
        return nums;
    }
}