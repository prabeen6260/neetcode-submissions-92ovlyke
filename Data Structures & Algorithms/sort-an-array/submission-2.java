class Solution {
    public int[] sortArray(int[] nums) {
        int n=nums.length;
        int[] temp=new int[n];
        divide(nums,0,n-1,temp);
        return nums;
    }
}
private void divide(int[] nums, int l, int r, int[] temp){
    if(l>=r)return;
    int mid=l+(r-l)/2;
    divide(nums,l,mid,temp);
    divide(nums,mid+1,r,temp);
    merge(nums,l,mid,r,temp);
}
private void merge(int[] nums, int l, int m, int r, int[] temp){
    int i=l;
    int j=m+1;
    int k=0;
    while(i<=m && j<=r){
        if(nums[i]<=nums[j]){
            temp[k]=nums[i];
            i++;
            k++;
        }
        else{
            temp[k]=nums[j];
            j++;
            k++;
        }
    }
    while(i<=m){
        temp[k]=nums[i];
        i++;
        k++;
    }
    while(j<=r){
        temp[k]=nums[j];
        j++;
        k++;
    }
    for(int x=0;x<k;x++){
        nums[x+l]=temp[x];
    }
}