class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        if(n==0)return 0;
        Set<Integer>set=new HashSet<>();
        int count=1;
        int maxCount=1;
        for(int num:nums)set.add(num);
        for(int number:nums){
            int num=number;
            if(!set.contains(num-1)){
                while(set.contains(num+1)){
                    count++;
                    num++;
                    maxCount=Math.max(count,maxCount);
                }
            }
            count=1;
        }
        return maxCount;
    }
}
