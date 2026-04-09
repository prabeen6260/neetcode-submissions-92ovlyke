class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        
        List<List<Integer>> ans= new ArrayList<>();
        for(int i=0;i<n;i++){
            int j=i+1;
            int k =n-1;
            int target = -nums[i];
            if(i>0 && nums[i]==nums[i-1])continue;
            while(j<k){
                if(nums[j]+nums[k]<target){
                    j++;
                    }
                else if(nums[j]+nums[k]>target){
                    k--;
                    }
                else if(nums[j]+nums[k]==target){
                    ans.add(new ArrayList<>(Arrays.asList(nums[i],nums[j],nums[k])));
                    j++;
                    k--;
                    while(j<k && nums[j]==nums[j-1])j++;
                    while(j<k && nums[k]==nums[k+1])k--;
                }
            }
        }
        return ans;
    }
}
