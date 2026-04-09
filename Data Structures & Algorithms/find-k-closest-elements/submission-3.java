class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n=arr.length;
        List<Integer> ans = new ArrayList<>();
        if(k>n)return ans;
        int l=0;
        int r=n-k;
        while(l<r){
            int mid=l+(r-l)/2;
            if(x-arr[mid]>arr[mid+k]-x){
                l=mid+1;
            }
            else r=mid;
        }
        for(int i=l;i<l+k;i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}