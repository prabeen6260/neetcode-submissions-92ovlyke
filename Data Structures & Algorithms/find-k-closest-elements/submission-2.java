class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n=arr.length;
        List<Integer> ans = new ArrayList<>();
        if(k>n)return ans;
        int l=0;
        int r=n-1;
        while(r-l+1>k){
            int left=Math.abs(arr[l]-x);
            int right=Math.abs(arr[r]-x);
            if(left<=right){
                r--;
            }
            else l++;
        }
        for(int i=l;i<=r;i++){
            ans.add(arr[i]);
        }
        return ans;
    }
}