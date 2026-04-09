class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int ans1=0;
        int ans2=0;
        int ans3=0;
        for(int[] triplet: triplets){
            int num1=triplet[0];
            int num2=triplet[1];
            int num3=triplet[2];
            if(num1<=target[0] && num2<=target[1] && num3<=target[2]){
                ans1=Math.max(num1,ans1);
                ans2=Math.max(num2,ans2);
                ans3=Math.max(num3,ans3);
            }
        }
        if(ans1!=target[0] || ans2!=target[1] || ans3!=target[2])return false;
        return true;
    }
}
